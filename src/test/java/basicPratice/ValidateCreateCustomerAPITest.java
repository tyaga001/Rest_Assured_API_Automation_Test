//package basicPratice;
//
//import org.json.JSONObject;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import TestSetup.APISetUp;
//
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//
//import static io.restassured.RestAssured.*;
//
//import java.util.Hashtable;
//
//public class ValidateCreateCustomerAPITest extends APISetUp {
//    @Test(dataProviderClass = Data.class, dataProvider = "data")
//    public void validateCreateCustomerAPIWithValidAuthKey(Hashtable<String, String> data) {
//        testLevelLog.get().assignAuthor("Rahul Jha");
//
//        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
//
//        response.prettyPrint();
//
//
//
//
//        JsonPath responseJson=response.jsonPath();
//        //validating the response status code
//        Assert.assertEquals(response.statusCode(),Integer.parseInt(data.get("expectedStatusCode")));
//        testLevelLog.get().info("response status code is as expected");
//
//        //Validating that the email in the response is same as of the email passed in request
//        Assert.assertEquals(responseJson.get("email"), data.get("email"));
//        testLevelLog.get().info("The email in response is as per the expected value");
//
//        //Validating that the description in the response is same as of the description passed in request
//        Assert.assertEquals(responseJson.get("description"), data.get("description"));
//
//        //Validating that the name in the response is same as of the name passed in request
//        Assert.assertEquals(responseJson.get("name"), data.get("name"));
//
//        if(testUtils.checkJsonHasKey("id", response))
//        {
//            Assert.assertNotNull(responseJson.get("id"));
//        }
//        else
//        {
//            Assert.fail("id field is not available in the response");
//        }
//
//    }
//
//
//
//    @Test(dataProviderClass = Data.class, dataProvider = "data")
//    public void validateCreateCustomerAPIWithInvalidAuthKey(Hashtable<String, String> data) {
//        testLevelLog.get().assignAuthor("Rahul Jha");
//
//        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);
//
//        response.prettyPrint();
//
//
//        JsonPath responseJson=response.jsonPath();
//
//        //Validating response status code is 401
//        Assert.assertEquals(response.statusCode(), Integer.parseInt(data.get("expectedStatusCode")));
//
//        //Validating the response does not have id field
//        Assert.assertFalse(TestUtil.checkJsonHasKey("id", response));
//
//        //Validating response contains error field
//        Assert.assertTrue(TestUtil.checkJsonHasKey("error", response));
//
//
//    }
//}
