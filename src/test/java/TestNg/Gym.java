package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import factory.testngBase;
import pageobjects.FreeListing;
import pageobjects.GymPage;
import pageobjects.HomePage;

public class Gym extends testngBase{
	
	HomePage H;
	GymPage G;
	FreeListing F;
	
	@Test(priority=1,groups = {"smoke","regression"})
	public void Homepage() {
		
		
		H = new HomePage(FreeListing.getDri());
		//H.handleADD();
		BaseClass.getlogger().info("*******Navigate to the justdial homepage*******");
	}
	
	
	@Test(priority=3,groups = {"regression"})
	public void location() {
		H = new HomePage(testngBase.getDri());
	    H.setLocation();
	  BaseClass.getlogger().info("*******Get the location*******");
	}


	@Test(priority=4,groups = {"smoke","regression"})
	public void scrollto() {
		H = new HomePage(testngBase.getDri());
		
		H.scrolldown();
		BaseClass.getlogger().info("*******Scroll to gym*******");
	}

	@Test(priority=5,groups = {"smoke","regression"})
	public void click_on_the_gym_button() {
		H = new HomePage(testngBase.getDri());
		
	   H.gymClick();
	 BaseClass.getlogger().info("*******click on the gym button*******");
	}

	@Test(priority=6,groups = {"regression"})
	public void store_the_list_of_submenu_and_display() {
		
	   G = new GymPage(testngBase.getDri());
	   G.submenu();
	}

	@Test(priority=7,groups = {"regression"})
	public void display_all_the_submenu_content() {
		
		G.menuDetails();
		BaseClass.getlogger().info("*******Getting the details of submenu*******");
	   
	}

}

