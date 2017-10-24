package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class ComicController extends Controller
{
    public Result getComic()
    {
        return ok(views.html.comics.render());
    }

    public Result getComicSearch()
    {
        return ok(views.html.comicsearch.render());
    }
}
