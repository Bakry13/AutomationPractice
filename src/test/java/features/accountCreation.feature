@accountCreation
Feature: New account creation
  As a new user I want to create an account

  Scenario Outline: Validate invalid email address message for invalid cases "<emailStatus>"
    Given automationPractice website is opened
    When  I click Sign in
    And   I write new "<email>"
    And   I press create an account
    Then  I validate on invalid email message
    Examples:
      | emailStatus | email         |
      | empty       | invalidEmail1 |
      | invalid     | invalidEmail2 |

  Scenario Outline: Validate already registered email address message
    Given automationPractice website is opened
    When  I click Sign in
    And   I write new "<email>"
    And   I press create an account
    Then  I validate on already registered email message
    Examples:
      | email  |
      | email2 |

  Scenario Outline: Validate invalid password message when we register with invalid password
    Given automationPractice website is opened
    When  I click Sign in
    And   I write new "<email>"
    And   I press create an account
    And  I write "<firstName>", "<lastName>", "<password>", "<address>", "<city>", "<state>", "<postalCode>", "<mobile>"
    And  I click Register
    Then I validate the invalid password message
    Examples:
      | email  | firstName  | lastName  | password        | address  | city  | state  | postalCode  | mobile  |
      | email3 | firstName1 | lastName1 | invalidPasswor1 | address1 | city1 | state1 | postalCode1 | mobile1 |

  Scenario Outline: Validate that we should fill the mandatory field "<field>"
    Given automationPractice website is opened
    When I click Sign in
    And I write new "<email>"
    And I press create an account
    And I write "<firstName>", "<lastName>", "<password>", "<address>", "<city>", "<state>", "<postalCode>", "<mobile>"
    And I clear tested "<field>"
    And  I click Register
    Then I validate on page Error text according to the empty "<field>"
    Examples:
      | field      | email  | firstName  | lastName  | password  | address  | city  | state  | postalCode  | mobile  | alias      |
      | email      | email3 | firstName1 | lastName1 | password1 | address1 | city1 | state1 | postalCode1 | mobile1 | My address |
      | firstName  | email3 | empty      | lastName1 | password1 | address1 | city1 | state1 | postalCode1 | mobile1 | My address |
      | lastName   | email3 | firstName1 | empty     | password1 | address1 | city1 | state1 | postalCode1 | mobile1 | My address |
      | password   | email3 | firstName1 | lastName1 | empty     | address1 | city1 | state1 | postalCode1 | mobile1 | My address |
      | address    | email3 | firstName1 | lastName1 | password1 | empty    | city1 | state1 | postalCode1 | mobile1 | My address |
      | city       | email3 | firstName1 | lastName1 | password1 | address1 | empty | state1 | postalCode1 | mobile1 | My address |
      | state      | email3 | firstName1 | lastName1 | password1 | address1 | city1 | empty  | postalCode1 | mobile1 | My address |
      | postalCode | email3 | firstName1 | lastName1 | password1 | address1 | city1 | state1 | empty       | mobile1 | My address |
      | mobile     | email3 | firstName1 | lastName1 | password1 | address1 | city1 | state1 | postalCode1 | empty   | My address |
      | alias      | email3 | firstName1 | lastName1 | password1 | address1 | city1 | state1 | postalCode1 | mobile1 | empty      |

  Scenario Outline: Validate that we can not register using invalid birthDate
    Given automationPractice website is opened
    When I click Sign in
    And  I write new "<email>"
    And  I press create an account
    And  I write "<firstName>", "<lastName>", "<password>", "<address>", "<city>", "<state>", "<postalCode>", "<mobile>"
    And  I fill birthDate "<birthDay>", "<birthMonth>", "<birthYear>"
    And  I click Register
    Then I validate on invalid birthDate message
    Examples:
      | email  | firstName  | lastName  | password   | address  | city  | state  | postalCode  | mobile  | birthDay | birthMonth | birthYear | result                |
      | email3 | firstName1 | lastName1 | password14 | address1 | city1 | state1 | postalCode1 | mobile1 | day1     | empty      | empty     | Invalid date of birth |