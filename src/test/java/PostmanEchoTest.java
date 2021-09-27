import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class PostmanEchoTest {
    @Test
    void shouldShowDataPost() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Проверочные данные")
                // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("headers.content-length", equalTo("35"))
                .body("data", equalTo("Проверочные данныч"))

        ;
    }
}