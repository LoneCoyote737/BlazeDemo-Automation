package blazedemo.pageobjects.playwright;

import com.microsoft.playwright.*;

public class MainPage extends BasePage {

    private final Locator fromPort;
    private final Locator toPort;
    private final Locator findFlightBtn;

    public MainPage(Page page) {
        super(page);

        this.fromPort = locate("select[name=\"fromPort\"]");
        this.toPort = locate("select[name=\"toPort\"]");
        this.findFlightBtn = locateButton("Find Flights");
    }
    public void selectFromPort (String fromPort) {
        this.fromPort.selectOption(fromPort);
    }
    public void selectToPort (String toPort) {
        this.toPort.selectOption(toPort);
    }
    public SelectFlightPage clickFindFlightBtn() {
        this.findFlightBtn.click();
        return new SelectFlightPage(this.page);
    }
}