/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import beroepsproductblok4.Connector.DbConnector;
import beroepsproductblok4.Model.Buurthuis;
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
public class BuurthuisToevoegenView extends GridPane{
    public Text lblBuurthuisToevoegen;
    public Text lblName;
    public Text lblAdres;
    public Text lblPostalCode;
    public Text lblCity;
    public Text lblContactPerson;
    public Text lblPhonenr;
            
    public TextField txtName;
    public TextField txtAdres;
    public TextField txtPostalCode;
    public TextField txtCity;
    public TextField txtContactPerson;
    public TextField txtPhonenr;
    
    public Button addBuurthuis;
    
    public BuurthuisToevoegenView(Pane p) {
        lblBuurthuisToevoegen = new Text("Buurthuis toevoegen");
        lblBuurthuisToevoegen.setFont(Font.font("Verdana",20));
        lblName = new Text("Naam buurthuis toevoegen: ");
        lblAdres = new Text("Adres buurthuis toevoegen: ");
        lblPostalCode = new Text("Postcode buurthuis toevoegen: ");
        lblCity = new Text("Stad/dorp buurthuis toevoegen: ");
        lblContactPerson = new Text("Contactpersoon buurthuis toevoegen: ");
        lblPhonenr = new Text("Telefoonnummer buurthuis toevoegen: ");
        
        txtName = new TextField();
        txtAdres = new TextField();
        txtPostalCode = new TextField();
        txtCity = new TextField();
        txtContactPerson = new TextField();
        txtPhonenr = new TextField();
        
        addBuurthuis = new Button("Buurthuis Toevoegen");
        
        addBuurthuis.setOnAction(event->{
            try{
            buurthuisToevoegen();
            }catch(Exception e){
                System.out.println(e);
            }
        });
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(lblBuurthuisToevoegen,0,0);
        add(lblName,0,1);
        add(lblAdres,0,2);
        add(lblPostalCode,0,3);
        add(lblCity,0,4);
        add(lblContactPerson,0,5);
        add(lblPhonenr,0,6);
        
       add(txtName,1,1);
       add(txtAdres,1,2);
       add(txtPostalCode,1,3);
       add(txtCity,1,4);
       add(txtContactPerson,1,5);
       add(txtPhonenr,1,6);
       
       add(addBuurthuis,1,7);
        
        p.getChildren().addAll(this);
    
    }

    private void buurthuisToevoegen() {
            Buurthuis nieuwBuurthuis = new Buurthuis();
            DbConnector dbConnector = new DbConnector();
            
            nieuwBuurthuis.setName(txtName.getText());
            nieuwBuurthuis.setAdres(txtAdres.getText());
            nieuwBuurthuis.setPostalCode(txtPostalCode.getText());
            nieuwBuurthuis.setCity(txtCity.getText());
            nieuwBuurthuis.setContactPerson(txtContactPerson.getText());
            nieuwBuurthuis.setPhoneNumber(txtPhonenr.getText());
            
            String strQuery = "INSERT INTO Buurthuis VALUES ('"+nieuwBuurthuis.getName()+"','" +nieuwBuurthuis.getAdres()+"','"+nieuwBuurthuis.getPostalCode()+"','"+nieuwBuurthuis.getCity()+"','"+nieuwBuurthuis.getContactPerson()+"','"+nieuwBuurthuis.getPhoneNumber()+"'";                                          
            int result = dbConnector.executeDML(strQuery);
            if(result == 1){
                //gelukt, clear de tekstvelden
                txtName.clear();
                txtAdres.clear();
                txtPostalCode.clear();
                txtCity.clear();
                txtContactPerson.clear();
                txtPhonenr.clear();
            }else{
                //niet gelukt, laat de tekst staan en geef een waarschuwing
                
            }
            
    }
    
}
