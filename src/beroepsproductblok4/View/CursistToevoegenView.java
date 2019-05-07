/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import beroepsproductblok4.Connector.DbConnector;
import beroepsproductblok4.Model.Cursist;
import java.sql.ResultSet;
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
public class CursistToevoegenView extends GridPane {
    public Text lblCursistToevoegenView;
    public Text lblFirstName;
    public Text lblTussenvoegsel;
    public Text lblSureName;
    public Text lblEmail;
    public Text lblPhonenr;
    public Text lblCountryOfOrigin;
    public Text lblPlaceOfLiving;
    
    public Text lblDatabaseError;
            
    public TextField txtFirstName;
    public TextField txtTussenvoegsel;
    public TextField txtSureName;
    public TextField txtEmail;
    public TextField txtPhonenr;
    public TextField txtCountryOfOrigin;
    public TextField txtPlaceOfLiving;
    
    public Button addPerson;
    
    public CursistToevoegenView(Pane p) {
    lblCursistToevoegenView = new Text("Toevoegen Cursist");
    lblCursistToevoegenView.setFont(Font.font("Verdana",20));
    
    lblFirstName = new Text("Voornaam cursist: ");
    lblTussenvoegsel = new Text ("Tussenvoegsel cursist: ");
    lblSureName = new Text("Achternaam cursist: ");
    lblEmail = new Text("Email cursist: ");
    lblPhonenr = new Text("Telefoonnummer cursist: ");
    lblCountryOfOrigin = new Text("Land van herkomst");
    lblPlaceOfLiving = new Text("Huidige woonplaats: ");
    
    lblDatabaseError = new Text("Foutmelding in de database.");
    lblDatabaseError.setVisible(false);
    
    txtFirstName = new TextField();
    txtTussenvoegsel = new TextField();
    txtSureName = new TextField();
    txtEmail = new TextField();
    txtPhonenr = new TextField();
    txtCountryOfOrigin = new TextField();
    txtPlaceOfLiving = new TextField();
    
    
    addPerson = new Button("Cursist toevoegen");
    
    addPerson.setOnAction(event->{
        try{
        cursistToevoegen();
        }catch(Exception e){
            lblDatabaseError.setText("Foutmelding" + e);
            lblDatabaseError.setVisible(true);
            }
      });
   
            
            
   
    
    this.setPadding(new Insets(10,10,10,10));
    this.setVgap(10);
    
    add(lblCursistToevoegenView,0,0);
    add(lblFirstName,0,1);
    add(lblTussenvoegsel,0,2);
    add(lblSureName,0,3);
    add(lblEmail,0,4);
    add(lblPhonenr,0,5);
    add(lblCountryOfOrigin,0,6);
    add(lblPlaceOfLiving,0,7);
    add(lblDatabaseError,1,9);
    
    add(txtFirstName,1,1);
    add(txtTussenvoegsel,1,2);
    add(txtSureName,1,3);
    add(txtEmail,1,4);
    add(txtPhonenr,1,5);
    add(txtCountryOfOrigin,1,6);
    add(txtPlaceOfLiving,1,7);
    
    add(addPerson,1,8);
    
    p.getChildren().addAll(this);
    }
    
    
    public void cursistToevoegen(){
        try{
        Cursist nieuweCursist = new Cursist();
        DbConnector dbConnector = new DbConnector();
        
        nieuweCursist.setFirstName(txtFirstName.getText());
        nieuweCursist.setTussenvoegsel(txtTussenvoegsel.getText());
        nieuweCursist.setSureName(txtSureName.getText());
        nieuweCursist.setEmail(txtEmail.getText());
        nieuweCursist.setPhoneNumber(txtPhonenr.getText());
        nieuweCursist.setCountryOfOrigin(txtCountryOfOrigin.getText());
        
        //naam van sequence is seq_cursist.
        String strQuery = "insert into Cursist values (seq_cursist.nextval,'"+nieuweCursist.getEmail()+"','" +nieuweCursist.getFirstName()+"','"+nieuweCursist.getTussenvoegsel()+"','"+nieuweCursist.getSureName()+"','"+nieuweCursist.getPhoneNumber()+"','"+nieuweCursist.getCountryOfOrigin()+"','"+nieuweCursist.getPlaceOfLiving()+"')";                                          
        int result = dbConnector.executeDML(strQuery);
        
        if(result ==1){
            //gelukt, clear de tekstvelden
        txtFirstName.clear();
        txtTussenvoegsel.clear();
        txtSureName.clear();
        txtEmail.clear();
        txtPhonenr.clear();
        txtCountryOfOrigin.clear(); 
        txtPlaceOfLiving.clear();
        }else{
            //niet gelukt, laat de tekst staan en geef een waarschuwing
            lblDatabaseError.setVisible(true);
        }
        }catch(Exception e){
            System.out.println(e);
        }
    
        
    
    
        }
}
