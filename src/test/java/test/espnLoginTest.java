package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.homePage;

public class espnLoginTest {

    private WebDriver driver;
    homePage home;


    int randomWithRange(int min, int max){
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    String correo = "AguaCalidenjute" + randomWithRange(100,999) +"@gmail.com";

    @DataProvider (name = "users")
    public Object[][] Users(){
        return new Object[][]{
                {"Lorenzoz", "Vidaurre", correo, "1wertysd"}
        };
    }

    @BeforeSuite()
    public void crearCuenta(){
        System.out.println("BeforeSuiteCreateAccount");
    }

    @Parameters({"browser","url"})
    @BeforeTest
    public void setUp(String browser,String app) throws Exception{
        if(browser.equalsIgnoreCase("chrome")){
            home = new homePage(driver);
            driver = home.chromeDriverConnection();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            home = new homePage(driver);
            driver = home.firefoxDriverConnection();
        }
        home.visit(app);
    }

    @Test(dataProvider="users")
    public void logOutTest(String name, String lastName, String email, String password) throws InterruptedException {
        String WELCOME_MESSAGE= null;
        registerUserMethod();
        home.registerUser(name, lastName, email, password);
        WebDriverWait waitespn=new WebDriverWait(driver,11);
        Thread.sleep(2000);
        home.clickBtnCreateUser();
        Thread.sleep(9000);
        home.enterWelcomeUser();
        Thread.sleep(5000);
        home.clickLinkLogoutPage();
        Thread.sleep(4000);
        home.enterWelcomeUser();
        WELCOME_MESSAGE = home.getLblWelcomeMessage();
        Assert.assertEquals("Welcome!",WELCOME_MESSAGE);
    }

    @Test(dependsOnMethods = "logOutTest")
    public void loginTest() throws InterruptedException {
        String WELCOME_MESSAGE= null;
        Thread.sleep(15000);
        home.enterWelcomeUser();
        WELCOME_MESSAGE = home.getLblWelcomeMessage();
        Assert.assertEquals("Welcome!",WELCOME_MESSAGE);
        Thread.sleep(4000);
        home.clickLinkLoginPage();
        home.frameSwitch();
        home.login();
        home.clickBtnLogin();
        //finish login - star logout - post condition
        Thread.sleep(15000);
        home.enterWelcomeUser();
        Thread.sleep(4000);
        home.clickLinkLogoutPage();
        Thread.sleep(15000);
    }

    @Test(dependsOnMethods = "loginTest")
    public void cancelAccount() throws InterruptedException {
        String WELCOME_MESSAGE_LOGIN_USER = null;
        loginMethod();
        Thread.sleep(9000);
        home.enterWelcomeUser();
        WELCOME_MESSAGE_LOGIN_USER = home.getLblWelcomeMessage();
        Assert.assertEquals("Welcomelorenzo!",WELCOME_MESSAGE_LOGIN_USER);
        Thread.sleep(4000);
        home.clickLinkProfile();
        home.frameSwitch();
        Thread.sleep(9000);
        home.clickLinkCancelAccount();
        home.clickBtnKeepIt();
    }

    public void loginMethod() throws InterruptedException {
        Thread.sleep(9000);
        home.enterWelcomeUser();
        Thread.sleep(4000);
        home.clickLinkLoginPage();
        Thread.sleep(5000);
        home.frameSwitch();
        home.login();
        home.clickBtnLogin();
    }

    public void registerUserMethod() throws InterruptedException {
        Thread.sleep(9000);
        home.enterWelcomeUser();
        Thread.sleep(4000);
        home.clickLinkLoginPage();
        Thread.sleep(5000);
        home.frameSwitch();
        home.enterSignUp();
        Thread.sleep(2000);
    }


//    @Test(dependsOnMethods = { "enterLoginPage" },dataProvider="users")
    public void enterUserOrEmail(String name, String lastName,String email, String password) throws InterruptedException {
        Thread.sleep(2000);
        home.registerUser(name, lastName, email, password);
        Thread.sleep(5000);
    }

    @AfterMethod
    public void ScreenShot() {
        System.out.println("AfterMethod: capturar pantalla");
    }

}

