package hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PlayMediaController {
	private Media media;
	private Cart cart;
	private Store store;

    @FXML
    private Label MediaTitle;

    @FXML
    private Label mediaContent;
    
    @FXML
    void doneButtonPressed(ActionEvent event) {
    	try {
    		final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
    		fxmlLoader.setController(new ViewStoreController(store, cart));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    }
    
    public PlayMediaController(Store store, Cart cart, Media media) {
    	this.store = store;
    	this.media = media;
    	this.cart = cart;
    }

    public void initialize() {
		MediaTitle.setText("Now on the Playing screen");
		
		if(media instanceof DigitalVideoDisc) {
			try {
				DigitalVideoDisc newMedia = (DigitalVideoDisc) media;
				mediaContent.setText(newMedia.play());
			}
			catch (Exception e){
				System.err.println("Cannot play, DVD contains non-positive length");
			}
		}
		else {
			try {
				CompactDisc newMedia = (CompactDisc) media;
				mediaContent.setText(newMedia.play());
			}
			catch (Exception e) {
				
			}
		}
	}
}

