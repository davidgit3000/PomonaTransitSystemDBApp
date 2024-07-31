package pts;
	
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import pts.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws SQLException, IOException{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root);
			scene.setFill(Color.TRANSPARENT);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Home");
			primaryStage.show();
		} catch(IOException ex) {
			 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
