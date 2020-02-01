Feature: Testing OOP

  Scenario: Testing inheritance
    Then print BaseImpl string
    Then print concrete string after setting base string
    Then print BaseImpl string

    Scenario: Testing Datatables
      Given this table for testing typeconfigurer:
        | circleId  | circleShape |
        | 123       | round       |

