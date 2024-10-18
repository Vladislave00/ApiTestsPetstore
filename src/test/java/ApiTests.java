import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojos.PetInfo;
import pojos.UserCreateResponse;
import pojos.UserInfo;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class ApiTests {

    private static final RequestSpecification REQSP =
            new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2")
                    .setContentType(ContentType.JSON)
                    .build();

    @Test
    public void getTest(){
        List<PetInfo> list = given()
                .when()
                .spec(REQSP)
                .basePath("/pet/findByStatus?status=sold")
                .get()
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().jsonPath().getList(".", PetInfo.class);
        for (PetInfo petInfo : list) {
            Assertions.assertTrue(petInfo.getId() > 0);
        }
    }

    @Test
    public void postTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1234);
        userInfo.setFirstName("Vlad");
        userInfo.setLastName("Afonin");
        userInfo.setEmail("vlad@mail.ru");
        userInfo.setUserStatus(0);
        userInfo.setPhone("89993337711");
        userInfo.setPassword("123");
        userInfo.setUsername("vladik");

        UserCreateResponse response = given()
                .spec(REQSP)
                .basePath("/user")
                .body(userInfo)
                .when()
                .post()
                .then()
                .log().all()
                .extract().as(UserCreateResponse.class);

        assertThat(response).isNotNull();
        Assertions.assertEquals(200, response.getCode());
    }
    @Test
    public void deleteTest(){
        given()
                .spec(REQSP)
                .basePath("/user/string")
                .when()
                .delete()
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void putTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1234);
        userInfo.setFirstName("Vlad");
        userInfo.setLastName("Afonin");
        userInfo.setEmail("vlad@mail.ru");
        userInfo.setUserStatus(0);
        userInfo.setPhone("89993337711");
        userInfo.setPassword("123");

        userInfo.setUsername("vladik");
        given()
                .spec(REQSP)
                .basePath("user/string")
                .body(userInfo)
                .when()
                .put()
                .then()
                .log().all()
                .statusCode(200);

    }
}
