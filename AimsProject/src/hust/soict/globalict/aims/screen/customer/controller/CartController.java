package hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;
import java.util.ArrayList;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class CartController {
	private Cart cart;
	private Store store;
	
    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnRemove;
    
    @FXML
    private Button btnPlay;
    
    @FXML
    private Label placeOrderMessage;
    
    @FXML
    private Label removeMessage;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private RadioButton radioBtnFilterId;
    
    @FXML
    private RadioButton radioBtnFilterTitle;


    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    @FXML
    void filter(ActionEvent event) {
    	
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	try {
			final String PLAY_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/PlayMedia.fxml";
    		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PLAY_FXML_FILE_PATH));
    		fxmlLoader.setController(new PlayMediaController(store, cart, media));
    		Parent root = fxmlLoader.load();
    		Stage dialog = (Stage)((Node) event.getSource()).getScene().getWindow();
    		dialog.setScene(new Scene(root));
    		dialog.setTitle("Media playing");
    		dialog.show();
    		
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void btnRefreshPressed(ActionEvent event) {
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    		fxmlLoader.setController(new CartController(store, cart));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Cart");
    		stage.show();
 
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    }


    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	removeMessage.setText("You have successfully removed " + media.getTitle() + " from Cart, please refreash!");
    	removeMessage.setVisible(true);
    }
    
    
    
    @FXML
    void placeOrderPressed(ActionEvent event) {
    	cart.clearCart();
    	placeOrderMessage.setText("You have successfully ordered, please refresh the page!");
    	placeOrderMessage.setVisible(true);
    	
    }
    
    public CartController(Store store, Cart cart) {
    	this.store = store;
		this.cart = cart;
	}
    
	
	public void initialize() {
		colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
		
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		
		if(cart.getItemsOrdered() != null) {
			ObservableList<Media> oListMedia = FXCollections.observableArrayList(cart.getItemsOrdered());
			tblMedia.setItems(oListMedia);
		}
		
		btnPlay.setVisible(true);
		btnRemove.setVisible(true);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}
		});
		
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
				
			}
		});
		
		placeOrderMessage.setVisible(false);
		costLabel.setText(this.cart.totalCost()+ " $");
		removeMessage.setVisible(false);
	}
	
	void updateButtonBar(Media media) {
		if(media == null) {
			btnPlay.setVisible(true);
			btnRemove.setVisible(false);
			
		}
		else {
			btnRemove.setVisible(true);
			if(media instanceof Playable) {
				btnPlay.setVisible(true);
			}
			else {
				btnPlay.setVisible(false);
			}
		}
	}
	
	void showFilteredMedia(String media) {
		
	}
	
	@FXML
    void btnViewStorePressed(ActionEvent event) {
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
}