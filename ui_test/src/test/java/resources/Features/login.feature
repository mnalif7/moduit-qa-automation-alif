Feature: Login

    Scenario: Login with valid user credential
        Given user is on login page
        When user enters standard_user and secret_sauce
        And clicks on login button
        Then user is navigated to the home page

    Scenario: Login with invalid username
        Given user is on login page
        When user enters invalid and secret_sauce
        And clicks on login button
        Then error invalid_username/password appear

    Scenario: Login with empty username
        Given user is on login page
        When user enters  and secret_sauce
        And clicks on login button
        Then error username_required appear

    Scenario: Login with empty password
        Given user is on login page
        When user enters standard_user without password
        And clicks on login button
        Then error password_required appear

    Scenario: Login with locked out user
        Given user is on login page
        When user enters locked_out_user and secret_sauce
        And clicks on login button
        Then error locked_out appear