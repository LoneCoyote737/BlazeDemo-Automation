package blazedemo.pageobjects.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

/**
 * To be inherited by all PlayWright page object classes.<br/>
 * Contains useful {@code Locator} finding functions.
 */
public class BasePage {

    protected Page page;
    public BasePage(Page page) {
        this.page = page;
    }

    public Locator locate(String selector) {
        return page.locator(selector);
    }
    public Locator locateAriaElement (String elementName, AriaRole role) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(elementName));
    }
    public Locator locateAriaElementExact (String elementName, AriaRole role) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(elementName).setExact(true));
    }
    public Locator locateButton (String buttonName) {
        return locateAriaElement(buttonName, AriaRole.BUTTON);
    }
    public Locator locateTextbox (String textboxName) {
        return locateAriaElement(textboxName, AriaRole.TEXTBOX);
    }
    public Locator locateHeading (String headingName) {
        return locateAriaElement(headingName, AriaRole.HEADING);
    }
    public Locator locateCell (String cellName) {
        return locateAriaElement(cellName, AriaRole.CELL);
    }

    public Locator getByText (String text) {
        return page.getByText(text);
    }
}