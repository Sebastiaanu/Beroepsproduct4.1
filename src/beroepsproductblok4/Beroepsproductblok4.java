/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jelmu
 */
public class Beroepsproductblok4 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       Pane mainPane = new Pane();
       BeroepsProductMenuBar menuBar = new BeroepsProductMenuBar(mainPane);
       VBox root = new VBox(menuBar,mainPane);
       Scene scene = new Scene (root,1920,1000);
       
       
       new Mainmenu();
       
       primaryStage.setScene(scene);
       primaryStage.setTitle("Multiculturele taallessen");
       primaryStage.show();
    }
    
}
