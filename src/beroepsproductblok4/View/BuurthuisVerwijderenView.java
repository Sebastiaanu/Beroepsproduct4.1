/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import beroepsproductblok4.Connector.DbConnector;
import java.sql.ResultSet;
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
    
    private DbConnector dbConnector;
    
    public BuurthuisVerwijderenView(Pane p) {
        lblBuurthuisVerwijderen = new Text("Verwijderen Buurthuis");
        lblBuurthuisVerwijderen.setFont(Font.font("Verdana",20));
        lblSelectBuurthuis = new Text("Selecteer Buurthuis ");
        cBSelectBuurthuis = new ComboBox();
        
        selectButton = new Button("Verwijder buurthuis");
        dbConnector = new DbConnector();
        
        
        
        vulDeBuurthuisCombo();
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(lblBuurthuisVerwijderen,0,0);
        add(lblSelectBuurthuis,0,1);
        add(cBSelectBuurthuis,0,2);
        add(selectButton,1,2);
        
       
        
        p.getChildren().addAll(this);
    }

    private void vulDeBuurthuisCombo() {
        ResultSet result = null;
        try{
            String strSQL ="SELECT * FROM Buurthuis";
            result = dbConnector.getData(strSQL);
            while(result.next()){
                String buurthuisNaam = result.getString("Naam");
                cBSelectBuurthuis.getItems().add(buurthuisNaam);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
   

    
    
}
