Feature: Add Driver 2.3
  As a: GoHeavy Admin / Fleet Owner
  I Want To: add a Driver	
  So That: a new Driver is registered in the system.
  
  Background:
    Given Any "GoHeavy Admin / Fleet Owner" is logged
    And The user is in "Drivers List" view.

   Scenario: Add Goheavy Driver
    When User clicks on "Add Driver" button.
    And The system opens the "Add Driver" view.
    And The user inserts valid data.
    And The user clicks on "Add" button.
    Then The System displays message "A new Driver was successfully created."
    And System returns to the "Drivers List" view
   # And The System Creates a new Driver in "On-boarding" status.

    Scenario: Add Vehicle
     And The user inserts valid data