@api @updatedelete
Feature: Booking updation and deleting module

  @update
  Scenario Outline: Verify user is able to update all fields booking created.
    Given User adds the headers
    When User adds path parameter for updating all fields
    And User adds the payload for update booking all fields "<firstname>","<lastname>","<totalprice>","<depositpaid>","<checkin>","<checkout>","<additionalneeds>"
    And User send "PUT" request for updating all fields
    Then Verify the status code is 200

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds     |
      | James     | Carter   |       5000 | true        | 2023-10-01 | 2023-10-10 | breakfast and lunch |

  @partialUpdate
  Scenario Outline: Verify user is able to update selected fields of the booking created.
    Given User adds the headers
    When User adds path parameter for updating selected fields
    And User adds the payload for update booking selected fields "<firstname>","<lastname>"
    And User send "PATCH" request for updating selected fields
    Then Verify the status code is 200

    Examples:
      | firstname | lastname |
      | Senthil   | Ganesh   |

  @delete
  Scenario: Verify user is able to delete the booking created.
    Given User adds the headers
    When User adds path parameter for deleting booking
    And User send "DELETE" request for deleting booking
    Then Verify the status code is 201
