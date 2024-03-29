package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import factory.testngBase;
import pageobjects.CarService;
import pageobjects.FreeListing;
import pageobjects.HomePage;

public class FreelistingScenario extends testngBase {
	HomePage H;
	FreeListing F;
	CarService C;

	@Test(priority=1,groups = {"smoke","regression"})
	public void user_visit_on_the_justdial_home_page() {
		
			//C.homepage();
		 H = new HomePage(CarService.getDri());
		 //H.handleADD();
		
	}
	
	@Test(priority=2,groups = {"regression"})
	public void enter_the_near_by_location() {
	    H.setLocation();
	}
	
	@Test(priority=3,groups = {"smoke","regression"})
	public void user_click_on_the_free_listing_button() {
		
		   H.FreeClick();
		 BaseClass.getlogger().info("*******Navigate to the free Listing page*******");
	}
	
	@Test(priority=4,groups = {"smoke"})
	public void validate_the_free_listing_webpage() {
		F = new FreeListing(testngBase.getDri());
	    String actTitle = "Unlock Business Growth | Get Listed for FREE on Justdial";
	    String ExpTitle = F.freeTitle();
	    Assert.assertEquals(actTitle, ExpTitle);
	  BaseClass.getlogger().info("*******Validate the free listing page*******");
	}

	@Test(priority=5,groups = {"regression"})
	public void user_enter_the_wrong_number() {
		
		F = new FreeListing(testngBase.getDri());
		F.enternumberr();
		BaseClass.getlogger().info("*******Enter the wrong number*******");
	   
	}

	@Test(priority=6,groups = {"regression"})
	public void click_on_the_start_now_button() {
		
		F.clickbtn();
	    
	}

	@Test(priority=7,groups = {"regression"})
	public void validating_the_error_message() {
		
		String Expectedmsg = "Please Enter a Valid Mobile Number";
		String ActualMsg = F.getErrorMsg();
		System.out.println(ActualMsg);
		Assert.assertEquals(Expectedmsg, ActualMsg);
		BaseClass.getlogger().info("*******Validating the error message*******");
		
		F.Homepage();
	}	
	
	
	
}

