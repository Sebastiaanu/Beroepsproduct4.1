/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author jelmu
 */
public class CursistToevoegenView extends GridPane {
    Button button;
    
    
    public CursistToevoegenView(Pane p) {
        button = new Button();
        
        add(button,0,0);
        p.getChildren().addAll(this);
    }
    
}
