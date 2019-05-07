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
public class CursistVerwijderenView extends GridPane {
        public Text lblCursistVerwijderen;
        public Text lblSelectCursist;
        
        public ComboBox cBSelectCursist;
        public Button selectButton;
        
        private DbConnector dbConnector;
        
        public CursistVerwijderenView(Pane p){
            lblCursistVerwijderen = new Text("Cursist verwijderen");
            lblCursistVerwijderen.setFont(Font.font("Verdana",20));
            lblSelectCursist = new Text("Selecteer Cursist ");
            
            cBSelectCursist = new ComboBox();
            selectButton = new Button("Verwijder Cursist ");
            
            dbConnector = new DbConnector();
        
            vuldeVrijwilligerCombo();
            
            this.setPadding(new Insets(10,10,10,10));
            this.setVgap(10);
            
            add(lblCursistVerwijderen,0,0);
            add(lblSelectCursist,0,1);
            add(cBSelectCursist,0,2);
            add(selectButton,1,2);
            
            p.getChildren().addAll(this);
        }

    private void vuldeVrijwilligerCombo() {
    ResultSet result = null;
        try{
            String strSQL ="select * from cursist";
            result = dbConnector.getData(strSQL);
            while(result.next()){
                String cursistVoornaam = result.getString("Voornaam");
                cBSelectCursist.getItems().add(cursistVoornaam);
            }
        }catch(Exception e){
            System.out.println(e);
        }    
    }
        
       
}
