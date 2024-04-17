package APIAutomation.Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class SampleTest {
    @Test
    public void testing()
    {
        RestAssured.baseURI = "https://www.kurtosys.com/";
        Response response = given().log().all()
                .when().get("/")
                .then().log().all().assertThat().statusCode(200).assertThat().header("Server", "cloudflare").extract().response();

        long responseTime = response.getTime();
        System.out.println(responseTime);
        Assert.assertTrue(responseTime<2000, "response time is more than 2 seconds");
    }
}
