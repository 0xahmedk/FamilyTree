/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;

import java.io.File;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author ideal
 */
public class FXMLDocumentController extends CurrentData implements Initializable {
    
//    private FamilyMember rootMember = new FamilyMember();
    
    private static FamilyMember rtMemb;
    @FXML
    private TreeView tv = new TreeView();
    @FXML
    private Button loadFile;
    @FXML
    public AnchorPane rootPane;
    @FXML
    private Label tv_label;
    @FXML
    private Label home_screen_label;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        rtMember = rtMemb
//        initializeData();
        
//        treeViewInitializer();
        
    }  
    private void handleMouseClicked(MouseEvent event) {
        Node node = event.getPickResult().getIntersectedNode();
        // Accept clicks only on node cells, and not on empty spaces of the TreeView
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = (String) ((TreeItem)tv.getSelectionModel().getSelectedItem()).getValue();
            if(name.equals(rtMemb.getName())){
                ViewDetailsFXMLController.setViewDetailsOf(rtMemb);
            }else if(name.equals(rtMemb.getFather().getName())){
                ViewDetailsFXMLController.setViewDetailsOf(rtMemb.getFather());
            }else if(name.equals(rtMemb.getMother().getName())){
                ViewDetailsFXMLController.setViewDetailsOf(rtMemb.getMother());
            }else if(name.equals(rtMemb.getSpouse().getName())){
                ViewDetailsFXMLController.setViewDetailsOf(rtMemb.getSpouse());
            }else{
                ArrayList<FamilyMember> childs =  rtMemb.getChildren();
                for(FamilyMember temp: childs){
                    if(name.equals(temp.getName())){
                    ViewDetailsFXMLController.setViewDetailsOf(temp);
                }
            }
                
            }
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("ViewDetailsFXML.fxml"));
                rootPane.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    public void treeViewInitializer(){
        if(rtMemb != null){
            tv_label.setVisible(false);
            EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
                handleMouseClicked(event);
            };

            tv.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);

            TreeItem<String> root = new TreeItem<>(rtMemb.getName());
            root.setExpanded(true);
            TreeItem<String> parents = new TreeItem<>("Parents");
            parents.setExpanded(true);
            TreeItem<String> spouse = new TreeItem<>("Spouse");
            spouse.setExpanded(true);
            TreeItem<String> children = new TreeItem<>("Children");
            children.setExpanded(true);

            root.getChildren().addAll(parents, spouse, children);
            if(rtMemb.getFather() != null) parents.getChildren().add(new TreeItem<>(rtMemb.getFather().getName()));
            if(rtMemb.getMother() != null) parents.getChildren().add(new TreeItem<>(rtMemb.getMother().getName()));
            if(rtMemb.getSpouse() != null) spouse.getChildren().add(new TreeItem<>(rtMemb.getSpouse().getName()));
            if(rtMemb.getChildren() != null){
                ArrayList<FamilyMember> chld =  rtMemb.getChildren();
                for(FamilyMember temp: chld){
                    children.getChildren().add(new TreeItem<>(temp.getName()));
                }
            }

            tv.setRoot(root);
        }
       
    }
    
    @FXML
    void chooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("TXT File", "*.txt"));
        File f = fileChooser.showOpenDialog(null);
        
        if(f!=null){
            loadFile.setText(f.getAbsolutePath());
            FileHandling myFile = new FileHandling();
            rtMemb = myFile.readFromFile(f.getAbsolutePath());
//            setRootMember(myFile.readFromFile(f.getAbsolutePath()));
//            loadFile.setText(f.getAbsolutePath().substring(f.getAbsolutePath().length()-rtMemb.getName().length()+8, f.getAbsolutePath().length()-1));
            treeViewInitializer();
            JOptionPane.showMessageDialog(null, "FamilyTree Loaded Successfully! ");
//            JOptionPane.showMessage Dialog(null, "Saving Failed!\nNo tree Data Found to save"); 
        }
        
    }
    public static void setRtMemb(FamilyMember rm){
        rtMemb = rm;
    }
     public static FamilyMember getRtMemb() {
        return rtMemb;
    }
    @FXML
    void refreshTree(ActionEvent event){
        treeViewInitializer();
    }
    @FXML
    void addRootMember(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("AddRootMemberFXML.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void saveTree(ActionEvent event) {
        
        if(rtMemb != null){
            FileHandling.setRtMemb(ViewDetailsFXMLController.getViewDetailsOf());
            FileHandling myFile = new FileHandling();
            myFile.writeIntoFile();
            JOptionPane.showMessageDialog(null, "FamilyTree Successfully saved!");
        }else{
            JOptionPane.showMessageDialog(null, "Saving Failed!\nNo tree Data Found to save"); 
        }
        
    }
    
}
