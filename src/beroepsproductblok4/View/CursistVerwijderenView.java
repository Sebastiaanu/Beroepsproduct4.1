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
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jelmu
 */
public class CursistVerwijderenView extends GridPane {
        public Text lblCursistVerwijderen;
        public Text lblSelectCursist;
        public ComboBox cBSelectCursist;
        public Button selectButton;
        
        public CursistVerwijderenView(Pane p){
            lblCursistVerwijderen = new Text("Cursist verwijderen");
            lblCursistVerwijderen.setFont(Font.font("Verdana",20));
            lblSelectCursist = new Text("Selecteer Cursist ");
            cBSelectCursist = new ComboBox();
            selectButton = new Button("Verwijder Cursist ");
        
            this.setPadding(new Insets(10,10,10,10));
            this.setVgap(10);
            
            add(lblCursistVerwijderen,0,0);
            add(lblSelectCursist,0,1);
            add(cBSelectCursist,0,2);
            add(selectButton,1,2);
            
            p.getChildren().addAll(this);
        }
        
       
}
