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
public class BuurthuisAanpassenView extends GridPane {

    private Text titelAanpassenView;
    private Text lblSelectName;
    private Text lblPhonenr;
    private Text lblName;
    private Text lblAdres;
    private Text lblPostalCode;
    private Text lblContactPerson;
    private Text lblCity;

    private TextField txtPhonenr;
    private TextField txtName;
    private TextField txtAdres;
    private TextField txtPostalCode;
    private TextField txtContactPerson;
    private TextField txtCity;

    private ComboBox cBSelectBuurthuis;
    private Button selectBuurthuis;
    private Button editBuurthuis;
    private DbConnector dbConnector;

    private Text filler;
    String oudNummer;

    public BuurthuisAanpassenView(Pane p) {
        titelAanpassenView = new Text("Aanpassen Buurthuis");
        titelAanpassenView.setFont(Font.font("Verdana", 20));
        lblSelectName = new Text("Selecteer naam van Buurthuis: ");
        lblPhonenr = new Text("Telefoonnummer Buurthuis: ");
        lblName = new Text("Naam van Buurthuis: ");
        lblAdres = new Text("Adres van Buurthuis: ");
        lblPostalCode = new Text("Postcode van Buurthuis: ");
        lblContactPerson = new Text("Contactpersoon van Buurthuis: ");
        lblCity = new Text("Plaats van Buurthuis: ");

        txtPhonenr = new TextField();
        txtName = new TextField();
        txtAdres = new TextField();
        txtPostalCode = new TextField();
        txtContactPerson = new TextField();
        txtCity = new TextField();

        cBSelectBuurthuis = new ComboBox();
        selectBuurthuis = new Button("Zoek buurthuis");
        editBuurthuis = new Button("Aanpassen");
        dbConnector = new DbConnector();
        filler = new Text(" ");
        
       vulDeBuurthuisCombo();

        selectBuurthuis.setOnAction(event -> {
            vulDeTextFields();
        });
        
        editBuurthuis.setOnAction(event->{
            editNaarDatabase();
        });

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setVgap(10);

        add(titelAanpassenView, 0, 0);
        add(lblSelectName, 0, 1);
        add(cBSelectBuurthuis, 1, 1);
        add(selectBuurthuis, 1, 3);
        add(editBuurthuis,1,11);
        add(filler, 0, 4);

        add(lblName, 0, 5);
        add(lblAdres, 0, 6);
        add(lblPostalCode, 0, 7);
        add(lblCity, 0, 8);
        add(lblContactPerson, 0, 9);
        add(lblPhonenr, 0, 10);

        add(txtName, 1, 5);
        add(txtAdres, 1, 6);
        add(txtPostalCode, 1, 7);
        add(txtCity, 1, 8);
        add(txtContactPerson, 1, 9);
        add(txtPhonenr, 1, 10);

        p.getChildren().addAll(this);
    }

    private void vulDeBuurthuisCombo() {
        ResultSet result = null;
        try {
            String strSQL = "SELECT * FROM Buurthuis";
            result = dbConnector.getData(strSQL);
            while (result.next()) {
                String buurthuisNaam = result.getString("Naam");
                cBSelectBuurthuis.getItems().add(buurthuisNaam);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void vulDeTextFields() {
        ResultSet result = null;
        String text = cBSelectBuurthuis.getValue().toString();
        Buurthuis buurthuis = new Buurthuis();

        try {

            String strSQL = "SELECT * FROM Buurthuis WHERE Naam =('" + text + "')";
            result = dbConnector.getData(strSQL);
            while (result.next()) {
                buurthuis.setName((result.getString("Naam")).toString());
                buurthuis.setAdres((result.getString("Adres")).toString());
                buurthuis.setPostalCode((result.getString("Postcode")).toString());
                buurthuis.setCity((result.getString("Plaats")).toString());
                buurthuis.setContactPerson((result.getString("Contactpersoon")).toString());
                buurthuis.setPhoneNumber((result.getString("Telnr")).toString());

                txtName.setText(buurthuis.getName());
                txtAdres.setText(buurthuis.getAdres());
                txtPostalCode.setText(buurthuis.getPostalCode());
                txtCity.setText(buurthuis.getCity());
                txtContactPerson.setText(buurthuis.getContactPerson());
                txtPhonenr.setText(buurthuis.getPhoneNumber());

                 oudNummer = (txtPhonenr.getText());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void editNaarDatabase(){
       
        try{
            
            String strSQL = "UPDATE Buurthuis SET NAAM = ('"+txtName.getText()+"'), ADRES = ('"+txtAdres.getText()+"'), POSTCODE = ('"+txtPostalCode.getText()+"'), CONTACTPERSOON = ('"+txtContactPerson.getText()+"'), PLAATS = ('"+txtCity.getText()+"') WHERE TELNR = ('"+oudNummer+"')"; 
            int result = dbConnector.executeDML(strSQL);
            if(result ==1){
               txtName.clear();
               txtAdres.clear();
               txtPostalCode.clear();
               txtCity.clear();
               txtContactPerson.clear();
               txtPhonenr.clear();
            }else{
                
            }
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
