package pts.q5;

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
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;	
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Driver;
import pts.BackToHome;
import pts.DBConnect;
import pts.q3.DisplayStopsController;

public class AddDriverController implements Initializable {
	@FXML
	private TextField driverNameInput;
	@FXML
	private TextField driverPhoneNumberInput;
	
	@FXML
    private TableView<Driver> table;
    @FXML
    private TableColumn<Driver, String> driverNameCol;
    @FXML
    private TableColumn<Driver, String> drivePhoneNumberCol;
    
    ObservableList<Driver> driverList = FXCollections.observableArrayList();
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    
    private String driverName;
    private String driverPhoneNumber;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	loadDrivers();
    }
    
	@FXML
	public void backAction(ActionEvent event) throws SQLException, IOException {
		BackToHome home = new BackToHome();
		home.backToHome(event);
	}
	
	// Get the data from the database
    private void refreshTable() {
        try  {
        	System.out.println("");
        	driverList.clear();
        	
            query = "SELECT * FROM driver";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
            	driverList.add(new Driver(
                        resultSet.getString("DriverName"),
                        resultSet.getString("DriverTelephoneNumber")
               ));
            }  
            table.setItems(driverList);
        } 
        catch (SQLException ex) { // Handle exception
            Logger.getLogger(AddDriverController.class.getName()).log(Level.SEVERE, null, ex);
        }                        
    }
    // Display trip schedule on the table
    private void loadDrivers() {
        connection = DBConnect.getConnect(); // Connect the database       
        refreshTable();
        // Display data on the columns
        driverNameCol.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        drivePhoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("driverPhoneNumber"));
    }
	
	public void displayDriversAction(ActionEvent event) throws SQLException, IOException {
		driverName = driverNameInput.getText();
		driverPhoneNumber = driverPhoneNumberInput.getText();
		
		connection = DBConnect.getConnect();
		query = "INSERT INTO `lab4`.`driver` (`DriverName`, `DriverTelephoneNumber`) VALUES (?, ?);";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, driverName);
        preparedStatement.setString(2, driverPhoneNumber);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        
        loadDrivers();
	}
}
