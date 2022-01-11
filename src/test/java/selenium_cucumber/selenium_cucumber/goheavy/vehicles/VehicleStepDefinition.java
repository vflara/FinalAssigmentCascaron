package selenium_cucumber.selenium_cucumber.goheavy.vehicles;

import io.cucumber.java.en.*;
import selenium_cucumber.selenium_cucumber.general.GeneralSteps;

public class VehicleStepDefinition {
    private VehicleStep vehicleStep;
    @SuppressWarnings("unused")
    private GeneralSteps generalSteps;

    public VehicleStepDefinition() {
        vehicleStep = new VehicleStep();
        generalSteps = new GeneralSteps();
    }

    @When("User clicks on \"Add Vehicle\" button.")
    public void the_user_clicks_on_add_vehicle_button() {
            vehicleStep.userClicksOnAddVehicleButton();
    }

    @Given("The system opens the \"Add Vehicle\" view.")
    public void the_system_opens_the_add_vehicle_view() {
        try {
            vehicleStep.theSystemOpensTheAddVehicleView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("User hover overs a Vehicle document image component with an image loaded")
    public void hover_over_image_component_with_image() {
        try {
            vehicleStep.hoverOverImageComponent();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("The user inserts valid data")
    public void the_user_inserts_valid_data_and_clicks_done_button() {
        try {
            vehicleStep.userInsertsValidDataAndClicksDone();
            vehicleStep.clicks_button_done();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("User clicks on the \"Done\" button.")
    public void clicks_button() {
        vehicleStep.clicks_button_done();
    }

    //Improve this to meet the other NF requirement
    @Then("The System Creates a new Vehicle in {string} status.")
    public void the_system_creates_vehicle_and_registers_date(String status) {
        try {
            vehicleStep.systemCreatesVehicleOnStatus(status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @And("The System registers the creation date.")
    public void the_system_registers_the_creation_date() {
        try {
            vehicleStep.systemRegistersCreationDate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("System returns to the \"Vehicles & Insurance List\" view")
    public void returns_to_view() {
        vehicleStep.returnToMainView();
    }

    @Then("System displays message {string}")
    public void system_displays_message(String message) {
        vehicleStep.systemDisplaysMessage(message);
    }

    @Then("The system displays \"Assign Vehicle\" view.")
    public void system_displays_assign_view() {
        try {
            vehicleStep.systemDisplaysAssignView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("User assigns the vehicle.")
    public void user_assigns_the_vehicle() {
        try {
            vehicleStep.userAssignsTheVehicle();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*my solution:scenario 8*/
    @And("User inserts valid data for Vehicle Info and go to Vehicle Features.")
    public void valid_data_for_VInfo_go_VFeatures() {
        vehicleStep.valid_data_for_VInfo_go_VFeatures();
    }

    @When("Clicks on the \"Previous\" button.")
    public void clicks_on_previous_button() {
        vehicleStep.clicks_on_previous_button();
    }

    @Then("The system returns to the Vehicle Info view.")
    public void system_returns_to_VehicleInfo_view() {
        vehicleStep.system_returns_to_VehicleInfo_view();
    }

    @And("No data entered by the user in the system is lost.")
    public void no_data_entered_by_user_is_lost() {
        vehicleStep.no_data_entered_by_user_is_lost();
    }

}
