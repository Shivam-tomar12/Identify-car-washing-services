package TestNg;


import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import factory.testngBase;
import pageobjects.CarService;
import pageobjects.HomePage;


public class CarwashingServices extends testngBase {

	HomePage H;
	Properties p;
	CarService c;
	
	@Test(priority = 1, groups = {"smoke","regression"})
	public void visit_on_the_justdial_page() {
		BaseClass.getlogger().info("*******Navigate to the Justdial homePage*******");
	    H = new HomePage(testngBase.getDri());
	    H.handleADD();
		
	}
	
	@Test(priority=2,groups = {"smoke"})
	public void validate_the_title_of_the_webpage() {
	    String expTitle = "Find Businesses Near You on Local Search Engine - Justdial";
	    String actTitle = H.Title();
	    Assert.assertEquals(expTitle, actTitle);
	    BaseClass.getlogger().info("*******Validate the title*******");
	}
	
	@Test(priority=3,groups = {"regression"})
	public void enter_the_nearest_location() {
	    H.setLocation();
	    BaseClass.getlogger().info("*******Set the location*******");
	}
	
	@Test(priority=4, groups = {"smoke","regression"})
	public void give_the_proper_data_and_search() {
		
		H.Search();
		BaseClass.getlogger().info("******Enter the Car washing services and search********");
	    
	}
	
	@Test(priority=5, groups = {"smoke","regression"})
	public void click_on_the_apply_filter_button() {
		c = new CarService(testngBase.getDri());
		c.click();
		BaseClass.getlogger().info("******Click apply********");

	}
	
	@Test(priority=6,groups = {"smoke","regression"})
	public void applying_the_filter_as_per_description() {
		
		c.applyFilter();
		BaseClass.getlogger().info("*******Applying the filter*******");
		    
	}

	@Test(priority=7,groups = {"regression"})
	public void getting_the_all_car_washing_service_provider_details() throws InterruptedException, IOException {
		
	    c.getDetails();
	    c.homepage();
	  BaseClass.getlogger().info("*******Getting the details of services*******");
		
	}




	
	
}

