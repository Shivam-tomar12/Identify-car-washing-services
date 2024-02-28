package Stepdefi;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CarService;
import pageobjects.FreeListing;
import pageobjects.GymPage;
import pageobjects.HomePage;

public class tags {
	
	HomePage H;
	Properties p;
	CarService c;
	FreeListing F;
	GymPage G;
	
	
	//scenario1
	
	@Given("navigate to the justdial page")
	public void navigate_to_the_justdial_page() {
		BaseClass.getlogger().info("*******Navigate to the justdial page*******");
		H = new HomePage(BaseClass.getDriver());
	    H.handleADD();
	}

	@Then("Match the title of the webpage")
	public void match_the_title_of_the_webpage() {
		BaseClass.getlogger().info("*******Validating the title*******");
		String expTitle = "Find Businesses Near You on Local Search Engine - Justdial";
	    String actTitle = H.Title();
	    Assert.assertEquals(expTitle, actTitle);
	}
	
	
	//scenario2

	@Given("Visit on justdial page")
	public void visit_on_justdial_page() {
		
		H = new HomePage(BaseClass.getDriver());
	    H.handleADD();
	    
	}

	@When("give the location")
	public void give_the_location() {
		BaseClass.getlogger().info("*******Applying the location *******");
		H.setLocation();
	}

	@When("Enter the data")
	public void enter_the_data() {
		BaseClass.getlogger().info("*******Give the input*******");
		H.Search();
	}

	@Then("click on the filter button")
	public void click_on_the_filter_button() {
		BaseClass.getlogger().info("*******click on the filter button*******");
		c = new CarService(BaseClass.getDriver());
		c.click();
	}

	@Then("Apply filter")
	public void apply_filter() {
		BaseClass.getlogger().info("*******Applying the filter*******");
		c.applyFilter();
	}
	
	
	//sc 3
	
	

	@Given("open the homepage")
	public void open_the_homepage() {
		H = new HomePage(BaseClass.getDriver());
	    H.handleADD();
	}

	@When("give near by location")
	public void give_near_by_location() {
		H.setLocation();
	}

	@When("enter the service required")
	public void enter_the_service_required() {
		BaseClass.getlogger().info("*******Car washing services as input*******");
		H.Search();
	}

	@When("click and apply filter")
	public void click_and_apply_filter() {
		c = new CarService(BaseClass.getDriver());
		c.click();
		c.applyFilter();
	    
	}

	@Then("Getting the details of service provider")
	public void getting_the_details_of_service_provider() throws InterruptedException, IOException {
		BaseClass.getlogger().info("*******Getting the details*******");
		c = new CarService(BaseClass.getDriver());
		c.getDetails();
	    
	}
	
	
	
	// sc 4
	
	

	@Given("open the justdial page")
	public void open_the_justdial_page() {
		H = new HomePage(BaseClass.getDriver());
	    H.handleADD();
	    
	}

	@Given("click on the freelisting")
	public void click_on_the_freelisting() {
		BaseClass.getlogger().info("*******on the freelisting page*******");
		 H.FreeClick();
	}

	@Then("validate the title of the freelisting page")
	public void validate_the_title_of_the_freelisting_page() {
		BaseClass.getlogger().info("*******Validating the freelisting title*******");
		F = new FreeListing(BaseClass.getDriver());
	    String actTitle = "Free Listing - Just Dial - List In Your Business For Free";
	    String ExpTitle = F.freeTitle();
	    Assert.assertEquals(actTitle, ExpTitle);
	}
	
	
	
	
	// sc 5

	@Given("Navigate to the justdial homepage")
	public void navigate_to_the_justdial_homepage() {
		H = new HomePage(BaseClass.getDriver());
	    H.handleADD();
		
	}

	@When("user click on the freelisting")
	public void user_click_on_the_freelisting() {
		H.FreeClick();
	}

	@When("enter the wrong number as {string}")
	public void enter_the_wrong_number_as(String Phone) {
		BaseClass.getlogger().info("*******Enter the wrong number*******");
		F = new FreeListing(BaseClass.getDriver());
		F.enternumber(Phone);
		
	}

	@When("click on the Start")
	public void click_on_the_start() {
	   
		F.clickbtn();
	}

	@Then("validating the error message show")
	public void validating_the_error_message_show() {
		BaseClass.getlogger().info("*******Validating the erroe message*******");
		String Expectedmsg = "Please Enter a Valid Mobile Number";
		String ActualMsg = F.getErrorMsg();
		System.out.println(ActualMsg);
		Assert.assertEquals(Expectedmsg, ActualMsg);
	}
	
	
	//sc 6

	@Given("Navigate the justdial homepage")
	public void navigate_the_justdial_homepage() {
		
		H = new HomePage(BaseClass.getDriver());
	    H.handleADD();
	    
	}

	@Then("match title of the webpage")
	public void match_title_of_the_webpage() {
		String expTitle = "Find Businesses Near You on Local Search Engine - Justdial";
	    String actTitle = H.Title();
	    Assert.assertEquals(expTitle, actTitle);
	    
	}

	@When("Scroll down to the GYM icon")
	public void scroll_down_to_the_gym_icon() {
		BaseClass.getlogger().info("*******Scroll to gym*******");
		H = new HomePage(BaseClass.getDriver());
		H.scrolldown();
	}

	@Then("click on the gym")
	public void click_on_the_gym() {
		H.gymClick();
	}
	
	
	
	//sc
	
	
	

	@Given("give the location for gym page")
	public void give_the_location_for_gym_page() {
		H = new HomePage(BaseClass.getDriver());
	    H.handleADD();
	    H.setLocation();
		
	}

	@When("Scroll down to the GYM  on homepage")
	public void scroll_down_to_the_gym_on_homepage() {
		H = new HomePage(BaseClass.getDriver());
		H.scrolldown();
	    
	}

	@When("click the gym button")
	public void click_the_gym_button() {
		H.gymClick();
	}

	@Then("Store the  submenu and display")
	public void store_the_submenu_and_display() {
		BaseClass.getlogger().info("*******Getting the only submenu*******");
		G = new GymPage(BaseClass.getDriver());
		   G.submenu();
	}

	@Then("Display all the Submenu")
	public void display_all_the_submenu() {
		BaseClass.getlogger().info("*******Getting the dropdowns of submenu*******");
		G.menuDetails();
	}




}
