#Author: kaustav.mondal@codeclouds.in
#Date: 11.03.2021
#Description:
Feature: To test the Login feature in huko site/application

  @valid
  Scenario Outline: Check login is successfull with valid credentials.
    Given user is on login page
    When user enters username "<username>"
    And User enters password "<password>"
    And user clicks on login or submit button
    Then user is navigated to homepage or dashboard page

    Examples: 
      | username                    | password     |
      | kaustavmondal1989@gmail.com | Kaustav@1989 |
      | kaustavmondal1989@gmail.com | Kaustav@1989 |
      | kaustavmondal1989@gmail.com | Kaustav@198 |
      

  @invalid
  Scenario Outline: Check login is unsuccessfull with invalid credentials.
    Given user is on login page
    When user enters username "<username>"
    And User enters password "<password>"
    And user clicks on login or submit button
    Then user is  not navigated to homepage or dashboard page

    Examples: 
      | username                    | password    |
      | kaustavmondal1989@gmail.com | Kaustav@198 |
      | kaustavmondal1989@gmail.com | Kaustav@198 |
      | kaustavmondal1989@gmail.com | Kaustav@198 |
      | kaustavmondal1989@gmail.com | Kaustav@198 |

  @fgtpasslink
  Scenario: To check whether forgot password link is available in login page
    Given user is on login page
    Then loginpage should validate that forgot password link is available
