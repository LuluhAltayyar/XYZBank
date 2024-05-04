package sda.pages.XYZBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath= "//button[@ng-click='manager()']")
    public WebElement managerButton;

    @FindBy(xpath= "//button[@ng-click='customer()']")
    public WebElement customerButton;

    @FindBy(xpath= "//button[@ng-click='home()']")
    public WebElement homeButton;

    public void managerButton(){
        managerButton.click();
    }
    public void customerButtonHome(){
        customerButton.click();
    }
    public void homeButton(){
        homeButton.click();
    }
}