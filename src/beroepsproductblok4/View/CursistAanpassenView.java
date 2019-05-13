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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jelmu
 */
public class CursistAanpassenView extends GridPane {
    private Text lblCursistAanpassen;
    private Text lblSelectName;
    private Text lblFirstName;
    private Text lblTussenvoegsel;
    private Text lblSureName;
    private Text lblEmail;
    private Text lblPhonenr;
    private Text lblCountryOfOrigin;
    private Text lblPlaceOfLiving;
    
    private Text lblDatabaseError;
            
    private TextField txtFirstName;
    private TextField txtTussenvoegsel;
    private TextField txtSureName;
    private TextField txtEmail;
    private TextField txtPhonenr;
    private TextField txtCountryOfOrigin;
    private TextField txtPlaceOfLiving;
    
    private ComboBox cBSelectCursist;
    private Button selectCursist;
    private Button editBuurthuis;
    private DbConnector dbConnector;
    private Text filler;
        
    public CursistAanpassenView(Pane p) {
        lblCursistAanpassen = new Text("Cursist aanpassen");
        lblCursistAanpassen.setFont(Font.font("Verdana",20));
        
        lblSelectName = new Text("Selecteer naam van Buurthuis: ");
        lblFirstName = new Text("Voornaam cursist: ");
        lblTussenvoegsel = new Text("Tussenvoegsel cursist: ");
        lblSureName = new Text("Achternaam cursist: ");
        lblEmail = new Text("Email cursist: ");
        lblPhonenr = new Text("Telefoonnummer cursist: ");
        lblCountryOfOrigin = new Text("Land van herkomst: ");
        lblPlaceOfLiving = new Text("Huidige woonplaats: ");
        
        txtFirstName = new TextField();
        txtTussenvoegsel = new TextField();
        txtSureName = new TextField();
        txtEmail = new TextField();
        txtPhonenr = new TextField();
        txtCountryOfOrigin = new TextField();
        txtPlaceOfLiving = new TextField();
        
        cBSelectCursist = new ComboBox();
        selectCursist = new Button("Zoek buurthuis");
        editBuurthuis = new Button("Aanpassen");
        dbConnector = new DbConnector();
        filler = new Text(" ");
        
        
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(lblCursistAanpassen,0,0);
        
        
        p.getChildren().addAll(this);
    }
    
    private void vuldeCursistCombo() {
        ResultSet result = null;
        try {
            String strSQL = "SELECT * FROM Buurthuis";
            result = dbConnector.getData(strSQL);
            while (result.next()) {
                String buurthuisNaam = result.getString("Naam");
                cBSelectCursist.getItems().add(buurthuisNaam);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
