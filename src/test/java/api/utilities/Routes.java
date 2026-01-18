package api.utilities;
/*
 * Swagger URI --> https://petstore.swagger.io/
 *
 * Create pet(Post) : https://petstore.swagger.io/v2/pet
 * Get pet(Get) : https://petstore.swagger.io/v2/pet/{id}
 * Update pet(Put) : https://petstore.swagger.io/v2/pet
 * Delete pet(Delete) : https://petstore.swagger.io/v2/pet/{id}
 * */
public class Routes {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";
    public static final String PET = BASE_URL+"/pet";
    public static final String PET_BY_ID = BASE_URL+"/pet/{id}";
    public static final String PET_BY_STATUS = BASE_URL + "/pet/findByStatus";
    private Routes(){

    }
}