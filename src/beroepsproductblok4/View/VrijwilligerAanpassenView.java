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
public class VrijwilligerAanpassenView extends GridPane {
    public Text lblVrijwilligerAanpassen;
    

 public VrijwilligerAanpassenView(Pane p){
    lblVrijwilligerAanpassen = new Text("Vrijwilliger aanpassen");
    lblVrijwilligerAanpassen.setFont(Font.font("Verdana",20));
        
    this.setPadding(new Insets(10,10,10,10));
    this.setVgap(10);
        
         add(lblVrijwilligerAanpassen,0,0);
         
         p.getChildren().addAll(this);
 }

    
}    

