/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author jelmu
 */
public class CursistVerwijderenView extends GridPane {
        public Text lblSelectCursist;
        public ComboBox cBSelectCursist;
        public Button selectButton;
        
        public CursistVerwijderenView(Pane p){
            lblSelectCursist = new Text("Selecteer Cursist ");
            cBSelectCursist = new ComboBox();
            selectButton = new Button("Verwijder Cursist ");
        
            this.setPadding(new Insets(10,10,10,10));
            this.setVgap(10);
            
            add(lblSelectCursist,0,0);
            add(cBSelectCursist,0,1);
            add(selectButton,1,1);
            
            p.getChildren().addAll(this);
        }
        
       
}
