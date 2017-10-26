package controllers;

import com.google.common.io.Files;
import models.Comic;
import models.ComicCreator;
import models.ComicDetail;
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

    private JPAApi jpaApi;

    @Inject
    public ComicController(JPAApi jpaApi)
    {
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getComic(Integer comicId)
    {

        ComicDetail comicDetail = (ComicDetail)jpaApi.em()
                .createNativeQuery("SELECT c.ComicId, t.TitleName as Title, c.RetailPrice, c.MarketPrice, c.IssueNumber, c.Description, p.PublisherName " +
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
                .createNativeQuery("SELECT c.ComicId, t.TitleName as Title, c.RetailPrice, c.MarketPrice, c.IssueNumber, c.Description, p.PublisherName " +
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

        Comic comic = jpaApi.
                em().
                createQuery("SELECT c FROM Comic c WHERE comicId = :id", Comic.class).
                setParameter ("id", comicId).
                getSingleResult();
        if (image != null)
        {
            comic.setImage(image);
        }

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




    public Result getComicSearch()
    {
        return ok(views.html.comicsearch.render());
    }

    public Result getComicStats()
    {
        return ok(views.html.comicstats.render());
    }
}
