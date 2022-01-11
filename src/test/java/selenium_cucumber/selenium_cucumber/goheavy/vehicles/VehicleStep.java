package selenium_cucumber.selenium_cucumber.goheavy.vehicles;

import org.junit.Assert;

import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.general.Steps;
import selenium_cucumber.selenium_cucumber.goheavy.vehicles.page.*;

@SuppressWarnings("unused")
public class VehicleStep extends Steps {
    public VehiclePage vehiclePage;

    public VehicleStep() {
        vehiclePage = new VehiclePage();

    }

    public void checkPage() {
        String path = vehiclePage.getPagePath().toLowerCase();
        Assert.assertTrue(" The path provided is not correct in the url. path: " + path,
                vehiclePage.getCurrentUrl().toLowerCase().contains(path));
    }

    public void goToAccountSettingsView() {
        try {
            Setup.getWait().thread(500);
            Assert.assertTrue(vehiclePage.goToVehiclesAndInsuranceListView());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void userClicksOnAddVehicleButton() {
        vehiclePage.clickOnAddVehicleButton();
    }

    public void theSystemOpensTheAddVehicleView() {
        try {
            Assert.assertTrue(vehiclePage.systemOpensAddVehicleView());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void hoverOverImageComponent() {
        try {
            Assert.assertTrue(vehiclePage.hoverOverImageComponent());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void userInsertsValidDataAndClicksDone() {

        try {
            TabsPage tp = new VehicleInfoPage();
            tp.insertValidData();
            tp = new VehicleFeaturesPage();
            tp.insertValidData();
            tp = new DrivingRequirementsPage();
            tp.insertValidData();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void systemCreatesVehicleOnStatus(String status) {
        try {
            Assert.assertNotNull(vehiclePage.systemCreatesVehicleOnStatus(status));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void systemRegistersCreationDate() {
        try {
            Assert.assertNotNull(vehiclePage.systemsRegistersCreationDate());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void returnToMainView() {
        checkPage();
    }

    public void systemDisplaysAssignView() {
        try {
            Assert.assertTrue(vehiclePage.systemDisplaysAssignView());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void userAssignsTheVehicle() {
        try {
            Assert.assertTrue(vehiclePage.userAssignsTheVehicle());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void clicks_button_done() {

        vehiclePage.clicks_button_done();
    }

    public void systemDisplaysMessage(String message) {
        vehiclePage.systemDisplaysMessage(message);
    }

    /*my solution:scenario 8*/

    public void valid_data_for_VInfo_go_VFeatures() {
       try {
            Assert.assertNotNull(vehiclePage.valid_data_for_VInfo_go_VFeatures());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void clicks_on_previous_button() {
        try {
            Assert.assertNotNull(vehiclePage.clicks_on_previous_button());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void system_returns_to_VehicleInfo_view(){
        try {
            Assert.assertNotNull(vehiclePage.system_returns_to_VehicleInfo_view());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void no_data_entered_by_user_is_lost(){
        try {
            Assert.assertNotNull(vehiclePage.no_data_entered_by_user_is_lost());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
