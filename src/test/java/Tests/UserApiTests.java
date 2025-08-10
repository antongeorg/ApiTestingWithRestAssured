package Tests;

import Api.UserApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserApiTests {

    private UserApi userApi;

    @BeforeClass
    public void setup() {
        userApi = new UserApi();
    }

    @Test
    public void testGetUserSuccess() {
        Response response = userApi.getUser(2);

        assertThat(response.statusCode(), is(200));
        assertThat(response.jsonPath().getInt("data.id"), is(2));
        assertThat(response.jsonPath().getString("data.email"), equalTo("janet.weaver@reqres.in"));
    }

    @Test
    public void testCreateUserSuccess() {
        Response response = userApi.createUser("morpheus", "leader");

        assertThat(response.statusCode(), is(201));
        assertThat(response.jsonPath().getString("name"), equalTo("morpheus"));
        assertThat(response.jsonPath().getString("job"), equalTo("leader"));
        assertThat(response.jsonPath().getString("id"), notNullValue());
    }
}
