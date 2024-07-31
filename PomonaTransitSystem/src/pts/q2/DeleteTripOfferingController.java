package pts.q2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import pts.DBConnect;

public class DeleteTripOfferingController extends TripOfferingController {
	String query = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	private String tripNumber;
	private String date;
	private String scheduledStartTime;

	public void deleteTripOfferingAction(ActionEvent event) throws SQLException, IOException {
		try {
			tripNumber = tripNumberInput.getText();
			date = dateInput.getText();
			scheduledStartTime = scheduledStartTimeInput.getText();

			connection = DBConnect.getConnect();
			query = "DELETE FROM `lab4`.`tripoffering`\r\n"
					+ "WHERE TripNumber = ? AND Date = ? AND ScheduledStartTime = ?;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, tripNumber);
			preparedStatement.setString(2, date);
			preparedStatement.setString(3, scheduledStartTime);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Remove Trip Offering");
	        alert.setHeaderText(null);
	        alert.setContentText("Trip offering removed successfully!");
	        alert.showAndWait();

			tripNumberInput.clear();
			dateInput.clear();
			scheduledStartTimeInput.clear();
			loadTripOffering();
		} catch (SQLException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Failed to remove trip offering");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
}
