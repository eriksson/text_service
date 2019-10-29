package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.routing.JavaScriptReverseRouter;

public class ApplicationController extends Controller {
    public Result index(Http.Request request){
        return ok(views.html.index.render(request));
    }

    public Result javascriptRoutes(Http.Request request) {
        return ok(JavaScriptReverseRouter.create(
                        "jsRoutes",
                        "jQuery.ajax",
                        request.host(),
                        routes.javascript.API.getKMostFrequent()))
                .as(Http.MimeTypes.JAVASCRIPT);
    }
}
