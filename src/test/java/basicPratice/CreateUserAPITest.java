package basicPratice;
import java.util.HashMap;
import java.util.Hashtable;
import static io.restassured.RestAssured.*;

import TestUtils.DataProviderClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import TestSetup.APISetUp;

public class CreateUserAPITest extends APISetUp {

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "dp")
    public void validateCreateUserAPIWithValidData(Hashtable<String, String> data) {
        //User user = new User(data.get("name"), data.get("job"));
        HashMap<String, String> map= new HashMap<String, String>();
        map.put("name",data.get("name"));
        map.put("job", data.get("job"));

        Response response = given().contentType(ContentType.JSON).body(map).post("https://reqres.in/api/users");
        response.prettyPrint();

    }
}
