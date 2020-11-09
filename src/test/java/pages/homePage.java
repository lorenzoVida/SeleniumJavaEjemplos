package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.cssSelector;

public class homePage extends basePage {

    public homePage(WebDriver driver) {
        super(driver);
    }

    By btnIconUser = By.id("global-user-trigger");
    By frameLogin = By.id("disneyid-iframe");
    By btnKeepIt = By.cssSelector("button[class='btn btn-secondary ng-isolate-scope']");
    By btnConfirmDeleteAccount = By.cssSelector("button[class='btn btn-primary ng-isolate-scope']");
    By btnLogin = By.cssSelector("button[class='btn btn-primary btn-submit ng-isolate-scope']");
    By btnSignUp = By.cssSelector("a[class='btn btn-secondary ng-isolate-scope']");
    By btnSingUpPrimary = By.cssSelector("button[class='btn btn-primary ng-scope ng-isolate-scope']");
    By linkLoginPage = By.cssSelector("a[tref='/members/v3_1/login']");
    By linkLogout = By.cssSelector("a[onclick='javascript:espn.memberservices.logout();return false;']");
    By linkDeleteAccount = By.id("cancel-account");
    By linkProfile = By.cssSelector("a[tref='/members/v3_1/modifyAccount']");
    By txtUsername = By.cssSelector("input[placeholder='Username or Email Address']");
    By txtPassword= By.cssSelector("input[placeholder='Password (case sensitive)']");
    By txtFirstName = By.cssSelector("input[name='firstName']");
    By txtLastName = By.cssSelector("input[name='lastName']");
    By txtEmail = By.cssSelector("input[name='email']");
    By txtNewPassword= By.cssSelector("input[name='newPassword']");

    //Elements Asserts
    By lblWelcomeMessage = By.cssSelector("li[class='display-user']");

    public void clickBtnKeepIt(){
        click(btnKeepIt);
    }

    public String getLblWelcomeMessage(){
        return getText(lblWelcomeMessage);
    }

    public void clickLinkCancelAccount(){
        click(linkDeleteAccount);
    }

    public void clickBtnLogin(){
        click(btnLogin);
    }

    public void login(){
        type("moreagiletesting@gmail.com",txtUsername);
        type("KayaNow86",txtPassword);
    }

    public void registerUser(String name, String lastname, String email, String password){
        type(name,txtFirstName);
        type(lastname,txtLastName);
        type(email,txtEmail);
        type(password,txtNewPassword);
    }

    public void clickBtnCreateUser(){
        click(btnSingUpPrimary);
    }

    public void clickLinkLoginPage(){
        click(linkLoginPage);
    }

    public void clickLinkProfile(){
        click(linkProfile);
    }

    public void clickLinkLogoutPage(){
        click(linkLogout);
    }

    public void enterSignUp(){
        click(btnSignUp);
    }

    public void enterWelcomeUser(){
        click(btnIconUser);
    }


}
