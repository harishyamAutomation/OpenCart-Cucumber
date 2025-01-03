#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Customer

  Background: Verify Customers Page
    #Given User launches the browser
    Given User openes the url "https://localhost/opencart/upload/admin/index.php"
    Then User should verify title "Administration" for login page
    When User enters username as "admin" and password as "admin"
    And User Click on the login button
    Then User should verify the title "Dashboard" for Dashboard page
    When User navigate to Customers Menu
    And Users clicks on Customers menu item
    Then User should get the Customers page

  Scenario: Test to Add a customer
    When User click on Add New button
    And User should fill all the customer general details
    And Click on Save button
    Then User should get the success message "Success: You have modified customers!"
    And Logout the session
    
  Scenario Outline: Test to Add Multiple customers DDT
    When User click on Add New button
    And User should fill "<firstname>", "<lastname>", "<email>", "<phone>", "<password>"
    And Click on Save button
    Then User should get the success message "Success: You have modified customers!"
    #And Logout the session
    Examples:
    	|firstname|lastname|email|phone|password|
			|ICPJFNN1|TRHFVHL|hMGxYnXeNSV1@gmail.com|8701335357|Pzwr&7#6#0&4|
			|CLCPJGA1|PVAMPMK|yZukOZLvVEQ1@gmail.com|8465058137|Dzkf#7_1_6%0|
			|FAWTRJL1|ATSZTET|auafyUUjPUC1@gmail.com|8208040255|Oosh#2-1^6^1|
			|CQWJRLJ1|PPVCESH|BwguqJOikSR1@gmail.com|8286855432|Llvm^9_6-7@6|
			|YDTRZET1|LMTYBBH|tNArLAzsnYd1@gmail.com|8839023438|Cgfl~7!9_0&1|

	#@ExcelData
	#Scenario: Test to Add multiple customers with data from excel
  #  When User click on Add New button
  #  And User should fill all the customer details from testData excel
  #  And Click on Save button
  #  Then User should get the success message "Success: You have modified customers!"
  #  #And Logout the session
    
  #And User closes the browser
  @Sanity
  Scenario: Test to find customer by Customer Name
    When User enter customer Name
    And click on Filter button
    Then User find the customer by customer name
    And Logout the session

  #And User closes the browser
  @Sanity
  Scenario: Test to find customer by Email
    When User enter customer email
    And click on Filter button
    Then User find the customer by email
    And Logout the session
    #And User closes the browser
