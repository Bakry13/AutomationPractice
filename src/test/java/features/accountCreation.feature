Feature: New account creation
  As a new user I want to create an account

  Scenario Outline: Validate the correct response according to different cases for email address
    Given open automation practic website and have email account with status "<emailStatus>"
    When  click sign in
    And   write email address with value "<email>"
    And   press create an account
    Then  validate on page "<result>" according to "<emailStatus>"

    Examples: 
      | emailStatus | email  				 | result 								   |
      | empty 		  | 	   					 | Invalid email address.	   |
      | invalid  		| test		 			 | Invalid email address.    |
      | registered	| test@moakt.cc	 | An account using this email address has already been registered. Please enter a valid password or request a new one. |
      | new				  | test2@moakt.cc | YOUR PERSONAL INFORMATION |
      
  Scenario Outline: Validate that we should fill the mandatory field
    Given open automation practic website and have empty mandatory "<field>"
    When  click sign in
    And   write email address with value "<email>"
    And   press create an account
    And   write "<firstName>", "<lastName>", "<password>", "<address>", "<city>", "<state>", "<postalCode>", "<mobile>" while one "<field>" of them is empty
    And   click Register 
    Then  validate on page "<result>" according to the empty "<field>"

    Examples: 
     | field		  | email   			 | firstName  | lastName | password | address 			 | city      | state 		  | postalCode | mobile 		 | alias 		  | result 																			 |
     | email		  | test2@moakt.cc | Automation | Tester	 | Test@123 | TestingAddress | San Diago | California | 91911			 | 01011111111 | My address | email																				 |
     | firstName  | test2@moakt.cc |        		| Tester   | Test@123 | TestingAddress | San Diago | California | 91911			 | 01011111111 | My address | firstname																		 |
     | lastName   | test2@moakt.cc | Automation |     	   | Test@123 | TestingAddress | San Diago | California | 91911			 | 01011111111 | My address | lastname																		 |
     | password   | test2@moakt.cc | Automation | Tester   |          | TestingAddress | San Diago | California | 91911			 | 01011111111 | My address | passwd																			 |
     | address    | test2@moakt.cc | Automation | Tester 	 | Test@123 |                | San Diago | California | 91911			 | 01011111111 | My address | address1																		 |
     | city       | test2@moakt.cc | Automation | Tester 	 | Test@123 | TestingAddress |           | California | 91911			 | 01011111111 | My address | city																				 |
     | state      | test2@moakt.cc | Automation | Tester 	 | Test@123 | TestingAddress | San Diago | 					  | 91911			 | 01011111111 | My address | This country requires you to choose a State. |
     | postalCode | test2@moakt.cc | Automation | Tester 	 | Test@123 | TestingAddress | San Diago | California | 					 | 01011111111 | My address | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
     | mobile     | test2@moakt.cc | Automation | Tester 	 | Test@123 | TestingAddress | San Diago | California | 91911			 |  					 | My address | You must register at least one phone number. |
     | alias 		 	| test2@moakt.cc | Automation | Tester 	 | Test@123 | TestingAddress | San Diago | California | 91911			 | 01011111111 | 					  | alias																				 |
     
  Scenario Outline: Validate that we can not register using invalid field
    Given open automation practic website and we have invalid "<field>"
    When  click sign in
    And   write email address with value "<email>"
    And   press create an account
    And   write "<firstName>", "<lastName>", "<password>", "<address>", "<city>", "<state>", "<postalCode>", "<mobile>", "<birthDay>", "<birthMonth>", "<birthYear>" with invalid "<field>"
    And   click Register 
    Then  validate on page "<result>" according to the invalid "<field>"

    Examples: 
     | field									| email   			  | firstName  | lastName | password 			| address 			 | city      | state 		  | postalCode | mobile 		 | birthDay | birthMonth    | birthYear | result								|
     | password								| test2@moakt.cc	| Automation | Tester		| Test     			| TestingAddress | San Diago | California | 91911			 | 01011111111 | 1   			| Jabuary 			| 2020 			| passwd								|
     | birthDate(incomplete)	| test2@moakt.cc	| Automation | Tester		| Test@1234     | TestingAddress | San Diago | California | 91911			 | 01011111111 | 31  			|         			|      			| Invalid date of birth	|
     | birthDate(futureDate)	| test2@moakt.cc	| Automation | Tester		| Test@1234     | TestingAddress | San Diago | California | 91911			 | 01011111111 | 31  			| December 			| 2020  		| Invalid date of birth	|

       