package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='hidden flex-1 lt:flex']//input[@data-testid='searchval']")
    public WebElement searchInput;

    public void searchFor(String searchRequest){
        searchInput.sendKeys(searchRequest + Keys.ENTER);
    }
}
