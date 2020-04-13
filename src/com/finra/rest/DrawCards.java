package com.finra.rest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
@Test
public class DrawCards {
  
	public void DrawNCard()
	{
		RestAssured.baseURI = "http://deckofcardsapi.com/api";
		DeckGet dg= new DeckGet();
		String Id= dg.NewDeck();
		given().log().all()
		.when().get("deck/"+Id+"/draw")
		.then().log().all().assertThat().statusCode(200).body("remaining", equalTo(53));
		/// draw more cards
		String response1= given()
		.when().get("deck/"+Id+"/draw/?count=3")
		.then().log().all().assertThat().statusCode(200).body("remaining", equalTo(50)).extract().response().asString();
		JsonPath js1= new JsonPath(response1);
		int count= js1.getInt("cards.size()");
		Assert.assertEquals(count, 3);
	}

}
