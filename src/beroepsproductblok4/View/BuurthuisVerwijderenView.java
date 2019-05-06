/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import javafx.collections.ObservableList;
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
public class BuurthuisVerwijderenView extends GridPane{
    public Text lblBuurthuisVerwijderen;
    public Text lblSelectBuurthuis;
    public ComboBox cBSelectBuurthuis;
    public Button selectButton;
    
    public BuurthuisVerwijderenView(Pane p) {
        lblBuurthuisVerwijderen = new Text("Verwijderen Buurthuis");
        lblBuurthuisVerwijderen.setFont(Font.font("Verdana",20));
        lblSelectBuurthuis = new Text("Selecteer Buurthuis ");
        cBSelectBuurthuis = new ComboBox();
        selectButton = new Button("Verwijder buurthuis");
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(lblBuurthuisVerwijderen,0,0);
        add(lblSelectBuurthuis,0,1);
        add(cBSelectBuurthuis,0,2);
        add(selectButton,1,2);
        
        p.getChildren().addAll(this);
    }

   

    
    
}
