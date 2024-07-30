package pts;

import java.io.IOException;
import pts.BackToHome;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import helper.DBConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayTripScheduleController {
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
		loader = new FXMLLoader(getClass().getResource("DisplayTripScheduleResult.fxml"));
		root = loader.load(); 
		
		// Get data from input fields
		// Set data input to 
		// Run SQL query
		// Send result to the result window
		
//		WithdrawController withdrawController = loader.getController();
//    	withdrawController.setID(id);     
    	
    	scene = new Scene(root);
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}
