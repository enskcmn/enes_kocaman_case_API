package api.tests;

import api.clients.PetClient;
import api.payload.Pet;
import api.payload.Status;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PetPositiveTests extends BaseTest{
    Pet petClient;
    HashMap<String,String> categoryMapping;
    HashMap<String,String> tagsMapping;
    ArrayList<String> photoUrlArray;

    @BeforeClass
    public void setupData(){
        petClient = new Pet();
        categoryMapping = new HashMap<>();
        tagsMapping = new HashMap<>();
        photoUrlArray = new ArrayList<>();

        categoryMapping.put("id","1");
        categoryMapping.put("name","Dogs");
        photoUrlArray.add("newPhotoURL");
        tagsMapping.put("id", "123");
        tagsMapping.put("name","Pet1");

        petClient.setId(2076);
        petClient.setName("bonnie");
        petClient.setStatus(Status.available);
        petClient.setCategory(categoryMapping);
        petClient.setPhotoUrls(photoUrlArray);
        petClient.setTag(tagsMapping);
        petClient.setStatus(Status.available);
    }
    @Test(priority = 1)
    public void testAddPet(){
        Response response = PetClient.createPet(petClient);
        response.then().log().all();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("name"), petClient.getName());
    }
    @Test(priority = 2)
    public void testGetPet(){
        Response response = PetClient.getPet(petClient.getId());
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
    }
    @Test(priority = 3)
    public void testUpdatePet(){
        petClient.setId(5755);
        petClient.setName("barty");
        petClient.setStatus(Status.sold);
        Response response = PetClient.updatePet(petClient);
        response.then().log().body();

        Assert.assertEquals(response.statusCode(),200);
        //Checking data after update
        Response responseAfterUpdate = PetClient.getPet(this.petClient.getId());
        Assert.assertEquals(responseAfterUpdate.statusCode(),200);
    }
    @Test(priority = 4)
    public void testGetPetByStatus(){
        Response response = PetClient.findPetByStatus(Status.pending);

        Assert.assertTrue(response.jsonPath().getList("$").size() > 0);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void testUpdatePetById(){
        Response response = PetClient.updatePetById(12,"updated","sold");
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("message"),"12");
    }
    @Test(priority = 5)
    public void testDeletePet(){
        Response response = PetClient.deletePet(this.petClient.getId());
        response.then().log().all();

        Assert.assertEquals(response.statusCode(),200);
    }
}
