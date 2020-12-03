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
      
Feature: Login account
  User will login to account in opentable website in this feature file
  
Background: now user in Home page
 Given User opens Browser
 When User enter URL
 Then User navigated to HomePage 
 @login
Scenario Outline: Successsful login 
    Given  user in HomePage
    When click on Signin button
    And user enters email <uname> 
    And user gives password <pass>
    Then User Logged successfully

    Examples: 
      | uname                        | pass   | 
      |amulyasrikantam@gmail.com     |Amulya@123|
 @failogin  
Scenario Outline: unsuccesssful login 
    Given  user in HomePage
    When click on Signin button
    And user enter invalid email <uname> 
    And user give invalid password <pass>
    Then Invalid login credentials message dispayed
 
    Examples: 
      | uname                     | pass   |
      | name2                     |Amulya@123|   
 @google    
 Scenario: Successsful login using google account
    Given  user in HomePage
    When click on Signin button
    And clicks on Booking link 
    And user switches to new booking window
    And selects google icon in booking window
    And user switches to new google window
    And user enters his credentials
    And Closes new window
    Then User Logged successfully            