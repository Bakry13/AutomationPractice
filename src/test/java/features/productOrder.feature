@productOrder
Feature: Product Order
  As a user I want to verify the product order is placed in order history page

  Scenario Outline: Validate that the order is placed in order history page after authenticating as new user
    Given automationPractice website is opened
    When  I click Sign in
    And   I write new "<email>"
    And   I press create an account
    And   I select "<gender>"
    And   I write first name with value "<firstName>"
    And   I write last name with value "<lastName>"
    And   I write password with value "<password>"
    And   I write address with value "<address>"
    And   I write city "<city>"
    And   I choose state "<state>"
    And   I write postal code with value "<postalCode>"
    And   I write mobile number with value "<mobile>"
    And   I click Register
    And   I select the "<category>"
    And   I click on "<subcategory>"
    And   I click on "<resultItem>" to buy
    And   I click on Add to Cart to enter the process
    And   I click on Proceed to checkout to check product summary
    And   I click on Proceed to checkout for product summary
    And   I click on Proceed to checkout for address
    And   I click on Terms of service checkbox
    And   I click on Proceed to checkout for shipping
    And   I click on pay by bank wire to choose the payment method
    And   I click on I confirm my order to finish process
    And   I click on Back to orders to check order history
    Then  I validate that the order is placed in order history page with the correct date and "<price>"

    Examples:
      | email  | gender  | firstName  | lastName  | password  | address  | city  | state  | postalCode  | mobile  | category  | subcategory  | price  |
      | email1 | gender1 | firstName1 | lastName1 | password1 | address1 | city1 | state1 | postalCode1 | mobile1 | category1 | subcategory1 | price1 |
      