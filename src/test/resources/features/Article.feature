Feature: Conduict Website Task using Cucumber POM
This feature is to test the Cucumber functionality using POM on Conduict Website


Scenario: User Login to Conduict page
Given user opens the Url
When user enters the credentials
Then user clicks on the login button

Scenario Outline: User adds a new article
    Given user is on Home page
    When user clicks on the New Article
    Then user enters the title "<title>" Header
    And user enters the "<Description>" info
    And user enters the "<body>" details
    And user clicks on publish button

    Examples:
      | title       | Description        | body                  |
      | Selenium    | LEarning Selenium  | Content deep learning |
      | Cucumber | Learning Cucumber    | Content deep learning    |
      | POM | Learning POM   | Content deep learning    |
		


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

Scenario: Failed case
Given user refresh the page
Then user searches Home button

