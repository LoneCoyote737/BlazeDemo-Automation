package blazedemo.pageobjects.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

/**
 * To be inherited by all playwright page object classes.<br/>
 * Contains useful {@code Locator} finding functions.
 */
public class BasePage {

    protected Page page;
    public BasePage(Page page) {
        this.page = page;
    }

    protected Locator locateAriaElement (String elementName, AriaRole role) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(elementName));
    }
    protected Locator locateButton (String buttonName) {
        return locateAriaElement(buttonName, AriaRole.BUTTON);
    }
    protected Locator locatedTextbox (String textboxName) {
        return locateAriaElement(textboxName, AriaRole.TEXTBOX);
    }

    protected Locator getByText (String text) {
        return page.getByText(text);
    }
}