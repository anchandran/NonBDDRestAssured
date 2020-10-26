Feature:
    Verify the GET functionality

  Scenario: Verify the GET functional for a particular author
    Given Perform GET for id "5"
    Then I should see the details of author "james"

  Scenario: Verify the GET functional for all products
    Given Perform GET for all products
    Then I should see all product details