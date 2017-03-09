package pagestest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by sc on 2/10/2017.
 */

public class LoginTest {
    LoginPage loginPage;
    WebDriver dr;

    @Test
    public void LoginTestScript() throws InterruptedException {
        //WebDriver dr=new ChromeDriver();
       // dr.manage().window().maximize();
        //LoginPage loginPage = new LoginPage(dr);

        dr.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);

        loginPage.userNameField().sendKeys("sinduchalasani789@gmail.com");
        loginPage.passWordField().sendKeys("sindu.789");
        Thread.sleep(3000);
        loginPage.loginButton().click();
    }
    @BeforeClass
    public void setup(){
        dr=new ChromeDriver();
        dr.manage().window().maximize();
        loginPage = new LoginPage(dr);

    }
    @AfterClass
    public void breakDown(){
        dr.close();
        dr.quit();

    }
}
