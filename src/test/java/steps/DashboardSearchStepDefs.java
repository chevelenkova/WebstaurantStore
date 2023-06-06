package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.DashboardPage;
import utilities.BrowserUtils;
import java.util.List;

public class DashboardSearchStepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    CartPage cartPage = new CartPage();
    int indexOfLastFoundItem;
    String expectedItemTitle;

    @When("user search for {string}")
    public void user_search_for(String searchRequest) {
        dashboardPage.searchFor(searchRequest);
    }

    @Then("verify every product in the search result has the word {string} in its title")
    public void verify_every_product_in_the_search_result_has_the_word_in_its_title(String expectedKeyWord) {
        List<String> searchResultTitles = BrowserUtils.listOfWebElementsToString("//span[@data-testid ='itemDescription']");
        indexOfLastFoundItem = searchResultTitles.size();
        expectedItemTitle = searchResultTitles.get(indexOfLastFoundItem - 1);
        boolean isAllTitlesContainKeyWord = searchResultTitles.stream().allMatch(el -> el.contains(expectedKeyWord));
        Assert.assertTrue("Search result item title doesn't contain expected key word", isAllTitlesContainKeyWord);

    }

    @Then("verify user is able to add the last of found items to Cart")
    public void verify_user_is_able_to_add_the_last_of_found_items_to_cart() {
        dashboardPage.addItemToCart(indexOfLastFoundItem);
        dashboardPage.btnViewCart.click();
        String actualItemTitle = cartPage.itemTitle.getText();
        Assert.assertEquals("User is unable to add item to the cart", expectedItemTitle, actualItemTitle);
    }

    @Then("verify user is able to empty the cart")
    public void verify_user_is_able_to_empty_the_cart() {
        cartPage.emptyCart();
        Assert.assertTrue("User is unable to empty cart", cartPage.msgCartIsEmpty.isDisplayed());

    }


}
