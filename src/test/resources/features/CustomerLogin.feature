Feature: Verify customer login 

Background:
Given customer open website home page "http://automationpractice.com/index.php"
Then click *Sign in* button (in the header)


Scenario: In order to verify successfull login with valid email and valid password
Given customer enter valid  email "hf_challenge_1234567@hf12345.com" and  valid password "12345678" 
Then customer click on signin button  
Then should signin successfully and verify page URL contains "controller=my-account"
And verify welcome account name as "Vikas Kumar"
And verify welcome text as "Welcome to your account."
And verify if logout button is visible 


Scenario: In order to verify unsuccessfull login with invalid email and valid password
Given customer enter invalid  email "invalid@hf12345.com" and  invalid password "invalid" 
Then customer click on signin button  
Then should show error with message "Authentication failed."






