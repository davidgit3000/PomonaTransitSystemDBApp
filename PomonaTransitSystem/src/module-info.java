module PomonaTransitSystem {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.logging;
	
	opens pts to javafx.graphics, javafx.fxml;
}
