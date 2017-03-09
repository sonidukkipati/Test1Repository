package samplecode;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by sc on 3/2/2017.
 */
public class registerTest {

    //class in TestNg
    SoftAssert softAssert = new SoftAssert();

    @Test  //this is assert test
    public void register() {

        String expectedtitle = "xxxx";
        String actualtitle = "xxxx1";
        System.out.println("A");
        //Assert.assertEquals(actualtitle, expectedtitle);
        //Directly fail
        //Assert.fail("error encountered");
        softAssert.assertEquals(actualtitle, expectedtitle,"Assert1");
        softAssert.assertEquals("A", "A","Asser2");
        System.out.println("B");

        //Assert.assertTrue(2>11,"error message");
        //Assert.assertTrue(isElementPresent("xx"),"Error Element not Found");
        softAssert.assertAll();


        //critical  -- stop/failure
        //not critical --- soft assertion
    }

	/*private boolean isElementPresent(String string) {
		// TODO Auto-generated method stub
		return false;
	}*/
}




