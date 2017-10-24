package controllers;

import models.ComicDetail;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

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
                .createNativeQuery("SELECT c.ComicId, t.TitleName as Title, c.RetailPrice, c.MarketPrice, c.IssueNumber, c.Description " +
                        "FROM Comic c " +
                        "JOIN Title t ON c.titleId = t.titleId " +
                        "WHERE comicId = :comicId", ComicDetail.class)
                .setParameter("comicId", comicId)
                .getSingleResult();

        return ok(views.html.comics.render(comicDetail));
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
