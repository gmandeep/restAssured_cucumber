Feature: place book order

  Scenario: place book order using post api
    Given the API endpoint is ready for post
    When I create an order with id 0, petId 0, quantity 0, shipDate "2024-10-14T06:35:53.089Z", status "placed"
    Then I should receive a 200 status code for post
    And the response should contain the order's id, petId, quantity, and status
