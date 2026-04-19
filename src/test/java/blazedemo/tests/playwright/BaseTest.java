package blazedemo.tests.playwright;

import com.microsoft.playwright.*;
import org.testng.annotations.*;
import java.util.List;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * To be inherited by all PlayWright Test script classes.<br/>
 * Contains the setups that happen before and after a test runs.
 */
public class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;
    protected Page page;
    protected BrowserContext browserContext;
    protected Browser.NewContextOptions newContextOptions;
    protected String baseUrl = "https://blazedemo.com/";

    public BaseTest () {}

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(List.of("--start-maximized"))
        );
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        newContextOptions = new Browser.NewContextOptions().setViewportSize(null);
        browserContext = browser.newContext(newContextOptions);
        page = browserContext.newPage();
        page.navigate(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        browserContext.close();
    }
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        browser.close();
        playwright.close();
    }

    protected void assertLocator(Locator locator) {
        assertThat(locator).isVisible();
        System.out.println("locator: " + locator + " is visible");
    }
}