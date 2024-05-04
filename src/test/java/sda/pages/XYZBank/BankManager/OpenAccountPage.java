package sda.pages.XYZBank.BankManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sda.utilities.Driver;


public class OpenAccountPage {
    public OpenAccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id="userSelect")
    public WebElement customerSelect;

    @FindBy(id="currency")
    public WebElement currencySelect;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement ProcessButton;

    public void customerSelect(int value ){
        Select selectCust = new Select(customerSelect);
        selectCust.selectByIndex(value);
    }

    public void currencySelect(String value ){
        Select selectCurr = new Select(currencySelect);
        selectCurr.selectByValue(value);
    }

    public void openAccount(int idCustomer,String currency){
        customerSelect(idCustomer);
        currencySelect(currency);
    }

    public void openMoreAccount(int numberOfAccount , int startIdCustomer) throws InterruptedException {

        for (int i = 0; i < numberOfAccount; i++) {
            openAccount(startIdCustomer+i,"Dollar");
            ProcessButton.click();
            Thread.sleep(1000);
            Driver.getDriver().switchTo().alert().accept();

        }

    }


}
