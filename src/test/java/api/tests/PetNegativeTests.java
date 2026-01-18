package api.tests;

import api.clients.PetClient;
import api.payload.Pet;
import api.payload.Status;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetNegativeTests extends BaseTest{
    Pet pet;
    @Test
    public void testGetPetWithInvalidId(){
        Response response = PetClient.getPet(444444);
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),404);
    }
    @Test
    public void testDeleteNonExistingPet(){
        Response response = PetClient.deletePet(55555555);
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),404);
    }
    //pet-store-findPetsByStatus endpoint returns 200, even if status is not valid
    @Test
    public void testGetNonExistingStatus(){
        Response response = PetClient.findPetByStatus(Status.invalid);
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getList("$").size(), 0);
    }
    @Test
    public void testCreatePetWithoutBody(){
        pet = new Pet();
        pet.setName("name");
        Response response = PetClient.createPet(pet);

        Assert.assertTrue(response.statusCode() == 200 || response.statusCode() == 400);
    }

    @Test
    public void testWrongContentType(){
        Response response = PetClient.updatePetWithWrongContentType(11,"ek",Status.pending.toString());

        Assert.assertEquals(response.statusCode(),415);
    }
}
