package sda.tests;


import org.testng.annotations.Test;
import sda.pages.XYZBank.BankManager.AddCustomerPage;
import sda.pages.XYZBank.BankManager.ClientOperationsPage;
import sda.pages.XYZBank.BankManager.Customer;
import sda.pages.XYZBank.BankManager.OpenAccountPage;
import sda.pages.XYZBank.HomePage;
import sda.pages.XYZBank.Transactions.Transactions;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;


public class XYZBank {

    //Open 5 new  Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts you created.


    AddCustomerPage addCustomerPage = new AddCustomerPage();
    HomePage homePage = new HomePage();
    ClientOperationsPage clientOperations =new ClientOperationsPage();
   OpenAccountPage openAccountPage = new OpenAccountPage();
    Customer customer = new Customer();
    Transactions transactions =new Transactions();

    @Test
    public void XYZBank() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("xyzBankUrl"));


          homePage.managerButton();

        // Add customers
         clientOperations.addCustomer();
          addCustomerPage.addMoreCustomer(5);
        // Open Account
        clientOperations.openAccount();

       openAccountPage.openMoreAccount(5,6);
        clientOperations.showCustomer();
        customer.numberOfRow();

        // Assert that you created 5 customers
        customer.assertCustomers(10);

        //Click on "Home" button
        homePage.homeButton();
       // Click on "Customer Login" button
        homePage.customerButtonHome();
        //Type 100 into "Amount to be Deposited" input
        transactions.logIn(6);
        transactions.deposit(100);
        transactions.withdrawl(100);
        transactions.logout();
        homePage.homeButton();
        homePage.managerButton();
        clientOperations.showCustomer();
        customer.delete(10);






    }


/*
   /*
Given
    Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
When
    Click on "Bank Manager Login" button
And
    Click on "Add Customer" button
And
    Fill inputs and click on "Add Customer" submit button
And
    Accept alert
And
    Add 4 more customers
And
    Click on "Open Account"  button
And
    Click on "Customer" dropdown
And
    Select customer name
And
    Click on "Currency" dropdown
And
    Select "Dollar"
And
    Click on "Process" button
And
    Accept alert
And
    Open 4 more accounts
And
    Click on "Customers" button
And
    Count table row numbers
Then
    Assert that you created 5 customers
When
    Click on "Home" button
And
    Click on "Customer Login" button
And
    Click on "Your Name" dropdown
And
    Select the any name you created
And
    Click on "Login" button
And
    Click on "Deposit" button
And
    Type 100 into "Amount to be Deposited" input
And
    Click on "Deposit"(Submit) button
Then
    Assert that "Deposit Successful" is displayed
And
    Click on "Withdrawal" button
And
    Type 100 into "Amount to be Withdrawn" input
And
    Click on "Withdraw"(Submit) button
Then
    Assert that "Transaction  Successful" is displayed
When
    Click on "Logout" button
And
    Click on "Home" button
And
    Click on "Bank Manager Login" button
And
    Click on "Customers" button
And
    Click on each "Delete" button
And
    Count table row numbers
Then
    Assert that number of customers is 0

 */
}






