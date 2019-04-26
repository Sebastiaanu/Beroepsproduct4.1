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
public class VrijwilligerToevoegenView extends GridPane{
    public Text lblFirstName;
    public Text lblTussenvoegsel;
    public Text lblSureName;
    public Text lblEmail;
    public Text lblPhonenr;
            
    public TextField txtFirstName;
    public TextField txtTussenvoegsel;
    public TextField txtSureName;
    public TextField txtEmail;
    public TextField txtPhonenr;
    
    public Button addPerson;
    
    public VrijwilligerToevoegenView(Pane p) {
    lblFirstName = new Text("Voornaam vrijwilliger: ");
    lblTussenvoegsel = new Text ("Tussenvoegsel vrijwilliger: ");
    lblSureName = new Text("Achternaam vrijwilliger: ");
    lblEmail = new Text("Email vrijwilliger: ");
    lblPhonenr = new Text("Telefoonnummer vrijwilliger: ");
    
    txtFirstName = new TextField();
    txtTussenvoegsel = new TextField();
    txtSureName = new TextField();
    txtEmail = new TextField();
    txtPhonenr = new TextField();
    
    addPerson = new Button("Vrijwilliger toevoegen");
    
    this.setPadding(new Insets(10,10,10,10));
    this.setVgap(10);
    
    add(lblFirstName,0,0);
    add(lblTussenvoegsel,0,1);
    add(lblSureName,0,2);
    add(lblEmail,0,3);
    add(lblPhonenr,0,4);
    
    add(txtFirstName,1,0);
    add(txtTussenvoegsel,1,1);
    add(txtSureName,1,2);
    add(txtEmail,1,3);
    add(txtPhonenr,1,4);
    add(addPerson,1,5);
    
    p.getChildren().addAll(this);
    }
    
}
