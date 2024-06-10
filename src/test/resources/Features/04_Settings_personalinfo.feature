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

@personalinfo @personalinfo02 @regression @sanity @all
Scenario Outline: T002 To verify personal profile page fields
When User enters valid email address
And Enter valid password
And Click password field eye icon
And Clicks on Sign in button
And Go to settings feature
And Click personal profile option
Then Check the personal profile page fields

@personalinfo @personalinfo03 @regression @sanity @all
Scenario Outline: T003 To update the user personal profile
When User enters valid email address
And Enter valid password
And Click password field eye icon
And Clicks on Sign in button
And Go to settings feature
And Click personal profile option
And Update the personal profile fields
And Click Save profile button
And Click Yes btn in confirmation popup
Then Check the personal profile updated successfully as "<successMessage>"
 Examples:
      | successMessage            |
      | Personal profile updated  |