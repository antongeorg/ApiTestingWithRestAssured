package Api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserApi {

    private static final String BASE_URL = "https://reqres.in/";

    public Response getUser(int userId) {

        return
                given()
                        .baseUri(BASE_URL)
                        .header("x-api-key", "reqres-free-v1")
                        .when()
                        .get("/api/users/" + userId);
    }

    public Response createUser(String name, String job) {

        String payload = String.format("{\"name\":\"%s\", \"job\":\"%s\"}", name, job);

        return
                given()
                        .baseUri(BASE_URL)
                        .header("x-api-key", "reqres-free-v1")
                        .contentType(ContentType.JSON)
                        .body(payload)
                        .when()
                        .post("/users");
    }
}

