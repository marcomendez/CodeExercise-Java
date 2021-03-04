package steps;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import core.APIManager;
import helpers.MyString;
import io.cucumber.java.en.And;
import models.ListDevices;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class GenericValidation extends BaseStep {

    @And("^I should get status (\\d+)$")
    public void VerifyStatus(final int expectResult) {
        Assert.assertEquals(expectResult, APIManager.getInstance().getResponse().getStatusCode(), APIManager.getInstance().getResponse().asString());
    }

    @And("^I should get the following response body$")
    public void VerifyBody(String responseBody) {

        responseBody = new MyString(responseBody).toString();
        String actualResponse = APIManager.getInstance().getResponse().asString();

        JsonObject actualResult = new JsonParser().parse(actualResponse).getAsJsonObject();
        JsonObject expectResult = new JsonParser().parse(new MyString(responseBody).toString()).getAsJsonObject();

        Assert.assertEquals(expectResult, actualResult, "Json actual: " + expectResult.toString() + " \n Json expected : " + expectResult.toString());
    }

    @And("^I should get '([^']+?)' in the following field$")
    public void ValidateValueInField(final String expectResult, final String field) {
        String actualResult = (String) APIManager.getInstance().getValue(field);
        Assert.assertEquals(actualResult, expectResult);
    }

    @And("^I should get '([^']+?)' in '([^']+?)' response field$")
    public void GetValueFromField(final String expectResult, final String field) {
        String actualResult = (String) APIManager.getInstance().getValue(field);
        Assert.assertEquals(actualResult, expectResult);

    }

    @And("^I should get Boolean '([^']+?)' in '([^']+?)' response field$")
    public void ValidateBooleanValue(final Boolean expectResult, final String field) {
        Boolean actualResult = (Boolean) APIManager.getInstance().getValue(field);
        Assert.assertEquals(actualResult, expectResult);
    }

    @And("^I should get the following response body from '([^']+?)' field$")
    public void ValidateBooleanValue(final String field, final String body) {
        JsonObject actualResult = new JsonParser().parse(APIManager.getInstance().getValue(field).toString()).getAsJsonObject();
        JsonObject expectResult = new JsonParser().parse(new MyString(body).toString()).getAsJsonObject();

        Assert.assertEquals(expectResult, actualResult, "Json actual: " + expectResult.toString() + " \n Json expected : " + expectResult.toString());

    }




    @And("^I validate json '([^']+?)' schema$")
    public void ValidateSchema(final String pathName) throws IOException, InterruptedException {


        FileWriter myWriter = new FileWriter("C:\\Users\\marco.mendez\\Desktop\\guard-dog-automation\\guard-dog-automation-api\\src\\test\\resources\\schemas\\template.json");
        myWriter.write(APIManager.getInstance().getResponse().getBody().asString());
        myWriter.close();

        JSONObject jsonSchema = new JSONObject(new JSONTokener(ListDevices.class.getResourceAsStream("/schemas/" + pathName + ".json")));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(ListDevices.class.getResourceAsStream("/schemas/template.json")));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
        assertThat(APIManager.getInstance().getResponse().getBody().asString(), matchesJsonSchemaInClasspath("schemas/" + pathName + ".json"));
    }

    @And("^I validate json Devices schema$")
    public void ValidateDevicesSchema() {
        assertThat(APIManager.getInstance().getResponse().getBody().asString(), matchesJsonSchemaInClasspath("schemas/Device.json"));
    }

    @And("^I validate json Pull data schema$")
    public void validatePullDataSchema() {

        JSONObject jsonObject = new JSONObject(APIManager.getInstance().getResponse().getBody().asString().trim());
        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            if (jsonObject.get(key) instanceof JSONObject) {
                // do something with jsonObject here
                JSONObject object = new JSONObject(jsonObject.get(key).toString());
                JSONObject data = new JSONObject(object.get("data").toString());
                String body = data.toString();
                assertThat(body, matchesJsonSchemaInClasspath("schemas/Data.json"));

            }
        }
    }

    @And("^I validate json Pull data Networks schema$")
    public void validatePullDataNetworkSchema() {

        JSONObject jsonObject = new JSONObject(APIManager.getInstance().getResponse().getBody().asString().trim());
        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();
         //   JSONObject threat = new JSONObject(jsonObject.get("threat").toString());
            JSONObject wireless = new JSONObject(jsonObject.get("wireless").toString());
            JSONObject network = new JSONObject(jsonObject.get("network").toString());
            JSONObject error = new JSONObject(jsonObject.get("error").toString());
            JSONObject status = new JSONObject(jsonObject.get("status").toString());
           // JSONObject main_threat = new JSONObject(jsonObject.get("main_threat").toString());
            //JSONObject threats_sorted = new JSONObject(jsonObject.get("threats_sorted").toString());
            JSONObject vulnerability = new JSONObject(jsonObject.get("vulnerability").toString());
            JSONObject threats = new JSONObject(jsonObject.get("threats").toString());

        }
    }
}

