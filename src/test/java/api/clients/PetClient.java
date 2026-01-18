package api.clients;

import api.payload.Pet;
import api.payload.Status;
import api.utilities.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetClient {
    public static Response createPet(Pet newPet){
        return given()
                .contentType(ContentType.JSON)
                .body(newPet)
                .when()
                .post(Routes.PET);
    }
    public static Response getPet(int id){
        return given()
                .contentType(ContentType.JSON)
                .pathParam("id",id)
                .when()
                .get(Routes.PET_BY_ID);
    }
    public static Response updatePet(Pet updatePet){
        return given()
                .contentType(ContentType.JSON)
                .body(updatePet)
                .when()
                .put(Routes.PET);
    }
    public static Response deletePet(int id){
        return given()
                .contentType(ContentType.JSON)
                .pathParam("id",id)
                .when()
                .delete(Routes.PET_BY_ID);
    }
    public static Response findPetByStatus(Status status){
        return given()
                .contentType(ContentType.JSON)
                .queryParam("status",status.toString())
                .when()
                .get(Routes.PET_BY_STATUS);
    }
    public static Response updatePetById(int id, String name, String status){
        return given()
                .log().uri()
                .contentType(ContentType.URLENC)
                .pathParam("id",id)
                .formParam("name",name)
                .formParam("status",status)
                .when()
                .post(Routes.PET_BY_ID);
    }
}
