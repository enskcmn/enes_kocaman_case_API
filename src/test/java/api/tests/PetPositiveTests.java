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
}
