/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

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
    
    }
    
}
