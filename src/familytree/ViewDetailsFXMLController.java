/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
public class ViewDetailsFXMLController extends CurrentData implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static FamilyMember viewDetailsOf;

    public static FamilyMember getViewDetailsOf() {
        return viewDetailsOf;
    }

    public static void setViewDetailsOf(FamilyMember viewDetails) {
        viewDetailsOf = viewDetails;
    }
    @FXML
    private AnchorPane view_pane;
    @FXML
    private Label name_label;

    @FXML
    private Label surname_label;

    @FXML
    private Label gender_label;

    @FXML
    private Label description_label;

    @FXML
    private Label address_label;

    @FXML
    private Label father_label;

    @FXML
    private Label mother_label;

    @FXML
    private Label spouse_label;

    @FXML
    private Label children_label;

    @FXML
    private Label grand_children_label;

    @FXML
    void addRelative(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("AddRelativeFXML.fxml"));
            view_pane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void editDetails(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("EditDetailsFXML.fxml"));
            view_pane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        FXMLDocumentController.setRtMemb(viewDetailsOf);
        
        name_label.setText(viewDetailsOf.getName());
        surname_label.setText(viewDetailsOf.getSurname());
        gender_label.setText(viewDetailsOf.getGender());
        description_label.setText(viewDetailsOf.getLife_description());
        
        address_label.setText("Street#"+viewDetailsOf.getStreet_no()+", "+
                viewDetailsOf.getStreet_name()+", "+viewDetailsOf.getCity()+
                ", [Postal Code:"+viewDetailsOf.getPostal_code()+"]");
        
        father_label.setText(viewDetailsOf.getFather().getName());
        mother_label.setText(viewDetailsOf.getMother().getName());
        spouse_label.setText(viewDetailsOf.getSpouse().getName());
        
        if(viewDetailsOf.getChildren() != null){
            String tempStr = new String("");
            ArrayList<FamilyMember> chld =  viewDetailsOf.getChildren();
            for(FamilyMember temp: chld){
                tempStr = tempStr.concat(temp.getName()+", ");
            }
            if(tempStr.length() > 3){
                children_label.setText(tempStr.substring(0, tempStr.length()-2)+".");
            }else{
                children_label.setText(tempStr);
            }
        }
        
        grand_children_label.setText("");
        
    }    
    
}
