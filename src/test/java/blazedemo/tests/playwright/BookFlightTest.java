package blazedemo.tests.playwright;

import blazedemo.pageobjects.playwright.*;
import org.testng.annotations.Test;

/**
 * TestNG class to simulate booking a flight in BlazeDemo using our created {@code PlayWright} page objects.
 */
public class BookFlightTest extends BaseTest {
    String fromPort = "Boston";
    String toPort = "Berlin";

    @Test
    public void bookFlightTest() {
        MainPage mainPg = new MainPage(page);
        assertLocator(mainPg.locateHeading("Welcome to the Simple Travel Agency!"));
        mainPg.selectFromPort(fromPort);
        mainPg.selectToPort(toPort);

        SelectFlightPage selectFlighPg = mainPg.clickFindFlightBtn();
        String txt1 = String.format("Flights from %s to %s", fromPort, toPort);
        assertLocator(selectFlighPg.locateHeading(txt1));

        PurchasePage purchasePg = selectFlighPg.selectFlight(2);
        assertLocator(purchasePg.locateHeading("Your flight from TLV to SFO has been reserved."));
        purchasePg.fillName("Drajuan");
        purchasePg.fillAddress("No 7, &th Street");
        purchasePg.fillCity("City of Sevens");
        purchasePg.fillState("State 7");
        purchasePg.fillZipCode("77777");
        purchasePg.selectCardType("visa");
        purchasePg.fillCreditCardNumber("7777777777777777");
        purchasePg.fillMonth("07");
        purchasePg.fillYear("2021");
        purchasePg.fillNameOnCard("Drajuan");
        purchasePg.clickRememberMeChkBox();

        ConfimationPage confimationPg = purchasePg.clickPurchaseFlightBtn();
        assertLocator(confimationPg.locateHeading("Thank you for your purchase today!"));
    }
}