//package API;
//import java.util.Hashtable;
//
//import TestSetup.APISetUp;
//
//import io.restassured.response.Response;
//
//import static io.restassured.RestAssured.requestSpecification;
//
//public class CustomerAPI extends APISetUp {
//
//    public static Response sendPostRequestToCreateCustomer(Hashtable<String, String> data)
//    {
//        Response response=setFormParams(data.get("arguments"), requestSpecification).post(data.get("endpoint"))
//                .then().extract().response();
//        return response;
//    }
//
//    public static Response sendGetRequestToListAllCustomers(Hashtable<String, String> data)
//    {
//        Response response= requestSpecification.get(data.get("endpoint"))
//                .then().extract().response();
//        return response;
//
//    }
//    public static Response sendDeleteMethodWithValidData(Hashtable<String, String> data)
//    {
//        Response response=requestSpecification.delete(data.get("endpoint"))
//                .then().extract().response();
//        return response;
//    }
//}
