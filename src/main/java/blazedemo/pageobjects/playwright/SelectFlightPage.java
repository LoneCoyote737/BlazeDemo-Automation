package blazedemo.pageobjects.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class SelectFlightPage extends BasePage {

    private final Locator flight;

    public SelectFlightPage(Page page) {
        super(page);
        this.flight = page.getByRole(AriaRole.BUTTON);
    }

    public PurchasePage selectFlight(int flight) {
        this.flight.nth(flight+1).click();
        return new PurchasePage(this.page);
    }
}