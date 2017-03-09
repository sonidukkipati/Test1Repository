package samplecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sc on 3/3/2017.
 */
public class LoginTest{
    WebDriver dr;
    LoginPage loginPage;


    @Test
    public void userLoginProcess() throws InterruptedException {

        helper.Xls_Reader xls_reader = new helper.Xls_Reader("C:\\Users\\sc\\Documents\\Userconfig.xlsx") ;
        int rows=xls_reader.getRowCount("Sheet1");
        System.out.println(rows);
        List<String> usertype = new ArrayList();
        for(int i=2;i<=2;i++) {
             String uType = xls_reader.getCellData("Sheet1","User Type",i);
             String uName = xls_reader.getCellData("Sheet1","User Name",i);
             String passWord = xls_reader.getCellData("Sheet1","Password",i);
             System.out.println(uType);
            System.out.println(uName);
            System.out.println(passWord);
            dr.get("http://testwave.qabidder.net/#/page/login");
            Thread.sleep(5000);
//          for SAU
            loginPage.userNameField().sendKeys(uName);
            loginPage.passWordField().sendKeys(passWord);
            Thread.sleep(3000);
            loginPage.loginButton().click();



        }

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
