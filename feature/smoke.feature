Feature: smoke

	@smoke
  Scenario: Checking the fundamentals
    Given navigate to the justdial page
    Then Match the title of the webpage
    
    
  @smoke @regression
	Scenario: applyingg the filter
		Given Visit on justdial page
    When give the location
    And Enter the data
    Then click on the filter button
    And Apply filter
    
  @regression 
	Scenario: Getting the service provider details
		Given open the homepage
		When give near by location
		And enter the service required
    And click and apply filter
    Then Getting the details of service provider
    
  @smoke
	Scenario: Vaidating the freelisting page
		Given open the justdial page
		And click on the freelisting
		Then validate the title of the freelisting page
		
		
	@regression @smoke
	Scenario Outline: Pass the wrong number
		Given Navigate to the justdial homepage
		When user click on the freelisting
		When enter the wrong number as "<Phone>"
		And click on the Start 
		Then validating the error message show
		
		
		Examples:
			| Phone            |
			| 172382822        |
			| 272382822        |
		
		
		
	@smoke
	Scenario: Essentials steps for the gym page
		Given Navigate the justdial homepage
		Then  match title of the webpage
		When Scroll down to the GYM icon 
		Then click on the gym 
		
	@regression
	Scenario: Getting the submenu details
		
		Given give the location for gym page
		When Scroll down to the GYM  on homepage
		When click the gym button
		Then Store the  submenu and display
		And Display all the Submenu
    
    
   
