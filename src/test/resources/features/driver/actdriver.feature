Feature: Activate Driver
  As a: GoHeavy Admin / Fleet Owner
  I Want To: Activate a Driver
  So That: a new Driver is activated in the system.
  
  Background:
    Given Any "GoHeavy Admin / Fleet Owner" is logged
    Given The user is in "Drivers List" view.
    Given User Add a "Driver" from Drivers List
    Given User Add a "Vehicle" from Vehicles & Insurance List
    Given User approves "Documents"

  Scenario: Activate Goheavy Driver
   When User clicks on "Edit Driver" button.
   And User updates the Status.
   Then The driver is set to GoHeavy Ready.
