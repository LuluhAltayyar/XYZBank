package sda.pages.XYZBank.BankManager;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sda.utilities.Driver;

public class AddCustomerPage {
    public AddCustomerPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    Faker faker = new Faker();


    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCodeField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addCustomer;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    public WebElement showCustomerButton;


    public void addCustomer() throws InterruptedException {

        firstNameField.sendKeys(faker.name().firstName());
        lastNameField.sendKeys(faker.name().lastName());
        postCodeField.sendKeys(faker.address().zipCode());
        Thread.sleep(500);
        addCustomer.click();
        // Accept the alert
        Thread.sleep(1000);
        Driver.getDriver().switchTo().alert().accept();
    }



    public void addMoreCustomer(int numberOfCust) throws InterruptedException {
        for (int i = 0; i < numberOfCust; i++)
            addCustomer();
    }


}
