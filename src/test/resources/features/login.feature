#Author: Harishyam Sharma
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
Feature: Login 

@Sanity
Scenario: Successful Login with Valid Credentials 
	Given User Launch Chrome browser 
	When User opens URL "https://localhost/opencart/upload/admin/"
	And User enters Username as "admin" and Password as "admin" 
	And Click on Login 
	Then Page Title should be "Dashboard" 
	When User click on Log out link 
	Then Page Title should be "Administration"

Scenario Outline: Successful Login with Valid Credentials DDT
	Given User Launch Chrome browser 
	When User opens URL "https://localhost/opencart/upload/admin/"
	And User enters Username as "<username>" and Password as "<password>" 
	And Click on Login 
	Then Page Title should be "Dashboard" 
	When User click on Log out link 
	Then Page Title should be "Administration"	

Examples:
|username|password|
|admin|admin|
|admin@yourstore.com|admin|
|username|password|
|username|admin|