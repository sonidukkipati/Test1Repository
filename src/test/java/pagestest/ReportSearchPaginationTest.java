package pagestest;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testresources.PageResources;
import helper.ReportHelper;
/**
 * Created by sc on 2/24/2017.
 */
public class ReportSearchPaginationTest {


    WebDriver dr;
    PageResources pageResources;
    ReportHelper reportHelper;

    @BeforeClass
    public void setup(){
            dr=new ChromeDriver();
            dr.manage().window().maximize();
        pageResources = new PageResources(dr);
        reportHelper = new ReportHelper(dr,pageResources);

        }


     @Test(priority=1)
    //Adding multiple reports with helper function in ReportHelper
    public void reportSearchPagination() throws InterruptedException {


            Thread.sleep(5000);
            reportHelper.CreateReports(2,"sinduchalasani789@gmail.com","sindu.789");
          String str1=  pageResources.getReports().tableView(2).getText();
       String date1 =  pageResources.getReports().selectFromDate().getText();

       if (str1.contains(date1)){

           System.out.println("Success--- Showing the reports of the correct Date");
       }else{

           System.out.println("Error in Showing the reports of the correct Date");
       }



    }

    // By clicking Next Button and Previous Button on Pagination, Check if the Reports in Prev Button
    // and Next Button is showing.
     @Test(priority=2)
     public void reportSearchNextPrevPagination() throws InterruptedException {
        Thread.sleep(5000);
       // pageResources.getAddReportIDInformation().scrollDown();
        Thread.sleep(3000);
        String str1=  pageResources.getReports().tableView(3).getText();
        Thread.sleep(3000);
        pageResources.getReports().checkBoxPublishedOn().click();
        Thread.sleep(3000);
        pageResources.getReports().paginationNextButtonByIndex(3).click();
        Thread.sleep(5000);
        pageResources.getReports().paginationPrevButtonByIndex(2).click();
        Thread.sleep(3000);
        String str2 =  pageResources.getReports().tableView(3).getText();
        if (str1.contentEquals(str2)) {

            System.out.println("These two reports can not be equal");

        }else{
            System.out.println("success");
        }
        Thread.sleep(5000);
      //  pageResources.getReports().checkBoxPublishedOn().click();
        String str3=  pageResources.getReports().tableView(4).getText();
        //Verifying the Next Button and Prev button works and the reports shown are different
         // After pressing Prev and Next Button in Reports
        pageResources.getReports().paginationNextButtonByIndex(4).click();
        String str4 =  pageResources.getReports().tableView(3).getText();
        if (str3.contentEquals(str4)) {

            System.out.println("These two reports can not be equal");

        }else{
            System.out.println("success");
        }


    }

     @AfterClass
    public void breakDown(){
        dr.close();
        dr.quit();

    }

}
