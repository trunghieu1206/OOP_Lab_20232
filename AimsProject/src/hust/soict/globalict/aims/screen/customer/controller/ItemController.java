package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	private Media media;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;
    
    @FXML
    private Label lblType;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {

    }

    @FXML
    void btnPlayClicked(ActionEvent event) {

    }
    
    public void setData(Media media) {
    	this.media = media;
    	if(media instanceof DigitalVideoDisc) {
    		lblType.setText("(DVD)");
    	}
    	else if(media instanceof CompactDisc) {
    		lblType.setText("(CD)");
    	}
    	else{
    		lblType.setText("(Book)");
    	}
    	lblTitle.setText(media.getTitle());
    	lblCost.setText("$ " + media.getCost());
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 100));
    	}
    }
    
    public ItemController(Cart cart) {
    	
    }

}

