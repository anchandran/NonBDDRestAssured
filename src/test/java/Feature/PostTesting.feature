Feature:
  Verify the Post functionality

  Scenario: Verify the Post functional for a particular author
    Given Perform POST for id "25"
    Then I should see the details of author "Leo"

  Scenario: Verify the Post functional for all products
    Given Perform POST for  all products
    | id |  title | author  |
    | 33 |  Canbottle | Tim  |
    | 34 |  Bamboobottle | willis  |
    | 35 |  Woddenbotell | Jack  |

    Then I should see that added product detail has "Woddenbotell"

  Scenario: Verify the Post functional for profile products
    Given Perform POST for the "/posts/{profileNo}/profile" all products
      | name |  profileNo |
      | LionKing | 4  |

    Then I should see name the "LionKing"