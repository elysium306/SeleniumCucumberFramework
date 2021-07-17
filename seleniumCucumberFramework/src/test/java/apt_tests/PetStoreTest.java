package apt_tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.Authenticator.RequestorType;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import okhttp3.RequestBody;

import static org.hamcrest.Matchers.*;

public class PetStoreTest {
	String url = "https://petstore.swagger.io/v2/pet/findBy";
	Response response;
  @Test
  public void findByStatus() {
	  
	  response = given().queryParam("Status", "available").accept(ContentType.JSON).when().get(url);
	  response.then().assertThat().statusCode(200).and().assertThat().contentType("application/json");
	  
	  response.prettyPrint();
	  
	  assertEquals(response.getStatusCode(), 200);
	  assertEquals(response.getContentType(), "appplication/json");
  }
  @Test
  public void findByWithInvalidUrl() {
	  response = given().queryParam("status", "available").accept(ContentType.JSON).when().get(url);
	  
	  response.prettyPrint();
	  
	  response.then().assertThat().statusCode(404).and().assertThat().contentType("application/json");
	  
	  assertEquals(response.getStatusCode(), 404);
	  assertEquals(response.getContentType(), "application/json");
  }
  
  @Test
  public void findByID() {
	  int id = 227099;
	  url = "https://petstore.swagger.io/v2/pet/";
	  
	  given().accept(ContentType.JSON).when().get(url + id);
	  
	  assertEquals(response.getStatusCode(),  200);
	  assertEquals(response.getContentType(), "application/json");
	  
	  int actualID = response.path("id");
	  System.out.println("actualID is :" + actualID);
	  
	  String actualName = response.path("name");
	  System.out.println("actualName is :" + actualName);
	  
	  String actualStatus = response.path("status");
	  System.out.println("actualStatus is :" + actualStatus);
	  
	  assertEquals(actualID, id);
	  assertEquals(actualName, "booboo");
	  assertEquals(actualStatus, "available");
	  
	  int categoryID = response.path("category.id");
	  String categoryName = response.path("category.name");
	  
	  assertEquals(categoryID, id);
	  assertEquals(categoryName, id);
	  
	  System.out.println(response.path("category").toString());
	  
	  int tagsID = response.path("tags[0].id");
	  System.out.println("tag id is: " + tagsID);
	  
	  String tagsName = response.path("tags[0].name");
	  System.out.println("tags name is:" + tagsName);
	  
	  assertEquals(tagsID, 1234);
	  assertEquals(tagsName, "booboodc");
	  
	  List<String> list = response.jsonPath().getList("tags");
	  for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		String string = (String) iterator.next();
		
	}
	  
  }
  
	  // invalid ID test
	  
	  @Test
	  public void findByInvalidID() {
		  
		  url = "https://petstore.swagger.io/v2/pet";
		  File requestBody = new File("./src/test/resources/JSONFile/putRequest.json");
		  int invalidID = 2792200;
		  
		  response = given().accept(ContentType.JSON).when().get(url + invalidID);  //.accept(ContentType.JSON).when().get(url + invalidID);
		  int tagsID = response.path("tags[0].id");
		  String tagsName = response.path("tags[0].name");
		  
		  given().contentType("application/json").accept(ContentType.JSON)
		  .body(requestBody).when().post(url).thenReturn();
		
	  }
	  
	  // delete pet by id
	  
	  @Test
	  public void deletePet() {
		  url = "https://petstore.swagger.io/v2/pet/";
		  given()
		  .when()
		  .delete(url + "9");
	  }
}