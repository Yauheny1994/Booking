package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class BookingSteps {

    private String city;

    @Given("User is looking for hotel in {string} city")
    public void userIsLookingForHotelInLondonCity(String city) {
        this.city = city;
    }

    @When("User does search")
    public void userDoesSearch() {
        open("https://www.booking.com/");
        $(By.xpath("//input[@type='search']")).sendKeys(city);
        $(By.xpath("//button[@data-sb-id='main']")).click();
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelNobuHotelLondonPortmanSquareShouldBeOnTheFirstPage(String hotel) {
        ArrayList<String> hotelNames = new ArrayList<>();
        for (SelenideElement element : $$(By.xpath("//div[@data-testid='title']"))) {
            hotelNames.add(element.getText());
        }
        Assert.assertTrue(hotelNames.contains(hotel));
    }
}
