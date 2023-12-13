Feature: Verify Cyclos Login

  Scenario Outline: Verify Login with Valid Credentials
    Given User is on the Cyclos LoginPage
    When User should login "<userName>" and "<password>"
    Then User should verify after Login success message "Demo user"
    Examples:
      | userName | password |
      | demo     | 1234     |