/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author YourName
 */
public class AddRelativeFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane add_relative_pane;
    @FXML
    private Label add_relative;

    @FXML
    private TextField name_field;

    @FXML
    private TextField surname_field;

    @FXML
    private TextField life_description_field;

    @FXML
    private ComboBox<String> gender_combo;

    @FXML
    private TextField streetno_field;

    @FXML
    private TextField streetname_field;

    @FXML
    private TextField city_field;

    @FXML
    private TextField postalcode_field;

    @FXML
    private ComboBox<String> relative_type_combo;
    
    //Event Handler for Add Relative button
    @FXML
    void addRelative(ActionEvent event) {
        //Checking condition
        if("Father".equals(relative_type_combo.getValue())){
            if(!"MALE".equals(gender_combo.getValue())){
                JOptionPane.showMessageDialog(null, "Father can only be MALE!\nRenter the Gender");
                return;
            }
        }
        if("Mother".equals(relative_type_combo.getValue())){
            if(!"FEMALE".equals(gender_combo.getValue())){
                JOptionPane.showMessageDialog(null, "Mother can only be FEMALE!\nRenter the Gender");
                return;
            }
        }
        

        //Adding data to relevant objects/variable
        if(relative_type_combo.getValue().equals("Father")){
            if(name_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getFather().setName("N/A");
            }else ViewDetailsFXMLController.getViewDetailsOf().getFather().setName(name_field.getText());

            if(surname_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getFather().setSurname("N/A");           
            } else ViewDetailsFXMLController.getViewDetailsOf().getFather().setSurname(surname_field.getText());

            if(gender_combo.getValue().equals("N/A") || gender_combo.getValue() == null){
              ViewDetailsFXMLController.getViewDetailsOf().getFather().setGender("N/A");  
            } else ViewDetailsFXMLController.getViewDetailsOf().getFather().setGender(gender_combo.getValue());


            if(life_description_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getFather().setLife_description("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getFather().setLife_description(life_description_field.getText());




            if(streetno_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getFather().setStreet_no("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getFather().setStreet_no(streetno_field.getText());

            if(streetname_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getFather().setStreet_name("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getFather().setStreet_name(streetname_field.getText());

            if(city_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getFather().setCity("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().setCity(city_field.getText());
            if(postalcode_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getFather().setPostal_code("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().setPostal_code(postalcode_field.getText());
            
        }else if(relative_type_combo.getValue().equals("Mother")){
            if(name_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getMother().setName("N/A");
            }else ViewDetailsFXMLController.getViewDetailsOf().getMother().setName(name_field.getText());

            if(surname_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getMother().setSurname("N/A");           
            } else ViewDetailsFXMLController.getViewDetailsOf().getMother().setSurname(surname_field.getText());


            if(gender_combo.getValue().equals("N/A") || gender_combo.getValue() == null){
              ViewDetailsFXMLController.getViewDetailsOf().getMother().setGender("N/A");  
            } else ViewDetailsFXMLController.getViewDetailsOf().getMother().setGender(gender_combo.getValue());


            if(life_description_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getMother().setLife_description("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getMother().setLife_description(life_description_field.getText());




            if(streetno_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getMother().setStreet_no("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getMother().setStreet_no(streetno_field.getText());

            if(streetname_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().setStreet_name("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getMother().setStreet_name(streetname_field.getText());

            if(city_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getMother().setCity("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getMother().setCity(city_field.getText());
            if(postalcode_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getMother().setPostal_code("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getMother().setPostal_code(postalcode_field.getText());
        }else if(relative_type_combo.getValue().equals("Spouse")){
            if(name_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setName("N/A");
            }else ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setName(name_field.getText());

            if(surname_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setSurname("N/A");           
            } else ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setSurname(surname_field.getText());


            if(gender_combo.getValue().equals("N/A") || gender_combo.getValue() == null){
              ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setGender("N/A");  
            } else ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setGender(gender_combo.getValue());


            if(life_description_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setLife_description("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setLife_description(life_description_field.getText());




            if(streetno_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setStreet_no("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setStreet_no(streetno_field.getText());

            if(streetname_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setStreet_name("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setStreet_name(streetname_field.getText());

            if(city_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setCity("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setCity(city_field.getText());
            if(postalcode_field.getText().equals("")){
                ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setPostal_code("N/A");
            } else ViewDetailsFXMLController.getViewDetailsOf().getSpouse().setPostal_code(postalcode_field.getText());
        }else if(relative_type_combo.getValue().equals("Child")){
            FamilyMember temp = new FamilyMember();
            
            if(name_field.getText().equals("")){
                temp.setName("N/A");
            }else temp.setName(name_field.getText());

            if(surname_field.getText().equals("")){
                temp.setSurname("N/A");           
            } else temp.setSurname(surname_field.getText());


            if(gender_combo.getValue().equals("N/A") || gender_combo.getValue() == null){
              temp.setGender("N/A");  
            } else temp.setGender(gender_combo.getValue());


            if(life_description_field.getText().equals("")){
                temp.setLife_description("N/A");
            } else temp.setLife_description(life_description_field.getText());




            if(streetno_field.getText().equals("")){
                temp.setStreet_no("N/A");
            } else temp.setStreet_no(streetno_field.getText());

            if(streetname_field.getText().equals("")){
                temp.setStreet_name("N/A");
            } else temp.setStreet_name(streetname_field.getText());

            if(city_field.getText().equals("")){
                temp.setCity("N/A");
            } else temp.setCity(city_field.getText());
            if(postalcode_field.getText().equals("")){
                temp.setPostal_code("N/A");
            } else temp.setPostal_code(postalcode_field.getText());
            
            ViewDetailsFXMLController.getViewDetailsOf().addChild(temp);
            
        }
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ViewDetailsFXML.fxml"));
            add_relative_pane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void cancel(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ViewDetailsFXML.fxml"));
            add_relative_pane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        add_relative.setText("AddRelative to "+ViewDetailsFXMLController.getViewDetailsOf().getName());
        // For add_relative_field
        ArrayList<String> listOfSomething = new ArrayList<>();
        listOfSomething.add("Father");
        listOfSomething.add("Mother");
        listOfSomething.add("Spouse");
        listOfSomething.add("Child");
        
        ObservableList<String> oblist;
        oblist = FXCollections.observableArrayList(listOfSomething);
        relative_type_combo.setValue("Father");
        relative_type_combo.setItems(oblist);
        
        
        // For gender_field
        listOfSomething.clear();
        listOfSomething.add("MALE");
        listOfSomething.add("FEMALE");
        listOfSomething.add("N/A");
        
        oblist = FXCollections.observableArrayList(listOfSomething);
        gender_combo.setValue("MALE");
        gender_combo.setItems(oblist);
        
    }    
    
}
