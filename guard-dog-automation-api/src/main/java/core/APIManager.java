package core;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import helpers.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.Type;
import java.util.Map;

public class APIManager {

    static String server = EndPoints.getUrl("Server");
    private static APIManager instance = null;
    private RestAssured restAssured;
    private Response response;
    private RequestSpecification request;
    private String method;
    private String endpoint;

    protected APIManager() {
        initialize();
    }

    public static APIManager getInstance() {
        if (instance == null) {
            instance = new APIManager();
        }
        return instance;
    }

    private void initialize() {
        restAssured = new RestAssured();
        request = restAssured.given();
        request.header("Content-Type", "application/json");
    }

    public RestAssured getRestAssured() {
        return restAssured;
    }

    public void setBaseUri() {
        request = restAssured.given().baseUri(server);
    }

    public void createRequest(String method, String endpoint) {
        if (endpoint.equalsIgnoreCase("Login") && method.equalsIgnoreCase("Post")) {
            request = restAssured.given().baseUri("https://www.googleapis.com/identitytoolkit/v3/");
            this.endpoint = "relyingparty/verifyPassword?key=AIzaSyBvd_-B5MAAxn5jgjqnKa2IG9_SkUZ6niw";
        } else if (endpoint.equalsIgnoreCase("Update Password") && method.equalsIgnoreCase("Post")) {
            request = restAssured.given().baseUri("https://www.googleapis.com/identitytoolkit/");
            this.endpoint = "v3/relyingparty/setAccountInfo?key=AIzaSyBvd_-B5MAAxn5jgjqnKa2IG9_SkUZ6niw";
        } else {
            APIManager.getInstance().setBaseUri();
            this.endpoint = endpoint;
        }
        this.method = method;
    }

    public void setBody(JsonObject bodyJson) {
        request.body(bodyJson.toString());
    }

    public void setHeaders(String headerJson) {
        Type mapType = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> son = new Gson().fromJson(headerJson, mapType);
        request.headers(son);
    }

    public Response sendRequest() {

        switch (method) {
            case "Get":
                response = request.when().get(endpoint);
                break;
            case "Post":
                response = request.when().post(endpoint);
                break;
            case "Put":
                response = request.when().put(endpoint);
                break;
            case "Delete":
                response = request.when().delete(endpoint);
                break;
        }
        return response;
    }


    public Object getValue(String field) {
        return response.path(field);
    }

    public Response getResponse() {
        return response;
    }
}
