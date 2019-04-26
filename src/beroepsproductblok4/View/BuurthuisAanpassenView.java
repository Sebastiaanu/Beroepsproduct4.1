/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import javafx.geometry.Insets;
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
        
    

    public BuurthuisAanpassenView(Pane p) {
        titelAanpassenView = new Text("Aanpassen Buurthuis");
        titelAanpassenView.setFont(Font.font("Verdana",20));
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(titelAanpassenView,0,0);
        
        p.getChildren().addAll(this);
    }
    
}
