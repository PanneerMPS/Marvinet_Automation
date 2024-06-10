Feature: Settings page personal info module test scenarios
The logged in users can able to update his/her personal profile

@personalinfo @personalinfo01 @regression @sanity @all
Scenario Outline: T001 Settings page with personal info option
When User enters valid email address
And Enter valid password
And Click password field eye icon
And Clicks on Sign in button
And Go to settings feature
Then Check personal info option is displayed
