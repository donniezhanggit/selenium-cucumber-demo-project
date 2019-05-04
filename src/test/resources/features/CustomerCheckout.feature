Feature: Verify customer checkout process 

Background:
Given customer open website home page "http://automationpractice.com/index.php"
Then click *Sign in* button (in the header)


Scenario: In order to verify checkout for customer
Given customer enter valid  email "hf_challenge_1234567@hf12345.com" and  valid password "12345678" 
Then customer click on signin button  
Then should signin successfully and verify page URL contains "controller=my-account"
And verify welcome account name as "Vikas Kumar"
And verify welcome text as "Welcome to your account."
And verify if logout button is visible 
Then click *Women* button in the header
Then click the product with name "Faded Short Sleeve T-shirts"
Then click *Proceed to checkout* button
Then click *Proceed to checkout* button second
Then click *Proceed to checkout* button third
Then check by *Terms of service* to agree checkbox
Then click *Proceed to checkout* button for final checkout
Then click by payment method *Pay by bank wire* 
Then click *I confirm my order*
Then order confirmation page with URL "?controller=order-confirmation" is opened
And page heading with message "ORDER CONFIRMATION" should be present
And Shipping tab should be present
And Payment tab should be present
And order confirmation message with text "Your order on My Store is complete." should be there












