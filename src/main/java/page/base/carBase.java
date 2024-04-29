package page.base;

import static page.base.BasePage.getText;

public class carBase {
    //Title is common in all car pages
    //Absrtaract component - the functionalities which are common to all pages contain them in the car base class

    public String getCarTitle(){
        return BasePage.getText("carTitle_XPATH");
    }
}
