package pts;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;

public class HomeController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private void displayScene(ActionEvent event, String fxmlFile, boolean isMenuItem) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        root = loader.load();
        
        scene = new Scene(root);
        if (!isMenuItem) {
        	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        } 
        else {
        	stage = (Stage) ((Node) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow().getScene().getRoot()).getScene().getWindow();
        }
        stage.setScene(scene);
        stage.show();
	}

	@FXML
	public void displayTripScheduleWindowAction(ActionEvent event) throws IOException { 
		displayScene(event, "/pts/q1/DisplayTripSchedule.fxml", false);
	}
	
	@FXML
	public void displayTripStopInfoWindowAction(ActionEvent event) throws IOException {	
		displayScene(event, "/pts/q3/DisplayStopsFX.fxml", false);
	}
	
	@FXML
	public void displayDriversWindowAction(ActionEvent event) throws IOException {	
		displayScene(event, "/pts/q5/AddDriverFX.fxml", false);
	}
	
	@FXML
	public void displayBusWindowAction(ActionEvent event) throws IOException {	
		displayScene(event, "/pts/q6/AddBusFX.fxml", false);
	}
	
	@FXML
	public void displayDeleteBusWindowAction(ActionEvent event) throws IOException {
		displayScene(event, "/pts/q7/DeleteBusFX.fxml", false);
	}
	
	@FXML
	public void displayDeleteTripOfferingWindowAction(ActionEvent event) throws IOException {
		displayScene(event, "/pts/q2/DeleteTripOfferingFX.fxml", true);
	}
	
	@FXML
	public void displayChangeDriverWindowAction(ActionEvent event) throws IOException {	
		displayScene(event, "/pts/q2/ChangeDriverFX.fxml", true);
	}
	
	@FXML
	public void displayChangeBusWindowAction(ActionEvent event) throws IOException {
		displayScene(event, "/pts/q2/ChangeBusFX.fxml", true);
	}
	
	@FXML
	public void displayAddTripOfferingWindowAction(ActionEvent event) throws IOException {
		displayScene(event, "/pts/q2/AddTripOfferingFX.fxml", true);
	}
}