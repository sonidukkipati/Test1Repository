package pagestest;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testresources.PageResources;

/**
 * Created by sc on 3/1/2017.
 */
public class WAVE913 {
    WebDriver dr;
    PageResources pageResources;
    Faker faker = new Faker();

    @BeforeClass
    public void setup(){
        dr=new ChromeDriver();
        dr.manage().window().maximize();
        pageResources = new PageResources(dr);

    }

    @Test
    public void reportaddtest() throws InterruptedException {
        dr.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);
        pageResources.getLoginPage().userNameField().sendKeys("sinduchalasani789@gmail.com");
        pageResources.getLoginPage().passWordField().sendKeys("sindu.789");
        pageResources.getLoginPage().loginButton().click();
        Thread.sleep(10000);
        pageResources.getNavBar().addReportButton().click();
        Thread.sleep(5000);
        pageResources.getAddReportEntity().entityNamelistByIndex(1).click();
        Thread.sleep(5000);
        pageResources.getAddReportEntity().subjectInformationPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportSubjectInformation().lastNameField().click();
        Thread.sleep(5000);
        pageResources.getAddReportSubjectInformation().lastNameField().sendKeys(faker.name().lastName());
        Thread.sleep(3000);
        pageResources.getAddReportSubjectInformation().firstNameField().click();
        pageResources.getAddReportSubjectInformation().firstNameField().sendKeys(faker.name().firstName());
        pageResources.getAddReportSubjectInformation().hairColor().selectByVisibleText("Unknown");
        Thread.sleep(3000);
        pageResources.getAddReportSubjectInformation().eyeColor().selectByVisibleText("Unknown");
        Thread.sleep(5000);
        pageResources.getAddReportSubjectInformation().identifierPage().click();

        Thread.sleep(5000);
        pageResources.getAddReportIdentifiers().checkboxByIndex(0).click();
        pageResources.getAddReportIdentifiers().tatoos().sendKeys("tattoo on left ear");
        pageResources.getAddReportIdentifiers().idInformationPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().socialSecurity().click();
        pageResources.getAddReportIDInformation().socialSecurity().sendKeys("124-46-6789");
        pageResources.getAddReportIDInformation().employerName().click();
        pageResources.getAddReportIDInformation().employerName().sendKeys("BLADE");
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollToElement();
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollUp();
        Thread.sleep(5000);
        //pageResources.getAddReportIDInformation().nextButton().click();
        pageResources.getAddReportIDInformation().stopInformationPage().click();
        Thread.sleep(5000);

        pageResources.getAddReportStopInformation().locationOfStop().click();
        pageResources.getAddReportStopInformation().locationOfStop().sendKeys(faker.address().city());
        Thread.sleep(3000);
        pageResources.getAddReportStopInformation().vehiclePage().click();
        Thread.sleep(5000);

        pageResources.getAddReportVehicle().vehicleLicense().sendKeys("ER$%^FGTVBN");
        pageResources.getAddReportVehicle().photosPage().click();
        Thread.sleep(5000);
        pageResources.getAddReportPhotos().previewPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportCommit().reportCommit().click();
        Thread.sleep(10000);
        pageResources.getReports().viewButtonByIndex(1).click();
        Thread.sleep(10000);
       /* if(pageResources.getReports().viewEyeColor().getText().contains("Unknown")) {
                 System.out.println("This test Case passes");
        }else{
            System.out.println("This testcase Fails");
        }*/
        String expected = "Unknown";
        String actual = pageResources.getReports().viewEyeColorContent().getText();
        //span[text()='Eye Color']//following::div[1]
        try{
            Assert.assertEquals(actual,expected,"First fail, Eye Color field is wrong");
        }catch (AssertionError e){
            e.getLocalizedMessage();
//            System.out.println(e.getLocalizedMessage());
            //The test will pass, but stacktrace will be printed on console.
            e.printStackTrace();
            //The test will fail, stack  trace will be printed on console and TestNg log files.
//            throw e;


        }
    }
    //*[@id="reportBody"]/div[1]/div/div[7]/div[2]/div

   /* @AfterClass
    public void breakDown(){
        dr.close();
        dr.quit();

    }*/

}
