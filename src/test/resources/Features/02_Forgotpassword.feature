Feature: Forgot password feature test scenarios
User should be able to change the password if user forgot his/her password

@forgotpassword @forgotpassword01 @validcredentials @sanity @regression @sanity @all
Scenario Outline: T001 User forgot the email address or password
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
Then Proper confirmation email message should receive to user mail "<successMessage>"
 Examples:
      | successMessage                                          |
      | Reset Password OTP sent to tamilselvan@coducer.com mail |

@forgotpassword @forgotpassword02 @invalidemail @smoke @regression @all
Scenario Outline: T002 Forgot password with invalid email address
When User clicks forgot password option
And User enters forgot password invalid email address
Then User should get a invalid email address error message in forgotpassword page

@forgotpassword @forgotpassword03 @invalidemail @smoke @regression @all
Scenario Outline: T003 Forgot password without email address
When User clicks forgot password option
And User enters forgot password invalid email address and delete
Then User should get a email address or phone number is required error message

@forgotpassword @forgotpassword04 @invalidemail @sanity @regression @all
Scenario Outline: T004 Login without registered user id
When User clicks forgot password option
And User enters invalid email address in forgot password page
And User clicks Send Reset link button
Then User should get a technician only have access error message as "<errorMessage>"
 Examples:
      | errorMessage                 |
      | Technician Only have Access  |
      
@forgotpassword @forgotpassword05 @validcredentials @sanity @regression @sanity @all
Scenario Outline: T005 User forgot the email address or password with enter OTP
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
And User enters the OTP and click verify OTP button
Then User should get a verified OTP error message as "<successMessage>"
 Examples:
      | successMessage  |
      | OTP Verified    |

@forgotpassword @forgotpassword06 @validcredentials @smoke @regression @sanity @all
Scenario Outline: T006 User remember the password
When User clicks forgot password option
And Click remember my password text
Then Verify login page should display

@forgotpassword @forgotpassword07 @validcredentials @smoke @regression @sanity @all
Scenario Outline: T007 User want to change the email and password
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
And User clicks want to change email
Then Verify login page should display

@forgotpassword @forgotpassword08 @validcredentials @sanity @regression @sanity @all
Scenario Outline: T008 User forgot the email address or password with enter OTP
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
And User enters the resend OTP and click verify OTP button 
Then User should get a verified OTP error message as "<successMessage>"
 Examples:
      | successMessage  |
      | OTP Verified    |
      
@forgotpassword @forgotpassword09 @validcredentials @smoke @regression @sanity @all
Scenario Outline: T009 User want to change the email and password
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
And Click OTP field
Then User should get a OTP is required error message
      
@forgotpassword @forgotpassword10 @validcredentials @sanity @regression @sanity @all
Scenario Outline: T010 User forgot the email address or password with enter OTP
When User clicks forgot password option
And User enters forgot password valid email address
And User clicks Send Reset link button
And User enters the OTP and click verify OTP button
Then Verify the reset password displayed or not

      
      
      
      
      
      
      
      
      
      
      
      
      
      