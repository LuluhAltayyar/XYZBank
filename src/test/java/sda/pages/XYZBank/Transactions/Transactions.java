package sda.pages.XYZBank.Transactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sda.utilities.Driver;

public class Transactions {
    public Transactions() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "userSelect")
    public WebElement nameCustomerSelect;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath= "//button[@ng-click='transactions()']")
    public WebElement transactionsButton;

    @FindBy(xpath= "//button[@ng-click='deposit()']")
    public WebElement depositButton;

    @FindBy(xpath= "//button[@ng-click='withdrawl()']")
    public WebElement withdrawlButton;

    @FindBy(xpath= "//input[@placeholder='amount']")
    public WebElement amount;

    @FindBy(xpath= "//span[@ng-show='message']")
    public WebElement message;

    @FindBy(xpath= "//button[@ng-click='byebye()']")
    public WebElement logout;


    public void logIn(int idcust) {
        Select selectNmae = new Select(nameCustomerSelect);
        selectNmae.selectByIndex(idcust);
        submitButton.click();
    }

    public void withdrawl(int amountN ) throws InterruptedException {
        withdrawlButton.click();
        Thread.sleep(500);
        amount.sendKeys(Integer.toString(amountN));
        submitButton.click();
        Assert.assertEquals("Transaction successful",message.getText());
    }

    public void deposit(int amountN ) throws InterruptedException {
        depositButton.click();
        Thread.sleep(500);
        amount.sendKeys(Integer.toString(amountN));
        submitButton.click();
        Assert.assertEquals("Deposit Successful",message.getText());
    }

    public void logout(){
        logout.click();
    }
}
