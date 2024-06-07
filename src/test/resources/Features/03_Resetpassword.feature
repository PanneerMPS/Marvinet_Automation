Feature: Reset password feature test scenarios
User should be able to change the password if user forgot his/her password

@resetpassword @resetpassword01 @validcredentials @sanity @regression @sanity @all
Scenario Outline: T001 User forgot the email address or password with resetpassword
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
And User enters the OTP and click verify OTP button
And User enters the valid new password and confirm password
Then User should get a password updated error message as "<successMessage>"
 Examples:
      | successMessage      |
      | Password updated    |

@resetpassword @resetpassword02 @invalidemail @smoke @regression @all
Scenario Outline: T002 Check password does not match scenario
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
And User enters the OTP and click verify OTP button
And User enters the invalid new password and confirm password
Then User should get a confirm password does not match error message in resetpassword page

@resetpassword @resetpassword03 @invalidemail @smoke @regression @all
Scenario Outline: T003 Check invalid OTP error displayed or not
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
And User enters the INVOTP and click verify OTP button
Then User should get a invalid OTP error message in OTP page as "<errorMessage>"
 Examples:
      | errorMessage   |
      | Invalid OTP    |

@resetpassword @resetpassword04 @invalidemail @smoke @regression @all
Scenario Outline: T004 Check required error messages
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
And User enters the OTP and click verify OTP button
And User Clicks the both new and confirm password fields
Then User should get a passsword is required error message in resetpassword page

@resetpassword @resetpassword05 @invalidemail @smoke @regression @all
Scenario Outline: T005 Check login page display on clicking remember password
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
And User enters the OTP and click verify OTP button
And Click remember my password text
Then Verify login page should display
      
      
      
      
      
      
      
      
      
      
      
      
      