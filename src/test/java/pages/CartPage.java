package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(xpath = "//span[@class='itemDescription description']/a")
    public WebElement itemTitle;

    @FindBy(xpath = "//button[.='Empty Cart']")
    public WebElement btnEmptyCart;

    @FindBy(xpath = "//footer/button[.='Empty Cart']")
    public WebElement btnConfirmEmptyCart;

    public void emptyCart(){
        btnEmptyCart.click();
        btnConfirmEmptyCart.click();
    }

    @FindBy(xpath = "//p[.='Your cart is empty.']")
    public WebElement msgCartIsEmpty;
}
