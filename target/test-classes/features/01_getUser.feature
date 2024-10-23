Feature: User API Test

Scenario: Fetch user details successfully
    Given the API endpoint is ready
    When I make a GET request to "/v2/store/inventory"
    Then I should receive a 200 status code
    And the response should inventory details
