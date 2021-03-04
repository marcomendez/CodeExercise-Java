package hooks;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import core.APIManager;
import helpers.Constants;
import helpers.ScenarioContent;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @After(order = 9999)
    public void afterScenario() {
        //     WebDriverManager.getInstance().getWebDriver().close();
    }


    @Before(order = 1)
    public void beforeFeature() {
        APIManager.getInstance().createRequest("Post", "Login");
        String body = "{\"email\":\"" + Constants.User_Name + "\",\"password\":\"" + Constants.USER_PASSWORD + "\",\"returnSecureToken\":true}";
        JsonObject bodyJson = new JsonParser().parse(body).getAsJsonObject();
        APIManager.getInstance().setBody(bodyJson);
        APIManager.getInstance().sendRequest();

        String token = (String) APIManager.getInstance().getValue("idToken");
        String refresh_token = (String) APIManager.getInstance().getValue("refreshToken");

        ScenarioContent.add(Constants.USER_TOKEN, token);
        ScenarioContent.add(Constants.REFRESH_TOKEN, refresh_token);
    }
}