/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author jelmu
 */
public class BuurthuisToevoegenView extends GridPane{
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
        lblName = new Text("Naam buurthuis toevoegen");
        lblAdres = new Text("Adres buurthuis toevoegen");
        lblPostalCode = new Text("Postcode buurthuis toevoegen");
        lblCity = new Text("Stad/dorp buurthuis toevoegen:");
        lblContactPerson = new Text("Contactpersoon buurthuis toevoegen:");
        lblPhonenr = new Text("Telefoonnummer buurthuis toevoegen:");
        
        txtName = new TextField();
        txtAdres = new TextField();
        txtPostalCode = new TextField();
        txtCity = new TextField();
        txtContactPerson = new TextField();
        txtPhonenr = new TextField();
        
        addBuurthuis = new Button("Buurthuis Toevoegen");
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(lblName,0,0);
        add(lblAdres,0,1);
        add(lblPostalCode,0,2);
        add(lblCity,0,3);
        add(lblContactPerson,0,4);
        add(lblPhonenr,0,5);
        
       add(txtName,1,0);
       add(txtAdres,1,1);
       add(txtPostalCode,1,2);
       add(txtCity,1,3);
       add(txtContactPerson,1,4);
       add(txtPhonenr,1,5);
       
       add(addBuurthuis,1,6);
        
        p.getChildren().addAll(this);
    
    }
    
}
