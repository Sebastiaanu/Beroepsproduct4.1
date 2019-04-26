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
public class VrijwilligerVerwijderenView extends GridPane {
        public Text lblSelectVrijwilliger;
        public ComboBox cBSelectVrijwilliger;
        public Button selectButton;
        
    public VrijwilligerVerwijderenView(Pane p) {
        lblSelectVrijwilliger = new Text("Selecteer vrijwilliger ");
        cBSelectVrijwilliger = new ComboBox();
        selectButton = new Button("Verwijder vrijwilliger");
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(lblSelectVrijwilliger,0,0);
        add(cBSelectVrijwilliger,0,1);
        add(selectButton,1,1);
        
        p.getChildren().addAll(this);
    
    }

    
    
}
