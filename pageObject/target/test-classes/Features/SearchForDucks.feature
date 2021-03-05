Feature: Test the google search

Scenario Outline: Verify the google search provides proper results
	Given Open browser and launch the appln "<url>"
	When I enter string "<searchString>" to search and I click google Search Button
	Then verify the results matches the search string
	Examples:
	|url|searchString|
	|http://www.google.com|ducks|