package page.objects;

import page.base.BasePage;

public class NewCarPage extends BasePage {

    public kiaCarPage gotoKia(){
        //we have to create a action class then initialize the driver and move to the perticular element
        click("kia_LINK");

        return new kiaCarPage();
    }

    public BMWCarPage gotoBMW(){
        click("bmw_LINK");

        return new BMWCarPage();
    }

    public ToyotaCarPage gotoToyota(){
        click("honda_LINK");

        return new ToyotaCarPage();
    }

    public HondaCarPage gotoHonda(){
        click("honda_LINK");

        return new HondaCarPage();
    }

}
