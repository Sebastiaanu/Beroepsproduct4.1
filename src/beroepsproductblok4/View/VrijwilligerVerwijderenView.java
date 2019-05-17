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
public class VrijwilligerVerwijderenView extends GridPane {
        private Text lblVrijwilligerVerwijderen;
        private Text lblSelectVrijwilliger;
        private ComboBox cBSelectVrijwilliger;
        private Button selectButton;
        private DbConnector dbConnector;
        
    public VrijwilligerVerwijderenView(Pane p) {
        lblVrijwilligerVerwijderen = new Text("Vrijwilliger verwijderen");
        lblVrijwilligerVerwijderen.setFont(Font.font("Verdana",20));
        lblSelectVrijwilliger = new Text("Selecteer vrijwilliger ");
        cBSelectVrijwilliger = new ComboBox();
        selectButton = new Button("Verwijder vrijwilliger");
        
        dbConnector = new DbConnector();
        
        vulDeVrijwilligerCombo();
        
        selectButton.setOnAction(event->{
            try{
                verwijderVrijwilliger();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        });
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(lblVrijwilligerVerwijderen,0,0);
        add(lblSelectVrijwilliger,0,1);
        add(cBSelectVrijwilliger,0,2);
        add(selectButton,1,2);
        
        p.getChildren().addAll(this);
    
    }

    private void vulDeVrijwilligerCombo() {
        ResultSet result = null;
        try{
            String strSQL = "SELECT * FROM VRIJWILLIGER";
            result = dbConnector.getData(strSQL);
            while(result.next()){
                String vrijwilligerVoornaam = result.getString("Voornaam");
                String vrijwilligerAchternaam = result.getString("Achternaam");
                String vrijwilligerTussenvoegsel = result.getString("Tussenvoegsel");
                String vrijwilligerEmail = result.getString("Email");
                if(vrijwilligerTussenvoegsel == null){
                    cBSelectVrijwilliger.getItems().add(vrijwilligerVoornaam+ " " + vrijwilligerAchternaam +" " + vrijwilligerEmail);
                }else{
                    cBSelectVrijwilliger.getItems().add(vrijwilligerVoornaam+ " " + vrijwilligerAchternaam + " , "+ vrijwilligerTussenvoegsel + "  " + vrijwilligerEmail);
                }
                
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    private void verwijderVrijwilliger() {
        try{
            String cbContent = (cBSelectVrijwilliger.getValue().toString());
            String[] splitted = cbContent.split(" ");
            
            
            if(splitted[5]== null){
                String strSQLnoNull = "DELETE FROM Vrijwilliger WHERE Email = ('"+splitted[2]+"')";
            int result = dbConnector.executeDML(strSQLnoNull);
            }else{
            
                String strSQLnoNull = "DELETE FROM Vrijwilliger WHERE Email = ('"+splitted[5]+"')";
            int result = dbConnector.executeDML(strSQLnoNull);
            }
            
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    
    
}
