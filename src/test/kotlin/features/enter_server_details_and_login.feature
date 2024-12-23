Feature: Enter server details and login
  User will enter server details and login

  Scenario Outline: User enter correct credentials and login
    Given Ip is "<ip>"
    And SSL switch is "<ssl>"
    And Port is <port>
    And BranchPrefix is "<brPrefix>"
    And UnitID is "<unitId>"
    When User press the Connect Button
    Then User will be navigated to webview

    Examples:
      | ip        | ssl      | port | brPrefix | unitId |
      | 10.20.1.6 | disabled | 8888 | BR1      | KION1  |
      | 10.20.1.6 | enabled  | 8888 | BR1      | KION1  |
      | 10.20.1.8 | disabled | 8888 | BR1      | KION1  |
      | 10.20.1.6 | disabled | 8888 | BR1      | KION2  |