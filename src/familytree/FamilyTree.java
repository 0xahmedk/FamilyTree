/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import javafx.scene.control.Label;

/**
 *
 * @author ideal
 */
public class FamilyTree extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        

        Button show = new Button("Save");
        show.setTranslateY(40);
        show.setTranslateX(40);
        show.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent event) {
            FileHandling fh = new FileHandling();
            FileHandling.setRtMemb(FXMLDocumentController.getRtMemb());
            fh.writeIntoFile();
            System.exit(0);
          }
        });

        Button hide = new Button("Don't Save");
        hide.setTranslateY(40);
        hide.setTranslateX(150);
        hide.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent event) {
            System.exit(0);
          }
        });
        Label label = new Label("Do you want to save Changes?");
        label.setMaxWidth(Double.MAX_VALUE);
        label.setTranslateY(10);
        label.setTranslateX(10);
        
        AnchorPane layout = new AnchorPane();
        layout.setPrefSize(250, 80);
        
        layout.getChildren().addAll(label, show, hide);
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            Stage newStage = new Stage();
            @Override
            public void handle(WindowEvent event) {
                stage.setScene(new Scene(layout));
                event.consume();
            }

        });
        
        
        stage.setTitle("Family Tree");
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
