package pts.q2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pts.DBConnect;

public class ChangeBusController extends TripOfferingController {
	@FXML
	protected TextField busIdInput;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    
    private String tripNumber;
    private String date;
    private String scheduledStartTime;
    private String busId;
	
	public void changeBusAction(ActionEvent event) throws SQLException, IOException {
		tripNumber = tripNumberInput.getText();
		date = dateInput.getText();
		scheduledStartTime = scheduledStartTimeInput.getText();
		busId = busIdInput.getText();
		
		connection = DBConnect.getConnect();
		query = "UPDATE tripoffering\r\n"
				+ "SET BusID = ?\r\n"
				+ "WHERE TripNumber = ? AND Date = ? AND ScheduledStartTime = ?;\r\n";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, busId);
        preparedStatement.setString(2, tripNumber);
        preparedStatement.setString(3, date);
        preparedStatement.setString(4, scheduledStartTime);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        
        tripNumberInput.clear();
        dateInput.clear();
        scheduledStartTimeInput.clear();
        busIdInput.clear();
        loadTripOffering();
	}

}
