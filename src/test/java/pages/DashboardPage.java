package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

public class DashboardPage extends BasePage{
    Actions actions = new Actions(Driver.getDriver());

    @FindBy(linkText = "View Cart")
    public WebElement btnViewCart;

    public void addItemToCart(int itemIndex){
        WebElement btnAddCart = Driver.getDriver().findElement(By.xpath("(//input[@data-testid ='itemAddCart'])[" + itemIndex + "]"));
        actions.moveToElement(btnAddCart).click().build().perform();
    }
}
