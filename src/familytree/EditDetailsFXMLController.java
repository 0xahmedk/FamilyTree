/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ideal
 */
public class EditDetailsFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane edit_pane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        edit_details_title.setText("EditDetails of "+ViewDetailsFXMLController.getViewDetailsOf().getName());
        String tempStr;
        
        // For name_field
        tempStr = ViewDetailsFXMLController.getViewDetailsOf().getName();
        if(tempStr.equals("N/A")){
            name_field.setText("");
        }else name_field.setText(tempStr);
        
        // For surname_field
        tempStr = ViewDetailsFXMLController.getViewDetailsOf().getSurname();
        if(tempStr.equals("N/A")){
            surname_field.setText("");
        }else surname_field.setText(tempStr);
        
        // For gender_field
        ArrayList<String> listOfSomething = new ArrayList<>();
        listOfSomething.add("MALE");
        listOfSomething.add("FEMALE");
        listOfSomething.add("N/A");
        
        ObservableList<String> oblist;
        oblist = FXCollections.observableArrayList(listOfSomething);
        gender_combo_box.setValue("MALE");
        gender_combo_box.setItems(oblist);
        
        
        // For life_description_field
        tempStr = ViewDetailsFXMLController.getViewDetailsOf().getLife_description();
        if(tempStr.equals("N/A")){
            life_description_field.setText("");
        }else life_description_field.setText(tempStr); 
        
        // For street_no_field
        tempStr = ViewDetailsFXMLController.getViewDetailsOf().getStreet_no();
        if(tempStr.equals("N/A")){
            streetno_field.setText("");
        }else streetno_field.setText(tempStr);
        
        // For street_name_field
        tempStr = ViewDetailsFXMLController.getViewDetailsOf().getStreet_name();
        if(tempStr.equals("N/A")){
            streetname_field.setText("");
        }else streetname_field.setText(tempStr);
        
        // For city_field
        tempStr = ViewDetailsFXMLController.getViewDetailsOf().getCity();
        if(tempStr.equals("N/A")){
            city_field.setText("");
        }else city_field.setText(tempStr);
        
        // For postal_code_field
        tempStr = ViewDetailsFXMLController.getViewDetailsOf().getPostal_code();
        if(tempStr.equals("N/A")){
            postal_code_field.setText("");
        }else postal_code_field.setText(tempStr);
    }    
    @FXML
    private Label edit_details_title;

    @FXML
    private TextField name_field;

    @FXML
    private TextField surname_field;

    @FXML
    private TextField life_description_field;

    @FXML
    private ComboBox<String> gender_combo_box;

    @FXML
    private TextField streetno_field;

    @FXML
    private TextField streetname_field;

    @FXML
    private TextField city_field;

    @FXML
    private TextField postal_code_field;

    @FXML
    private Button save_details;

    @FXML
    void cancelEditing(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ViewDetailsFXML.fxml"));
            edit_pane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void saveDetails(ActionEvent event) {
        if(name_field.getText().equals("")){
            ViewDetailsFXMLController.getViewDetailsOf().setName("N/A");
        }else ViewDetailsFXMLController.getViewDetailsOf().setName(name_field.getText());

        if(surname_field.getText().equals("")){
            ViewDetailsFXMLController.getViewDetailsOf().setSurname("N/A");           
        } else ViewDetailsFXMLController.getViewDetailsOf().setSurname(surname_field.getText());
 

        if(gender_combo_box.getValue().equals("N/A") || gender_combo_box.getValue().equals(null)){
          ViewDetailsFXMLController.getViewDetailsOf().setGender("N/A");  
        } else ViewDetailsFXMLController.getViewDetailsOf().setGender(gender_combo_box.getValue());

            
        if(life_description_field.getText().equals("")){
            ViewDetailsFXMLController.getViewDetailsOf().setLife_description("N/A");
        } else ViewDetailsFXMLController.getViewDetailsOf().setLife_description(life_description_field.getText());

            
            
            
        if(streetno_field.getText().equals("")){
            ViewDetailsFXMLController.getViewDetailsOf().setStreet_no("N/A");
        } else ViewDetailsFXMLController.getViewDetailsOf().setStreet_no(streetno_field.getText());
            
        if(streetname_field.getText().equals("")){
            ViewDetailsFXMLController.getViewDetailsOf().setStreet_name("N/A");
        } else ViewDetailsFXMLController.getViewDetailsOf().setStreet_name(streetname_field.getText());
        
        if(city_field.getText().equals("")){
            ViewDetailsFXMLController.getViewDetailsOf().setCity("N/A");
        } else ViewDetailsFXMLController.getViewDetailsOf().setCity(city_field.getText());
        if(postal_code_field.getText().equals("")){
            ViewDetailsFXMLController.getViewDetailsOf().setPostal_code("N/A");
        } else ViewDetailsFXMLController.getViewDetailsOf().setPostal_code(postal_code_field.getText());
        
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ViewDetailsFXML.fxml"));
            edit_pane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
