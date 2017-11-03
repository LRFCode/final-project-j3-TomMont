package controllers;

import com.google.common.io.Files;
import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import scala.concurrent.java8.FuturesConvertersImpl;

import javax.inject.Inject;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ComicController extends Controller
{
    private FormFactory formFactory;
    private JPAApi jpaApi;

    @Inject
    public ComicController(FormFactory formFactory, JPAApi jpaApi)
    {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getComic(Integer comicId)
    {

        ComicDetail comicDetail = (ComicDetail) jpaApi.em()
                .createNativeQuery("SELECT c.ComicId, t.TitleName, t.TitleId, c.RetailPrice, c.MarketPrice, c.IssueNumber, c.Description, p.PublisherId, p.PublisherName, c.PublicationDate, cc.conditionId, cc.conditionName " +
                        "FROM Comic c " +
                        "JOIN Title t ON c.titleId = t.titleId " +
                        "JOIN Publisher p ON p.PublisherId = t.PublisherId " +
                        "JOIN ComicCondition cc ON c.ConditionId = cc.ConditionId " +
                        "WHERE comicId = :comicId", ComicDetail.class)
                .setParameter("comicId", comicId)
                .getSingleResult();

        List<ComicCreator> creators = jpaApi.em()
                .createNativeQuery("SELECT cc.ComicCreatorId, c.CreatorName, cc.ComicId " +
                        "FROM ComicCreator cc " +
                        "JOIN Creator c ON c.CreatorId = cc.CreatorId " +
                        "WHERE comicId = :comicId", ComicCreator.class)
                .setParameter("comicId", comicId)
                .getResultList();

        return ok(views.html.comics.render(comicDetail, creators));
    }

    @Transactional(readOnly = true)
    public Result getComicAdd()
    {


        List<ComicCreator> creators = jpaApi.em()
                .createNativeQuery("SELECT CreatorId AS ComicCreatorId, CreatorName, CreatorId AS ComicId " +
                        "FROM Creator cc ",
                        ComicCreator.class)
                .getResultList();

        List<ComicTitle> comicTitle = jpaApi.
                em().
                createQuery("SELECT t FROM ComicTitle t ORDER BY TitleName", ComicTitle.class).
                getResultList();

        List<ComicCondition> comicConditions = jpaApi.
                em().
                createQuery("SELECT cc FROM ComicCondition cc", ComicCondition.class).
                getResultList();

        List<Publisher> publisher = jpaApi.
                em().
                createQuery("SELECT p FROM Publisher p", Publisher.class).
                getResultList();

        return ok(views.html.comicadd.render(creators, comicConditions, comicTitle, publisher));
    }

    @Transactional
    public Result postComicAdd()
    {
        Http.MultipartFormData<File> formData = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart<File> filePart = formData.getFile("filename");
        File file = filePart.getFile();

        byte[] image;

        try
        {
            image = Files.toByteArray(file);
        } catch (Exception e)
        {
            image = null;
        }

        DynamicForm form = formFactory.form().bindFromRequest();


        String description = form.get("description");
        int issueNumber = Integer.parseInt(form.get("issueNumber"));
        int conditionId = Integer.parseInt(form.get("conditionId"));
        BigDecimal retailPrice = new BigDecimal(form.get("retailPrice"));
        BigDecimal marketPrice = new BigDecimal(form.get("marketPrice"));
        int titleId = Integer.parseInt(form.get("titleId"));
        String formattedDate = form.get("publicationDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date publicationDate;

        try
        {
            publicationDate = sdf.parse(formattedDate);
        } catch (Exception e)
        {
            publicationDate = null;
        }

        Comic comic = new Comic();

        if (image != null && image.length > 0)
        {
            comic.setImage(image);
        }
        comic.setConditionId(conditionId);
        comic.setDescription(description);
        comic.setRetailPrice(retailPrice);
        comic.setMarketPrice(marketPrice);
        comic.setPublicationDate(publicationDate);
        comic.setTitleId(titleId);
        comic.setIssueNumber(issueNumber);

        jpaApi.em().persist(comic);

        String creatorIds[] = request().body().asMultipartFormData().asFormUrlEncoded().get("creators[]");

        for (String creatorId : creatorIds)
        {
            ComicCreatorLink comicCreator = new ComicCreatorLink();
            comicCreator.setComicId(comic.getComicId());
            comicCreator.setCreatorId(Integer.parseInt(creatorId));
            jpaApi.em().persist(comicCreator);
        }

        return redirect(routes.ComicController.getComicSearch());
    }

    @Transactional(readOnly = true)
    public Result getComicEdit(Integer comicId)
    {

        ComicDetail comicDetail = (ComicDetail) jpaApi.em()
                .createNativeQuery("SELECT c.ComicId, t.TitleName, t.TitleId, c.RetailPrice, c.MarketPrice, c.IssueNumber, c.Description, p.PublisherId, p.PublisherName, c.PublicationDate, cc.ConditionId, cc.ConditionName " +
                        "FROM Comic c " +
                        "JOIN Title t ON c.titleId = t.titleId " +
                        "JOIN Publisher p ON p.PublisherId = t.PublisherId " +
                        "JOIN ComicCondition cc ON c.ConditionId = cc.ConditionId " +
                        "WHERE comicId = :comicId", ComicDetail.class)
                .setParameter("comicId", comicId)
                .getSingleResult();

        List<ComicCreator> creators = jpaApi.em()
                .createNativeQuery("SELECT cc.ComicCreatorId, c.CreatorName, cc.ComicId " +
                        "FROM ComicCreator cc " +
                        "JOIN Creator c ON c.CreatorId = cc.CreatorId " +
                        "WHERE comicId = :comicId", ComicCreator.class)
                .setParameter("comicId", comicId)
                .getResultList();

        List<ComicTitle> comicTitle = jpaApi.
                em().
                createQuery("SELECT t FROM ComicTitle t ORDER BY TitleName", ComicTitle.class).
                getResultList();

        List<ComicCondition> comicConditions = jpaApi.
                em().
                createQuery("SELECT cc FROM ComicCondition cc", ComicCondition.class).
                getResultList();

        return ok(views.html.comicedit.render(comicDetail, creators, comicConditions, comicTitle));
    }

    @Transactional
    public Result postComicEdit(Integer comicId)
    {
        final Http.MultipartFormData<File> formData = request().body().asMultipartFormData();
        final Http.MultipartFormData.FilePart<File> filePart = formData.getFile("filename");
        final File file = filePart.getFile();

        byte[] image;

        try
        {
            image = Files.toByteArray(file);
        } catch (Exception e)
        {
            image = null;
        }

        DynamicForm form = formFactory.form().bindFromRequest();
        String description = form.get("description");
        int issueNumber = Integer.parseInt(form.get("issueNumber"));
        int conditionId = Integer.parseInt(form.get("conditionId"));
        BigDecimal retailPrice = new BigDecimal(form.get("retailPrice"));
        BigDecimal marketPrice = new BigDecimal(form.get("marketPrice"));
        String formattedPublicationDate = form.get("publicationDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date publicationDate;
        int titleId = Integer.parseInt(form.get("titleId"));


        try
        {
            publicationDate = sdf.parse(formattedPublicationDate);
        } catch (Exception e)
        {
            publicationDate = null;
        }


        Comic comic = jpaApi.
                em().
                createQuery("SELECT c FROM Comic c WHERE comicId = :id", Comic.class).
                setParameter("id", comicId).
                getSingleResult();
        if (image != null && image.length > 0)
        {
            comic.setImage(image);
        }

        comic.setConditionId(conditionId);
        comic.setDescription(description);
        comic.setRetailPrice(retailPrice);
        comic.setMarketPrice(marketPrice);
        comic.setPublicationDate(publicationDate);
        comic.setTitleId(titleId);
        comic.setIssueNumber(issueNumber);

        jpaApi.em().persist(comic);

        return redirect(routes.ComicController.getComicSearch());
    }

    @Transactional(readOnly = true)
    public Result getComicImage(int comicId)
    {
        Comic comic = jpaApi.em().createQuery("SELECT c FROM Comic c WHERE comicId = :id", Comic.class).
                setParameter("id", comicId).getSingleResult();

        if (comic.getImage() == null)
        {
            return null;
        } else
        {
            return ok(comic.getImage()).as("image.jpg");
        }
    }

    @Transactional
    public Result getComicSearch()
    {
        DynamicForm form =
                formFactory.form().bindFromRequest();
        String searchCriteria = form.get("searchcriteria");

        if (searchCriteria == null)
        {
            searchCriteria = "";
        }

        searchCriteria = "%" + searchCriteria + "%";

        List<ComicDetail> comicDetail = jpaApi.
                em().
                createNativeQuery("SELECT ComicId, t.TitleName, t.TitleId, IssueNumber, " +
                                "RetailPrice, MarketPrice, Description, publisherName, PublicationDate, p.publisherId, cc.conditionId, cc.conditionName " +
                                "FROM Comic c " +
                                "JOIN Title t ON c.titleId = t.titleId " +
                                "JOIN Publisher p ON t.publisherId = p.publisherId " +
                                "JOIN ComicCondition cc ON c.ConditionId = cc.ConditionId " +
                                "WHERE TitleName LIKE :searchname " +
                                "ORDER BY TitleName, IssueNumber",
                        ComicDetail.class).setParameter("searchname", searchCriteria).getResultList();
        return ok(views.html.comicsearch.render(comicDetail));
    }

    @Transactional(readOnly = true)
    public Result getComicStats()
    {
        ComicStats comicStats = new ComicStats();
        comicStats.setNumberOfComics(49);

        jpaApi.em().createNativeQuery("SELECT COUNT(*) AS ComicCount FROM Comics").getSingleResult();

        return ok(views.html.comicstats.render(comicStats));
    }

    @Transactional(readOnly = true)
    public Result getComicTitleAdd()
    {
        return ok("did it");
    }

    @Transactional(readOnly = true)
    public Result postComicTitleAdd()
    {
        return ok("did it");
    }


}
