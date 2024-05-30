package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;

import java.io.IOException;

import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ItemController {
	private Media media;
	private Cart cart;
	private Store store;
	
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
    	this.cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
		try {
			final String PLAY_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/PlayMedia.fxml";
    		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PLAY_FXML_FILE_PATH));
    		fxmlLoader.setController(new PlayMediaController(store, cart, media));
    		Parent root = fxmlLoader.load();
    		Stage dialog = (Stage)((Node) event.getSource()).getScene().getWindow();
    		dialog.setScene(new Scene(root));
    		dialog.setTitle("Media playing");
    		dialog.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
    		
    	
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
    
    public ItemController(Store store, Cart cart) {
    	this.store = store;
    	this.cart = cart;
    }

}

