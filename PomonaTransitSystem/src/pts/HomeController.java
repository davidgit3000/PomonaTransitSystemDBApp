package pts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import pts.DBConnect;
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

public class HomeController {
	FXMLLoader loader;
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	public void displayTripScheduleWindowAction(ActionEvent event) throws IOException {
		loader = new FXMLLoader(getClass().getResource("/pts/q1/DisplayTripSchedule.fxml"));
		root = loader.load(); 
		
		scene = new Scene(root);
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void displayTripStopInfoWindowAction(ActionEvent event) throws IOException {
		loader = new FXMLLoader(getClass().getResource("/pts/q3/DisplayStopsFX.fxml"));
		root = loader.load(); 
		
		scene = new Scene(root);
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void displayDriversWindowAction(ActionEvent event) throws IOException {
		loader = new FXMLLoader(getClass().getResource("/pts/q5/AddDriverFX.fxml"));
		root = loader.load(); 
		
		scene = new Scene(root);
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void displayBusWindowAction(ActionEvent event) throws IOException {
		loader = new FXMLLoader(getClass().getResource("/pts/q6/AddBusFX.fxml"));
		root = loader.load(); 
		
		scene = new Scene(root);
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void displayDeleteBusWindowAction(ActionEvent event) throws IOException {
		loader = new FXMLLoader(getClass().getResource("/pts/q7/DeleteBusFX.fxml"));
		root = loader.load(); 
		
		scene = new Scene(root);
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}