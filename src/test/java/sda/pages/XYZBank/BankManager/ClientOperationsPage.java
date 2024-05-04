package sda.pages.XYZBank.BankManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

public class ClientOperationsPage {


    public ClientOperationsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//button[@ng-click='addCust()']")
    public WebElement addCustomerButton;

    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    public WebElement openAccountButton;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    public WebElement showCustomerButton;


    public void addCustomer(){
        addCustomerButton.click();
    }

    public void openAccount(){
        openAccountButton.click();
    }

    public void showCustomer(){
        showCustomerButton.click();
    }

}
