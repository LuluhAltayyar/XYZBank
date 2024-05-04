package sda.pages.XYZBank.BankManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sda.utilities.Driver;

import java.util.List;

public class Customer {

    public Customer() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(tagName="tr")
    public List<WebElement> customerRows;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    public List<WebElement>  deleteCustomerButton;

    //Count table row numbers
    public int numberOfRow()
    {
// Get the number of rows
        return  customerRows.size()-1;
    }

    // Assert that you created 5 customers
    public void assertCustomers(int expected){
        Assert.assertEquals(numberOfRow(),expected );
    }

    public void delete(int idDeleteCustomers){
        for (int i = idDeleteCustomers-1; i >=0; i--) {
            deleteCustomerButton.get(i).click();
        }
        Assert.assertEquals(numberOfRow(),0);
    }

}
