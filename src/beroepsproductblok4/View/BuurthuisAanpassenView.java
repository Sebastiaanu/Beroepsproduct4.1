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
public class BuurthuisAanpassenView extends GridPane{
        public Text titelAanpassenView;
        public Text lblSelectName;
        public Text lblEditFirstName;
        public Text lblEditTussenvoegsel;
        public Text lblEditSureName;
        public Text lblEditCountryOfOrigin;
        
        public ComboBox cBSelectBuurthuis;
        public Button selectBuurthuis;     
    

    public BuurthuisAanpassenView(Pane p) {
        titelAanpassenView = new Text("Aanpassen Buurthuis");
        titelAanpassenView.setFont(Font.font("Verdana",20));
        
        lblSelectName = new Text("Selecteer naam van Buurthuis: ");
        lblEditFirstName = new Text("Aanpassen van naam");
        
                
        cBSelectBuurthuis = new ComboBox();
        selectBuurthuis = new Button("Zoek buurthuis");
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(titelAanpassenView,0,0);
        add(lblSelectName,0,1);
        add(cBSelectBuurthuis,1,1);
        add(selectBuurthuis,0,3);
        
        p.getChildren().addAll(this);
    }
    
}
