#Author: kaustav.mondal@codeclouds.in
#Date: 22.03.2021
#Description:

Feature: To test some HomePage components

  Background: 
    Given user has already logged in the application
      | username                    | password     |
      | kaustavmondal1989@gmail.com | Kaustav@1989 |
@test
  Scenario: Check homepage components
    Given user is on homepage
    Then check these sections are available validate the count as four
      | Contacts activity stream |
      | Deals                    |
      | Twitter                  |
      | Exchange Rates           |
