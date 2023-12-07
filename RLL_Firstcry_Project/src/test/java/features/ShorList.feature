Feature: Testing FirstCry shortList  page

Scenario Outline: Testing ShortList Feature of FirstCry

Given I open the browser and enter URL of Firstcry
Then I click on login link and enter the email id '<EmailId>'

Then I click on Footwear and click on Casualshoes product
Then I click on Products on the page
Then I click on ShortList Icon
Then I Go to ShortList Page


Examples: 
      | EmailId                     |   password    |
      | subashini08092000@gmail.com |   suba2000    |


