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
        
            vuldeCursistCombo();
            
            selectButton.setOnAction(event->{
            try{
                verwijderCursist();
            }catch(Exception e){
                
            }
            });
            
            this.setPadding(new Insets(10,10,10,10));
            this.setVgap(10);
            
            add(lblCursistVerwijderen,0,0);
            add(lblSelectCursist,0,1);
            add(cBSelectCursist,0,2);
            add(selectButton,1,2);
            
            p.getChildren().addAll(this);
        }

    private void vuldeCursistCombo() {
    ResultSet result = null;
        try{
            String strSQL ="select * from cursist";
            result = dbConnector.getData(strSQL);
            while(result.next()){
                String cursistVoornaam = result.getString("Voornaam");
                String cursistAchternaam = result.getString("Achternaam"); 
                String cursistTussenVoegsel = result.getString("Tussenvoegsel");
                cBSelectCursist.getItems().add(cursistVoornaam +" "+ cursistAchternaam + " , "+cursistTussenVoegsel );
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
    }

    private void verwijderCursist() {
        try{
            String cbContent = (cBSelectCursist.getValue().toString());
            String[] splitted = cbContent.split(" ");
            System.out.println(splitted[0]);
            System.out.println(splitted[1]);
            System.out.println(splitted[3]);
            
            String strSQL = "DELETE FROM Cursist WHERE VOORNAAM = ('"+splitted[0]+"') AND ACHTERNAAM = ('"+splitted[1]+"') AND TUSSENVOEGSEL ('"+splitted[3]+"')";
            int result = dbConnector.executeDML(strSQL);
            if(result == 1){
                
            }else{
                //Niet gelukt
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        
       
}
