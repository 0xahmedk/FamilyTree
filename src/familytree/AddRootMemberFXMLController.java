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
 * @author ideal
 */
public class AddRootMemberFXMLController extends CurrentData implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static FamilyMember rtMemb;
    public static void setRtMemb(FamilyMember rm){
        rtMemb = rm;
    }
    
    @FXML
    private AnchorPane add_root_pane;
    @FXML
    private Label add_root_member_label;

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
    private TextField postalcode_field;

    @FXML
    void addRootMember(ActionEvent event) {
        
        
        if(name_field.getText().equals("")){
            rtMemb.setName("N/A");
        }else rtMemb.setName(name_field.getText());
        

        if(surname_field.getText().equals("")){
            rtMemb.setSurname("N/A");           
        } else rtMemb.setSurname(surname_field.getText());
 

        if(gender_combo_box.getValue().equals("N/A") || gender_combo_box.getValue().equals(null)){
          rtMemb.setGender("N/A");  
        } else rtMemb.setGender(gender_combo_box.getValue());

            
        if(life_description_field.getText().equals("")){
            rtMemb.setLife_description("N/A");
        } else rtMemb.setLife_description(life_description_field.getText());

            
            
            
        if(streetno_field.getText().equals("")){
            rtMemb.setStreet_no("N/A");
        } else rtMemb.setStreet_no(streetno_field.getText());
            
        if(streetname_field.getText().equals("")){
            rtMemb.setStreet_name("N/A");
        } else rtMemb.setStreet_name(streetname_field.getText());
        
        if(city_field.getText().equals("")){
            rtMemb.setCity("N/A");
        } else rtMemb.setCity(city_field.getText());
        if(postalcode_field.getText().equals("")){
            rtMemb.setPostal_code("N/A");
        } else rtMemb.setPostal_code(postalcode_field.getText());
        
//        rootMember = new FamilyMember();
//        CurrentData.CurrentData();
        rtMemb.setFather(new FamilyMember("N/A"));
        rtMemb.setMother(new FamilyMember("N/A"));
        rtMemb.setSpouse(new FamilyMember("N/A"));
        rtMemb.getFather().setName("N/A");
        rtMemb.getMother().setName("N/A");
        rtMemb.getSpouse().setName("N/A");

        
        ViewDetailsFXMLController.setViewDetailsOf(rtMemb);
        FXMLDocumentController.setRtMemb(rtMemb);

        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ViewDetailsFXML.fxml"));
            add_root_pane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rtMemb = new FamilyMember("N/A");
          // For gender_field
        ArrayList<String> listOfSomething = new ArrayList<>();
        listOfSomething.add("MALE");
        listOfSomething.add("FEMALE");
        listOfSomething.add("N/A");
        
        ObservableList<String> oblist;
        oblist = FXCollections.observableArrayList(listOfSomething);
        gender_combo_box.setValue("MALE");
        gender_combo_box.setItems(oblist);
    }    
    
}
