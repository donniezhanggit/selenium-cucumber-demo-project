Feature: Verify customer checkout 

Background:
Given customer open website home page "http://automationpractice.com/index.php"
Then click *Sign in* button (in the header)


Scenario: In order to verify successfull signup with valid details
Given customer enter valid email address "anthonyroi1234@test.com"
Then click on Create An Account button
Then enter valid account details as 
|	Title	|	FirstName	| LastName	|	Password	| DOB					|	Company				| Address1		|Address2		| City		| State			| ZipCode		|	AdditionatInfo	| HomePhone	 | MobilePhone	|	AssignAddress_Alis	|
| Mr		| Anthony		| Roi				|	12345678	| 12-12-1989	| Test Company	| Qwerty 1		| Qwerty 2 	|	Qwerty	| Colorado	| 12345 		| Qwerty					|12345123123 | 12345123123	| Address							|

Then customer click on register button  
Then should registered successfully and verify page URL contains "controller=my-account"
And verify welcome account name as "Anthony Roi"
And verify welcome text as "Welcome to your account."
And verify if logout button is visible 









