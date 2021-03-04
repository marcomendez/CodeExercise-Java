package core;

import io.restassured.response.Response;

public interface IBuilder {

    Response Get(String endPoint);
    Response Post(String endPoint);
    Response Put(String endPoint);
    Response Delete(String endPoint);
}
