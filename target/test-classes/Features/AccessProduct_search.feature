Feature: feature to test search bar funcationality

	@SmokeTest
  Scenario: Validate search bar in evermos is working
    Given open browser
    When home web page
    And user login
    When user enters a text in search box
    And user click enter
    When user is navigated to search results
    Then verify search result
