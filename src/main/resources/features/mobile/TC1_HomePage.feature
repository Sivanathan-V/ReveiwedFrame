@Home
Feature: Searching Product on Amazon

  Scenario Outline: Search Iphones on Amazon
    Given User Should be on HomPage
    When User should Search for Product "<product>"
    And user should click on enter
    Then User should verify after product search success message "Filters"

    Examples:
      | product |
      | iphone  |