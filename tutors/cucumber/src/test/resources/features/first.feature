# language: en
  Feature: Taking money from wallet

    Scenario: Successfully operation
      Given user have 12000 rub
      When user take 1000 rub
      Then user have 11000 rub
