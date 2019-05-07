/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import beroepsproductblok4.Connector.DbConnector;
import beroepsproductblok4.Model.Vrijwilliger;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jelmu
 */
public class VrijwilligerToevoegenView extends GridPane{
    public Text lblVrijwilligerToevoegen;
    public Text lblFirstName;
    public Text lblTussenvoegsel;
    public Text lblSureName;
    public Text lblEmail;
    public Text lblPhonenr;
    public Text lblPlaceOfLiving;
    
    public Text lblDatabaseError;
            
    public TextField txtFirstName;
    public TextField txtTussenvoegsel;
    public TextField txtSureName;
    public TextField txtEmail;
    public TextField txtPhonenr;
    public TextField txtPlaceOfLiving;
    
    public Button addPerson;
    
    public VrijwilligerToevoegenView(Pane p) {
    lblVrijwilligerToevoegen = new Text("Vrijwilliger toevoegen");
    lblVrijwilligerToevoegen.setFont(Font.font("Verdana",20));
    lblFirstName = new Text("Voornaam vrijwilliger: ");
    lblTussenvoegsel = new Text ("Tussenvoegsel vrijwilliger: ");
    lblSureName = new Text("Achternaam vrijwilliger: ");
    lblEmail = new Text("Email vrijwilliger: ");
    lblPhonenr = new Text("Telefoonnummer vrijwilliger: ");
    lblPlaceOfLiving = new Text("Huidige woonplaats vrijwilliger: ");
    
    lblDatabaseError = new Text("Foutmelding database");
    lblDatabaseError.setVisible(false);
    
    txtFirstName = new TextField();
    txtTussenvoegsel = new TextField();
    txtSureName = new TextField();
    txtEmail = new TextField();
    txtPhonenr = new TextField();
    txtPlaceOfLiving = new TextField();
    
    addPerson = new Button("Vrijwilliger toevoegen");
    
    addPerson.setOnAction(event->{
        try{
        vrijwilligerToevoegen();
        }catch(Exception e){
        lblDatabaseError.setText("Foutmelding" + e);
        lblDatabaseError.setVisible(true);
        }
    });
    this.setPadding(new Insets(10,10,10,10));
    this.setVgap(10);
    
    add(lblVrijwilligerToevoegen,0,0);
    add(lblFirstName,0,1);
    add(lblTussenvoegsel,0,2);
    add(lblSureName,0,3);
    add(lblEmail,0,4);
    add(lblPhonenr,0,5);
    add(lblPlaceOfLiving,0,6);
    add(lblDatabaseError,1,8);
    
    add(txtFirstName,1,1);
    add(txtTussenvoegsel,1,2);
    add(txtSureName,1,3);
    add(txtEmail,1,4);
    add(txtPhonenr,1,5);
    add(txtPlaceOfLiving,1,6);
    add(addPerson,1,7);
    
    
    p.getChildren().addAll(this);
    }

    private void vrijwilligerToevoegen() {
        Vrijwilliger nieuweVrijwilliger = new Vrijwilliger();
        DbConnector dbConnector = new DbConnector();
        
        nieuweVrijwilliger.setFirstName(txtFirstName.getText());
        nieuweVrijwilliger.setTussenvoegsel(txtTussenvoegsel.getText());
        nieuweVrijwilliger.setSureName(txtSureName.getText());
        nieuweVrijwilliger.setEmail(txtEmail.getText());
        nieuweVrijwilliger.setPhoneNumber(txtPhonenr.getText());
        nieuweVrijwilliger.setPlaceOfLiving(txtPlaceOfLiving.getText());
        
        String strQuery = "INSERT INTO Vrijwilliger VALUES ('"+nieuweVrijwilliger.getEmail()+"','" +nieuweVrijwilliger.getFirstName()+"','"+nieuweVrijwilliger.getTussenvoegsel()+"','"+nieuweVrijwilliger.getSureName()+"','"+nieuweVrijwilliger.getPhoneNumber()+"','"+nieuweVrijwilliger.getPlaceOfLiving()+"')";
        int result = dbConnector.executeDML(strQuery);
        if(result == 1){
            //gelukt, clear de velden
        txtFirstName.clear();
        txtTussenvoegsel.clear();
        txtSureName.clear();
        txtEmail.clear();
        txtPhonenr.clear();
        txtPlaceOfLiving.clear();
        }else{
            //niet gelukt, laat de tekst staan en geef een waarschuwing
            lblDatabaseError.setVisible(true);
        }
    }
    
}
