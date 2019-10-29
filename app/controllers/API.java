package controllers;

import api.StringUtils;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class API extends Controller {
    @BodyParser.Of(BodyParser.Json.class)
    public Result getKMostFrequent(Http.Request request) {
        JsonNode json = request.body().asJson();
        int topK = 10;
        List<String> words = StringUtils.topKFrequent(json.get("text").asText(null), topK);
        Map<String, List<String>> response = new HashMap<>();
        response.put("word", words);
        return ok(Json.toJson(response));
    }
}
