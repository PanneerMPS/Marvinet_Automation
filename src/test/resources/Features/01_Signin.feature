Feature: Signin feature test scenarios
Registered user should be able to login to access the al-arabia features

@signin @signin01 @validcredentials @regression @sanity @all
Scenario Outline: T001 Login with valid credentials
When User enters valid email address
And Enter valid password
And Click password field eye icon
And Clicks on Sign in button
Then User should login successfully
Then Al-Arabia dashboard should display successfully

@signin @signin02 @invalidemailandpassword @sanity @regression @all
Scenario Outline: T002 Login with invalid credentials
When User enters invalid email address
And Enter invalid password
And Click password field eye icon
And Clicks on Sign in button
Then User should get a invalid email and password error message as "<errorMessage>"
 Examples:
      | errorMessage        |
      | Invalid credential  |

@signin @signin03 @invalidpassword @smoke @regression @all
Scenario Outline: T003 Login with valid email address and invalid password
When User enters valid email address
And Enter invalid password Password
And Click password field eye icon
And Click email field
Then User should get must contain one number error message 

@signin @signin04 @invalidemail @smoke @regression @all
Scenario Outline: T004 Login with invalid email address and valid password
When User enters invalid email address without dot
And Enter valid password
And Click password field eye icon
And Click email field
Then User should get a invalid email and password error message

@signin @signin05 @invalidpassword @smoke @regression @all
Scenario Outline: T005 Login with valid email address and invalid password without special character
When User enters valid email address
And Enter invalid password without special character
And Click password field eye icon
And Click email field
Then User should get must contain one special case character error message 

@signin @signin06 @invalidpassword @smoke @regression @all
Scenario Outline: T006 Login with valid email address and invalid password without special character
When User enters valid email address
And Enter invalid password without uppercase char
And Click password field eye icon
And Click email field
Then User should get must contain one upper case character error message 

@signin @signin07 @invalidpassword @smoke @regression @all
Scenario Outline: T007 Login with valid email address and invalid password with short character
When User enters valid email address
And Enter invalid password with short char
And Click password field eye icon
And Click email field
Then User should get password is too short error message 

@signin @signin08 @invalidpassword @smoke @regression @all
Scenario Outline: T008 Login without email address and password
When Click email fieldd
And Click password field
Then User should get required error message 

@signin @signin09 @invalidemailandpassword @sanity @regression @all
Scenario Outline: T009 Login without registered user id
When User enters invalid email address1
And Enter valid password
And Click password field eye icon
And Clicks on Sign in button
Then User should get a Only technician have access to login error message as "<errorMessage>"
 Examples:
      | errorMessage                          |
      | Only technician have access to login  |



