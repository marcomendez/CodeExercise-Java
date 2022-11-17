package core;

public final class RequestBuilder  {

    private static APIManager apiManager;

    public  static void createRequest(final String method, final String endpoint) {
        apiManager.getInstance().setBaseUri();
        apiManager.getInstance().createRequest( method, endpoint);

    }

    public static void verifyStatus(int statusCode)
    {
        apiManager.getInstance().getResponse().then().statusCode(statusCode);
    }
}
