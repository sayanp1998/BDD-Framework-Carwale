package page.objects;

import page.base.BasePage;

public class homePage extends BasePage {
    public void mouseOverNewCars(){
        mouserOver("newCarmenu_XPATH");
    }
    public NewCarPage clickFindnewCars(){
        click("findNewCar_XPATH");

        return new NewCarPage();
    }
    public void searchCars(){
        //
    }
}
