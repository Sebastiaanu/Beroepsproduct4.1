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
    private Button editCursist;
    private DbConnector dbConnector;
    private Text filler;
    
    private int cursistId;
        
    public CursistAanpassenView(Pane p) {
        lblCursistAanpassen = new Text("Cursist aanpassen");
        lblCursistAanpassen.setFont(Font.font("Verdana",20));
        
        lblSelectName = new Text("Selecteer naam van cursist: ");
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
        selectCursist = new Button("Zoek cursist");
        editCursist = new Button("Aanpassen");
        dbConnector = new DbConnector();
        filler = new Text(" ");
           
        vulDeCursistCombo();
        
        selectCursist.setOnAction(event->{
            vulDeTextFields();
        });
        
        editCursist.setOnAction(event->{
            editNaarDatabase();
        });
        
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        
        add(lblCursistAanpassen,0,0);
        add(lblSelectName,0,1);
        add(cBSelectCursist,1,1);
        add(selectCursist,1,3);
        add(editCursist,1,12);
        add(filler,1,4);
        
        add(lblFirstName,0,5);
        add(lblTussenvoegsel,0,6);
        add(lblSureName,0,7);
        add(lblEmail,0,8);
        add(lblPhonenr,0,9);
        add(lblCountryOfOrigin,0,10);
        add(lblPlaceOfLiving,0,11);
        
        add(txtFirstName,1,5);
        add(txtTussenvoegsel,1,6);
        add(txtSureName,1,7);
        add(txtEmail,1,8);
        add(txtPhonenr,1,9);
        add(txtCountryOfOrigin,1,10);
        add(txtPlaceOfLiving,1,11);
        
        
        p.getChildren().addAll(this);
    }
    
    private void vulDeCursistCombo() {
        ResultSet result = null;
        try {
            String strSQL = "SELECT * FROM Cursist";
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
        Cursist cursist = new Cursist();
        
        try{
           String strSQL = "SELECT * FROM Cursist WHERE Voornaam = ('"+splitted[0]+"') AND Achternaam = ('"+splitted[1]+"')";
           result = dbConnector.getData(strSQL);
           while (result.next()){
           cursist.setIdCursist(Integer.parseInt(result.getString("Idcursist")));
           cursistId = cursist.getIdCursist();
           cursist.setFirstName(result.getString("Voornaam"));
           cursist.setTussenvoegsel(result.getString("Tussenvoegsel"));
           cursist.setSureName(result.getString("Achternaam"));
           cursist.setEmail(result.getString("Email"));
           cursist.setPhoneNumber(result.getString("Telnr"));
           cursist.setCountryOfOrigin(result.getString("Landvherkomst"));
           cursist.setPlaceOfLiving(result.getString("Woonplaats"));
           
           txtFirstName.setText(cursist.getFirstName());
           txtTussenvoegsel.setText(cursist.getTussenvoegsel());
           txtSureName.setText(cursist.getSureName());
           txtEmail.setText(cursist.getEmail());
           txtPhonenr.setText(cursist.getPhoneNumber());
           txtCountryOfOrigin.setText(cursist.getCountryOfOrigin());
           txtPlaceOfLiving.setText(cursist.getPlaceOfLiving());
           }
           
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void editNaarDatabase(){
        try{
            String strSQL = "UPDATE Cursist SET VOORNAAM = ('"+txtFirstName.getText()+"'), TUSSENVOEGSEL = ('"+txtTussenvoegsel.getText()+"'), ACHTERNAAM = ('"+txtSureName.getText()+"'), EMAIL = ('"+txtEmail.getText()+"'), TELNR = ('"+txtPhonenr.getText()+"'), LANDVHERKOMST = ('"+txtCountryOfOrigin.getText()+"'), WOONPLAATS = ('"+txtPlaceOfLiving.getText()+"') WHERE IDCURSIST = ('"+cursistId+"') ";
            int result = dbConnector.executeDML(strSQL);
            if(result ==1){
                txtFirstName.clear();
                txtTussenvoegsel.clear();
                txtSureName.clear();
                txtEmail.clear();
                txtPhonenr.clear();
                txtCountryOfOrigin.clear();
                txtPlaceOfLiving.clear();
            }else{
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
