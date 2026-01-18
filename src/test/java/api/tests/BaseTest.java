package api.tests;

import api.utilities.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void setup(){
        RestAssured.baseURI = Routes.BASE_URL;

        RestAssured.requestSpecification = RestAssured
                .given()
                .accept(ContentType.JSON);
    }
}
