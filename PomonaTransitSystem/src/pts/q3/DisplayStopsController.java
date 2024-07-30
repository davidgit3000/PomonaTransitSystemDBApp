package pts.q3;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.TripDisplay;
import model.TripStopInfo;
import pts.BackToHome;
import pts.DBConnect;
import pts.q1.DisplayTripScheduleResultController;

public class DisplayStopsController {
	@FXML
	private TextField tripNumberInput;
	
	@FXML
    private TableView<TripStopInfo> table;
    @FXML
    private TableColumn<TripStopInfo, String> tripNumberCol;
    @FXML
    private TableColumn<TripStopInfo, String> stopNumberCol;
    @FXML
    private TableColumn<TripStopInfo, String> sequenceNumberCol;
    @FXML
    private TableColumn<TripStopInfo, String> drivingTimeCol;
    
    ObservableList<TripStopInfo> tripStopList = FXCollections.observableArrayList();
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    
    String tripNumber;
    
	@FXML
	public void backAction(ActionEvent event) throws SQLException, IOException {
		BackToHome home = new BackToHome();
		home.backToHome(event);
	}
	
	// Get the data from the database
    @FXML
    private void refreshTable() {
        try  {
        	System.out.println("");
        	tripStopList.clear();
        	
            query = "SELECT * \r\n"
            		+ "FROM tripstopinfo\r\n"
            		+ "WHERE TripNumber = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tripNumber);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
            	tripStopList.add(new TripStopInfo(
                        resultSet.getInt("TripNumber"),
                        resultSet.getInt("StopNumber"),
                        resultSet.getInt("SequenceNumber"),
                        resultSet.getString("DrivingTime")));
            }  
            table.setItems(tripStopList);
        } 
        catch (SQLException ex) { // Handle exception
            Logger.getLogger(DisplayStopsController.class.getName()).log(Level.SEVERE, null, ex);
        }                        
    }
    // Display trip schedule on the table
    private void loadTripStopInfo() {
        connection = DBConnect.getConnect(); // Connect the database       
        refreshTable();
        // Display data on the columns
        tripNumberCol.setCellValueFactory(new PropertyValueFactory<>("tripNumber"));
        stopNumberCol.setCellValueFactory(new PropertyValueFactory<>("stopNumber"));
        sequenceNumberCol.setCellValueFactory(new PropertyValueFactory<>("sequenceNumber"));
        drivingTimeCol.setCellValueFactory(new PropertyValueFactory<>("drivingTime"));
    }
	
	public void displayStopsAction(ActionEvent event) throws SQLException, IOException {
		tripNumber = tripNumberInput.getText();
		loadTripStopInfo();
	}
}
