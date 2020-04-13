package com.finra.rest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
@Test
public class DeckGet {
    
	public  String NewDeck() {
		 RestAssured.baseURI = "http://deckofcardsapi.com/api";
		 String response= given().log().all().queryParam("jokers_enabled", true)
		 .when().get("deck/new")
		 .then().log().all().assertThat().statusCode(200).body("remaining", equalTo(54))
		 .extract().response().asString();
		 JsonPath js= new JsonPath(response);
		 String deckId= js.getString("deck_id");
		 System.out.println(deckId);
		 return deckId; //retrieveing deck_id to pass to draw cards aPI
		 
	}

	
	

}
