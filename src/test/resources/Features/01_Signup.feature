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
And Check Signed Up Successfully
And Go to mail signin page
And Gmail confirm account process
Then Check confirm account got success	
Then Check 2FA page showing successfully
And Click Skip in 2FA page
Then Check Complete Profile page showing successfully
And Complete the Complete profile
Then Check Verify OTP page showing successfully
And Click Veriy and Proceed button
Then Check Verify KYC page showing successfully
And Click Veriy KYC button
