/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import beroepsproductblok4.Connector.DbConnector;
import beroepsproductblok4.Model.Vrijwilliger;
import java.sql.ResultSet;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jelmu
 */
public class VrijwilligerAanpassenView extends GridPane {
      private Text lblCursistAanpassen;
    private Text lblSelectName;
    private Text lblFirstName;
    private Text lblTussenvoegsel;
    private Text lblSureName;
    private Text lblPhonenr;
    private Text lblPlaceOfLiving;
    
    private Text lblDatabaseError;
            
    private TextField txtFirstName;
    private TextField txtTussenvoegsel;
    private TextField txtSureName;
    private TextField txtPhonenr;
    private TextField txtPlaceOfLiving;
    
    private ComboBox cBSelectCursist;
    private Button selectVrijwilliger;
    private Button editVrijwilliger;
    private DbConnector dbConnector;
    private Text filler;
    
    private String vrijwilligerEmail;
        
    public VrijwilligerAanpassenView(Pane p) {
        lblCursistAanpassen = new Text("Vrijwilliger aanpassen");
        lblCursistAanpassen.setFont(Font.font("Verdana",20));
        
        lblSelectName = new Text("Selecteer naam van vrijwilliger: ");
        lblFirstName = new Text("Voornaam vrijwilliger: ");
        lblTussenvoegsel = new Text("Tussenvoegsel vrijwilliger: ");
        lblSureName = new Text("Achternaam vrijwilliger: ");
        lblPhonenr = new Text("Telefoonnummer vrijwilliger: ");
        lblPlaceOfLiving = new Text("Huidige woonplaats: ");
        
        txtFirstName = new TextField();
        txtTussenvoegsel = new TextField();
        txtSureName = new TextField();
        txtPhonenr = new TextField();
        txtPlaceOfLiving = new TextField();
        
        cBSelectCursist = new ComboBox();
        selectVrijwilliger = new Button("Zoek cursist");
        editVrijwilliger = new Button("Aanpassen");
        dbConnector = new DbConnector();
        filler = new Text(" ");
           
        vulDeCursistCombo();
        
        selectVrijwilliger.setOnAction(event->{
            vulDeTextFields();
        });
        
        editVrijwilliger.setOnAction(event->{
            editNaarDatabase();
        });
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(lblCursistAanpassen,0,0);
        add(lblSelectName,0,1);
        add(cBSelectCursist,1,1);
        add(selectVrijwilliger,1,3);
        add(editVrijwilliger,1,12);
        add(filler,1,4);
        
        add(lblFirstName,0,5);
        add(lblTussenvoegsel,0,6);
        add(lblSureName,0,7);
        add(lblPhonenr,0,8);
        add(lblPlaceOfLiving,0,9);
        
        add(txtFirstName,1,5);
        add(txtTussenvoegsel,1,6);
        add(txtSureName,1,7);
        add(txtPhonenr,1,8);
        add(txtPlaceOfLiving,1,9);
        
        
        p.getChildren().addAll(this);
    }
    
    private void vulDeCursistCombo() {
        ResultSet result = null;
        try {
            String strSQL = "SELECT * FROM Vrijwilliger";
            result = dbConnector.getData(strSQL);
            while (result.next()) {
                String cursistVoornaam = result.getString("Voornaam");
                String cursistAchternaam = result.getString("Achternaam");
                String cursistTussenVoegsel = result.getString("Tussenvoegsel");
                cBSelectCursist.getItems().add(cursistVoornaam + " " +cursistAchternaam);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void vulDeTextFields() {
        ResultSet result = null;
        String text = cBSelectCursist.getValue().toString();
        String[] splitted = text.split(" ");
        Vrijwilliger vrijwilliger = new Vrijwilliger();
        
        try{
           String strSQL = "SELECT * FROM Vrijwilliger WHERE Voornaam = ('"+splitted[0]+"') AND Achternaam = ('"+splitted[1]+"')";
           result = dbConnector.getData(strSQL);
           while (result.next()){
           vrijwilliger.setEmail(result.getString("Email"));
           vrijwilligerEmail = (vrijwilliger.getEmail());
           vrijwilliger.setFirstName(result.getString("Voornaam"));
           vrijwilliger.setTussenvoegsel(result.getString("Tussenvoegsel"));
           vrijwilliger.setSureName(result.getString("Achternaam"));
           vrijwilliger.setEmail(result.getString("Email"));
           vrijwilliger.setPhoneNumber(result.getString("Telnr"));
           vrijwilliger.setPlaceOfLiving(result.getString("Woonplaats"));
           
           txtFirstName.setText(vrijwilliger.getFirstName());
           txtTussenvoegsel.setText(vrijwilliger.getTussenvoegsel());
           txtSureName.setText(vrijwilliger.getSureName());
           txtPhonenr.setText(vrijwilliger.getPhoneNumber());
           txtPlaceOfLiving.setText(vrijwilliger.getPlaceOfLiving());
           }
           
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void editNaarDatabase(){
        try{
            String strSQL = "UPDATE Vrijwilliger SET VOORNAAM = ('"+txtFirstName.getText()+"'), TUSSENVOEGSEL = ('"+txtTussenvoegsel.getText()+"'), ACHTERNAAM = ('"+txtSureName.getText()+"'),  TELNR = ('"+txtPhonenr.getText()+"'), WOONPLAATS = ('"+txtPlaceOfLiving.getText()+"') WHERE EMAIL = ('"+vrijwilligerEmail+"') ";
            int result = dbConnector.executeDML(strSQL);
            if(result ==1){
                txtFirstName.clear();
                txtTussenvoegsel.clear();
                txtSureName.clear();
                txtPhonenr.clear();
                txtPlaceOfLiving.clear();
            }else{
                System.out.println("Hallo?");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
