Feature:
  Verify the Delete functionality

  Scenario: Verify the Delete functional for a particular author
    Given Perform Delete for the id "/posts/{id}/"
    | id  |
    | 33  |
    Then I should see the details of author "Tim" is deleted