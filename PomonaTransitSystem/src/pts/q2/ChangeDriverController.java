package pts.q2;

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
import model.TripDisplay;
import pts.BackToHome;
import pts.DBConnect;
import pts.q6.AddBusController;

public class ChangeDriverController extends TripOfferingController {
	@FXML
	protected TextField driverNameInput;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    
    private String tripNumber;
    private String date;
    private String scheduledStartTime;
    private String driverName;
	
	public void changeDriverAction(ActionEvent event) throws SQLException, IOException {
		tripNumber = tripNumberInput.getText();
		date = dateInput.getText();
		scheduledStartTime = scheduledStartTimeInput.getText();
		driverName = driverNameInput.getText();
		
		connection = DBConnect.getConnect();
		query = "UPDATE tripoffering\r\n"
				+ "SET DriverName = ?\r\n"
				+ "WHERE TripNumber = ? AND Date = ? AND ScheduledStartTime = ?;\r\n";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, driverName);
        preparedStatement.setString(2, tripNumber);
        preparedStatement.setString(3, date);
        preparedStatement.setString(4, scheduledStartTime);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        
        tripNumberInput.clear();
        dateInput.clear();
        scheduledStartTimeInput.clear();
        driverNameInput.clear();
        loadTripOffering();
	}
}
