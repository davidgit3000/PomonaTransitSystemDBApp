package pts.q1;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//import helper.DBConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import pts.BackToHome;

public class DisplayTripScheduleController {
	@FXML
	private TextField startLocationNameInput;
	@FXML
	private TextField destinationNameInput;
	@FXML
	private DatePicker datePicker;

	FXMLLoader loader;
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	public void backAction(ActionEvent event) throws SQLException, IOException {
		BackToHome home = new BackToHome();
		home.backToHome(event);
	}

	public void displayAction(ActionEvent event) throws SQLException, IOException {
		String startLoc = startLocationNameInput.getText();
		String destLoc = destinationNameInput.getText();
		LocalDate myDate = datePicker.getValue();

		if (startLoc.equals("") || myDate == null || destLoc.equals("")) {
			System.out.println("Missing");
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText(null);
			alert.setContentText("Missing data field(s). Please fill out all the fields");
			alert.showAndWait();
		} else {
			loader = new FXMLLoader(getClass().getResource("DisplayTripScheduleResult.fxml"));
			root = loader.load();
			
			String date = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			DisplayTripScheduleResultController tripController = loader.getController();
			tripController.setData(startLoc, destLoc, date);

			if (!tripController.isInvalidData()) {
				scene = new Scene(root);
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.setTitle("Trip Schedule Result");
				stage.show();
			}
		}
	}
}
