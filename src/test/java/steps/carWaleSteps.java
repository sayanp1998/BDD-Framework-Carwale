package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.base.BasePage;
import page.objects.NewCarPage;
import page.objects.ToyotaCarPage;
import page.objects.homePage;
import utils.SeleniumDriver;

public class carWaleSteps {

    homePage hp = new homePage();
    NewCarPage newCarPage = new NewCarPage();
    ToyotaCarPage toyotapage = new ToyotaCarPage();

    @Given("user navigates to carwale website")
    public void user_navigates_to_carwale_website() {
        SeleniumDriver.openPage(SeleniumDriver.config.getProperty("url"));
    }

    @When("user mouseover to newcars")
    public void user_mouseover_to_newcars() {
        hp.mouseOverNewCars();
    }

    @Then("user clicks on Findnewcars")
    public void user_clicks_on_findnewcars() {
        hp.clickFindnewCars();
    }

    @And("user clicks on {string} car")
    public void userClicksOnCar(String carBrand) {
        if(carBrand.equals("Toyota")){
            newCarPage.gotoToyota();
        } else if (carBrand.equals("Kia")) {
            newCarPage.gotoKia();
        } else if (carBrand.equals("Honda")) {
            newCarPage.gotoHonda();
        } else if (carBrand.equals("BMW")) {
            newCarPage.gotoBMW();
        }

    }

    @And("user Validates car title as {string}")
    public void userValidatesCarTitleAs(String carTitle    ) {
        System.out.println(BasePage.carbase.getCarTitle());
        Assert.assertTrue(BasePage.carbase.getCarTitle().equals(carTitle));
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
