Feature: Product Order
  As a user I want to verify the product order is placed in order history page

  Scenario Outline: Validate that the order is placed in order history page after authenticating as new user
    Given automationpractice website is opened
    When  press Sign in
    And   write new "<email>"
    And   press create an account
    And   select "<gender>"
    And   write first name with value "<firstName>"
    And   write last name with value "<lastName>"
    And   write password with value "<password>"
    And   write address with value "<address>"
    And   write city "<city>"
    And   choose state "<state>"
    And   write postal code with value "<postalCode>"
    And   write mobile number with value "<mobile>"
    And   click Register
    And   select the "<category>"
    And   click on "<subcategory>"
    And   click on "<resultItem>" to buy
    And   click on Add to Cart to enter the process
    And   click on Proceed to checkout to check product summary
    And   click on Proceed to checkout for product summary
    And   click on Proceed to checkout for address
    And   click on Terms of service checkbox
    And   click on Proceed to checkout for shipping
    And   click on pay by bank wire to choose the payment method
    And   click on I confirm my order to finish process
    And   click on Back to orders to check order history
    Then  validate that the order is placed in order history page with the correct date and "<price>"

    Examples: 
      | email   			 | gender| firstName  | lastName | password | address 							| city      | state 		 | postalCode | mobile 			| category | subcategory | price  |
      | test1008@moakt.cc | Mr	   | Automation | Test		 | Test@123 | San Diago, California | San Diago | California | 91911			| 01011111111 | WOMEN		 | Blouses		 | $29.00 |