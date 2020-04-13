
DeckOfCards API automation An API to simulate a deck of cards

The docs are on http://deckofcardsapi.com

Install
------
This project requires java 1.8.0_151 and the following Java jars installed:

org.testng
io.rest-assured
hamcrest-library
com.googlecode.json-simple

Code
-----

Automation test scenarios for DeckOfCards Rest APIs https://deckofcardsapi.com/api/deck/new/ and https://deckofcardsapi.com/api/deck/<<deck_id>>/draw/?count=2 are written in NewDeck.java and DrawCards.java classes.

Run
----

Go to testng.xml and run as TestNG Test

This will execute the test cases and report will be generated. Open test-output folder and go to index.html Or emailable-report.html to view the results.
