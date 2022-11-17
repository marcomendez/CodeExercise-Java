package steps;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import core.APIManager;
import helpers.MyString;
import helpers.ScenarioContent;
import helpers.StringUtils;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
public class GenericSteps extends BaseStep {

    @ParameterType(".*")
    public MyString buildString(String bookName) {
        return new MyString(bookName);
    }

    @And("^I create a (Get|Post|Put|Delete|) request for '([^']+?)' endpoint")
    public void CreateARequest(final String method, final String endPoint) {
        APIManager.getInstance().createRequest(method, endPoint);
    }

    @And("^I set the following body")
    public void SetBody(String body) {
        body = new MyString(body).toString();
        JsonObject bodyJson = new JsonParser().parse(body).getAsJsonObject();
        APIManager.getInstance().setBody(bodyJson);
    }

    @And("^I set the following headers")
    public void SetHeaders(final String headers) {
        APIManager.getInstance().setHeaders(new MyString(headers).toString());
    }

    @And("^I save '([^']+?)' as \"([^']+?)\"")
    public void SaveField(String field, String key) {
        String fieldValue = (String) APIManager.getInstance().getValue(field);
        ScenarioContent.add(key, fieldValue);
    }

    @And("^I send request")
    public void SendRequest() {
        APIManager.getInstance().sendRequest();
    }
}

