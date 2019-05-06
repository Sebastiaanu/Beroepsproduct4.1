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
public class VrijwilligerVerwijderenView extends GridPane {
        public Text lblVrijwilligerVerwijderen;
        public Text lblSelectVrijwilliger;
        public ComboBox cBSelectVrijwilliger;
        public Button selectButton;
        
    public VrijwilligerVerwijderenView(Pane p) {
        lblVrijwilligerVerwijderen = new Text("Vrijwilliger verwijderen");
        lblVrijwilligerVerwijderen.setFont(Font.font("Verdana",20));
        lblSelectVrijwilliger = new Text("Selecteer vrijwilliger ");
        cBSelectVrijwilliger = new ComboBox();
        selectButton = new Button("Verwijder vrijwilliger");
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(lblVrijwilligerVerwijderen,0,0);
        add(lblSelectVrijwilliger,0,1);
        add(cBSelectVrijwilliger,0,2);
        add(selectButton,1,2);
        
        p.getChildren().addAll(this);
    
    }

    
    
}
