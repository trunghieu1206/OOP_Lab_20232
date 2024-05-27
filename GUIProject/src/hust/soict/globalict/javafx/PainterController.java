package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    private int choice = 1;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	
    	// if user choose to draw
    	if(choice == 1) {

    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        	drawingAreaPane.getChildren().add(newCircle);
    	}
    	// if user choose to erase
    	else {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 16, Color.WHITE);
        	drawingAreaPane.getChildren().add(newCircle);
    	}
    }
    
	@FXML
	void chooseDraw(ActionEvent event) {
		this.choice = 1;
	}

	@FXML
	void chooseErase(ActionEvent event) {
		this.choice = 0;
	}
    
    
    

}



