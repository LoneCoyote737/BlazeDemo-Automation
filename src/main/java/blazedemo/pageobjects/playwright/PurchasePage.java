package blazedemo.pageobjects.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class PurchasePage extends BasePage {

    private final Locator name;
    private final Locator address;
    private final Locator city;
    private final Locator state;
    private final Locator zipCode;

    private final Locator cardType;
    private final Locator creditCardNumber;
    private final Locator month;
    private final Locator year;
    private final Locator nameOnCard;

    private final Locator rememberMeChkBox;
    private final Locator purchaseFlightBtn;


    public PurchasePage(Page page) {
        super(page);

        this.name = locateAriaElementExact("Name", AriaRole.TEXTBOX);
        this.address = locateTextbox("Address");
        this.city = locateTextbox("City");
        this.state = locateTextbox("State");
        this.zipCode = locateTextbox("Zip Code");

        this.cardType = locate("#cardType");
        this.creditCardNumber = locateTextbox("Credit Card Number");
        this.month = locateTextbox("Month");
        this.year = locateTextbox("Year");
        this.nameOnCard = locateTextbox("Name On Card");

        this.rememberMeChkBox = locateAriaElement("Remember me", AriaRole.CHECKBOX);
        this.purchaseFlightBtn = locateButton("Purchase Flight");
    }

    public void fillName (String name) {
        this.name.fill(name);
    }
    public void fillAddress (String address) {
        this.address.fill(address);
    }
    public void fillCity (String city) {
        this.city.fill(city);
    }
    public void fillState (String state) {
        this.state.fill(state);
    }
    public void fillZipCode (String zipCode) {
        this.zipCode.fill(zipCode);
    }

    /** @param cardType options: amex, dinersclub, visa */
    public void selectCardType (String cardType) {
        this.cardType.selectOption(cardType);
    }
    public void fillCreditCardNumber (String creditCardNumber) {
        this.creditCardNumber.fill(creditCardNumber);
    }
    public void fillMonth (String month) {
        this.month.fill(month);
    }
    public void fillYear (String year) {
        this.year.fill(year);
    }
    public void fillNameOnCard (String nameOnCard) {
        this.nameOnCard.fill(nameOnCard);
    }
    public void clickRememberMeChkBox() {
        this.rememberMeChkBox.check();
    }
    public ConfimationPage clickPurchaseFlightBtn() {
        this.purchaseFlightBtn.click();
        return new ConfimationPage(this.page);
    }
}