package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static List<String> listOfWebElementsToString(String locator){
        List<WebElement> listOfWebEl = Driver.getDriver().findElements(By.xpath(locator));
        List<String> listOfStrings = new ArrayList<>();
        for(WebElement el : listOfWebEl){
            listOfStrings.add(el.getText());
        }
        return listOfStrings;
    }

}