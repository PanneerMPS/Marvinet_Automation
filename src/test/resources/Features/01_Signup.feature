Feature: User Signup
Registered user should be able to login to access the al-arabia features

Background: Given User navigates to Signup page

@signup
Scenario: Signup with valid credentials
When Users Clicks Signup link
And User enters valid email address
And Enter valid mobile number
And Enter New Password
And Enter Confirm Password
And Click I Agree Checkbox
And Click Join Marvinet Button
Then Check Signed Up Successfully
