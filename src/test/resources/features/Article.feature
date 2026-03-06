Feature: Conduict Website Task using Cucumber POM
This feature is to test the Cucumber functionality using POM on Conduict Website


Scenario: User Login to Conduict page
Given user opens the Url
When user enters the credentials
Then user clicks on the login button

Scenario: User Add New Article
Given user is on Home page
When user clicks on the New Article
Then user enters the title "Manikandan TC001"
Then user enters the Description
Then user enters the body details
#Then user clicks on publish button

Scenario: User Edit the Article
Given user validates the Existing Article "Manikandan TC001"
When user clicks on Edit Article
Then user updates the Description
Then user update the Tags tab
And user clicks on update Article

Scenario: User Delete the Article
Given user clicks on delete Article
Then User validates the Alert message 
Then user accepts the alert
And user validates the deleted article "Manikandan TC001" is present on the Articlepage

Scenario: Invalid login
Given user logout the page
When user enters the Invalid "Wrongurl@gmail.com" and "NoWorries"
Then user clicks on the login button
