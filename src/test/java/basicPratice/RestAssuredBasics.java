package basicPratice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class RestAssuredBasics {

    @Test
    public void checkStatusCodeRequestTest() {
        given().
                when().
                get("http://zippopotam.us/us/90210").then().assertThat().statusCode(200);
    }

    @Test
    public void checkContentTypeRequestTest() {
        given().
                when().get("http://zippopotam.us/us/90210").then().assertThat().contentType(ContentType.JSON);

        given().
                when().get("http://zippopotam.us/us/90210").then().assertThat().contentType("application/json");
    }

    @Test
    public void checkApiLogRequestAndResponseDetails() {
        given().
                log().all().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                log().body();
    }

    @Test
    public void checkPlaceNameInJSONResponseBody_expectBeverlyHills() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void checkStateNameInJSONResponseBody_expectCalifornia() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places[0].state", equalTo("California"));
    }

    @Test
    public void checkListOfPlaceNamesInJSONResponseBody_containsBeverlyHills() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasItem("Beverly Hills"));
    }

    @Test
    public void checkNumberOfPlaceNamesInJSONResponseBody_expectOne() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasSize(1));
    }

}
