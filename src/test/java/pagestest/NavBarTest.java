package pagestest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.NavBar;

/**
 * Created by sc on 2/13/2017.
 */
public class NavBarTest {

    public static void main(String[] args) {
        WebDriver dr=new ChromeDriver();
        dr.manage().window().maximize();
        NavBar navbarpage = new NavBar(dr);

        for(int i = 0; i<navbarpage.navbarlist().size(); i++) {
            System.out.println(navbarpage.navbarlist().get(i).getText());
            return;

        }

    }
}
