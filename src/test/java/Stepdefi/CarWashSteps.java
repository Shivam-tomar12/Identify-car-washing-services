package Stepdefi;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CarService;
import pageobjects.HomePage;


public class CarWashSteps {

	HomePage H;
	Properties p;
	CarService c;
	
	@Given("visit on the justdial page")
	public void visit_on_the_justdial_page() throws IOException {
		BaseClass.getlogger().info("*******Navigate to the Justdial homePage*******");
	    H = new HomePage(BaseClass.getDriver());
	    H.handleADD();
	    
		BaseClass.ScreenShots("Homepage.png");
		
		
	}
	
	@Then("validate the title of the webpage")
	public void validate_the_title_of_the_webpage() {
		BaseClass.getlogger().info("*******Validating the title*******");
	    String expTitle = "Find Businesses Near You on Local Search Engine - Justdial";
	    String actTitle = H.Title();
	    Assert.assertEquals(expTitle, actTitle);
	    
	}
	
	@When("Enter the nearest location")
	public void enter_the_nearest_location() throws IOException {
		
	    H.setLocation();
	    BaseClass.ScreenShots("Location.png");
	    BaseClass.getlogger().info("*******Get the location*******");
	}

	@When("give the proper data and search")
	public void give_the_proper_data_and_search() throws IOException {
		
		H.Search();
		BaseClass.ScreenShots("Services.png");
		BaseClass.getlogger().info("*******Enter the Car washing services and search*******");
	    
	}
	
	@When("Click on the apply filter button")
	public void click_on_the_apply_filter_button() {
		c = new CarService(BaseClass.getDriver());
		c.click();

	}
	
	@When("applying the filter as per description")
	public void applying_the_filter_as_per_description() throws IOException {
		
		BaseClass.ScreenShots("filter.png");
		c.applyFilter();
		BaseClass.getlogger().info("*******Apply the filter*******");
		
		    
	}

	@Then("Getting the all car washing service provider details")
	public void getting_the_all_car_washing_service_provider_details() throws InterruptedException, IOException {
		BaseClass.getlogger().info("*******Getting the details of services*******");
		
	    c.getDetails();
	    BaseClass.ScreenShots("servicesproviders.png");
		
	}




	
	
}
