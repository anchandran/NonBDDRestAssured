Feature:
  Verify the Put functionality

  Scenario: Verify the Put functional for a particular author
    Given Perform PUT for the id "/posts/{id}/"
      | id  | author  | title |
      | 32  | JackJack    | Wood bottle |
    Then I should see the details of author "JackJack" is Updated

