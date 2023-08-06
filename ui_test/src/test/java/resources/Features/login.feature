Feature: Login

    Scenario: Login with valid user credential
        Given user is on login page
        When user enters standard_user and secret_sauce
        And clicks on login button
        Then user is navigated to the home page