package pagestest;

import helper.ReportHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Reports;
import testresources.PageResources;

/**
 * Created by sc on 2/27/2017.
 */
public class ReportCountTest {

    WebDriver dr;
    PageResources pageResources;
    ReportHelper reportHelper;
    Reports reports;


    @BeforeClass
    public void setup() {
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        pageResources = new PageResources(dr);
        reportHelper = new ReportHelper(dr, pageResources);


    }

    @Test
    public void countReport() throws InterruptedException {


        dr.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);
        pageResources.getLoginPage().userNameField().sendKeys("sinduchalasani789@gmail.com");;
        pageResources.getLoginPage().passWordField().sendKeys("sindu.789");;
        Thread.sleep(5000);
        pageResources.getLoginPage().loginButton().click();
        Thread.sleep(3000);
        //pageResources.getNavBar().reportsButton().click();
        pageResources.getReports().ensurePublishReports(15);


    }

    /*@AfterClass
    public void breakDown(){
        dr.close();
        dr.quit();

    }*/


}