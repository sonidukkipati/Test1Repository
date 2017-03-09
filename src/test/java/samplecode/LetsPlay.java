package samplecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import testresources.PageResources;

import java.util.concurrent.TimeUnit;

/**
 * Created by sc on 2/24/2017.
 */
public class LetsPlay {
    @Test
    public void reportsPage() throws InterruptedException {
        WebDriver dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        PageResources page = new PageResources(dr);
        dr.get("http://testwave.qabidder.net");
        Thread.sleep(5000);

        page.getLoginPage().userNameField().sendKeys("sinduchalasani789@gmail.com");
        page.getLoginPage().passWordField().sendKeys("sindu.789");
        Thread.sleep(3000);
        page.getLoginPage().loginButton().click();
        Thread.sleep(5000);

        page.getNavBar().reportsButton().click();
        Thread.sleep(5000);
        page.getReports().paginationNextButtonList().get(page.getReports().paginationNextButtonList().size());
        page.getUsers().nextPageButtonEnabled();

    }
}
