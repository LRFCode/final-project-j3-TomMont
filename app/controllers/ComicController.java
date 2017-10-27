package controllers;

import com.google.common.io.Files;
import models.Comic;
import models.ComicCreator;
import models.ComicDetail;
import models.Publisher;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.io.File;
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

        ComicDetail comicDetail = (ComicDetail)jpaApi.em()
                .createNativeQuery("SELECT c.ComicId, t.TitleName as Title, c.RetailPrice, c.MarketPrice, c.IssueNumber, c.Description, p.PublisherId, p.PublisherName, c.PublicationDate " +
                        "FROM Comic c " +
                        "JOIN Title t ON c.titleId = t.titleId " +
                        "JOIN Publisher p ON p.PublisherId = t.PublisherId " +
                        "WHERE comicId = :comicId", ComicDetail.class)
                .setParameter("comicId", comicId)
                .getSingleResult();

        List<ComicCreator> creators = jpaApi.em()
                .createNativeQuery("SELECT ComicCreatorId, CreatorName " +
                        "FROM ComicCreator cc " +
                        "JOIN Creator c ON c.CreatorId = cc.CreatorId " +
                        "WHERE comicId = :comicId", ComicCreator.class)
                .setParameter("comicId", comicId)
                .getResultList();

        return ok(views.html.comics.render(comicDetail, creators));
    }

    @Transactional(readOnly = true)
    public Result getComicEdit(Integer comicId)
    {

        ComicDetail comicDetail = (ComicDetail)jpaApi.em()
                .createNativeQuery("SELECT c.ComicId, t.TitleName as Title, c.RetailPrice, c.MarketPrice, c.IssueNumber, c.Description, p.PublisherId, p.PublisherName, c.PublicationDate " +
                        "FROM Comic c " +
                        "JOIN Title t ON c.titleId = t.titleId " +
                        "JOIN Publisher p ON p.PublisherId = t.PublisherId " +
                        "WHERE comicId = :comicId", ComicDetail.class)
                .setParameter("comicId", comicId)
                .getSingleResult();

        List<ComicCreator> creators = jpaApi.em()
                .createNativeQuery("SELECT ComicCreatorId, CreatorName " +
                        "FROM ComicCreator cc " +
                        "JOIN Creator c ON c.CreatorId = cc.CreatorId " +
                        "WHERE comicId = :comicId", ComicCreator.class)
                .setParameter("comicId", comicId)
                .getResultList();
        List<Publisher> publishers = jpaApi.
                em().
                createQuery("SELECT p FROM Publisher p", Publisher.class).
                getResultList();

        return ok(views.html.comicedit.render(comicDetail, creators));
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
        }
        catch (Exception e)
        {
            image = null;
        }

        DynamicForm form = formFactory.form().bindFromRequest();
        String name = form.get("name");
        int publisherId = Integer.parseInt(form.get("publisherId"));

        Comic comic = jpaApi.
                em().
                createQuery("SELECT c FROM Comic c WHERE comicId = :id", Comic.class).
                setParameter ("id", comicId).
                getSingleResult();
        if (image != null && image.length > 0)
        {
            comic.setImage(image);
        }

        comic.setPublisherId(publisherId);

        jpaApi.em().persist(comic);

        return ok("Saved Comic");
    }

    @Transactional(readOnly=true)
    public Result getComicImage(int comicId)
    {
        Comic comic = jpaApi.em().createQuery("SELECT c FROM Comic c WHERE comicId = :id", Comic.class).
                setParameter("id", comicId).getSingleResult();

        if(comic.getImage() == null)
        {
            return null;
        }
        else
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
                createNativeQuery("SELECT ComicId, TitleName AS Title, IssueNumber, " +
                        "RetailPrice, MarketPrice, Description, publisherName, PublicationDate, publisherId " +
                         "FROM Comic c " +
                        "JOIN Title t ON c.titleId = t.titleId " +
                        "JOIN Publisher p ON t.publisherId = p.publisherId " +
                        "WHERE TitleName LIKE :searchname",
                        ComicDetail.class).setParameter("searchname", searchCriteria).getResultList();
        return ok(views.html.comicsearch.render(comicDetail));
    }

    public Result getComicStats()
    {
        return ok(views.html.comicstats.render());
    }
}
