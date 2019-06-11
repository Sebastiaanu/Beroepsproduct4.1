/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import beroepsproductblok4.Connector.DbConnector;
import beroepsproductblok4.Model.Cursist;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author Sebastiaanu
 */
public class LesAanpassenView extends GridPane {

    private Text buurtTxt, weekTxt, lesTxt;
    private ObservableList<String> lesOpslag, weekOpslag, buurtOpslag, cursStringOpslag, newCursStringOpslag;
    private ComboBox weekBox, buurtBox, lesLijst;
    private ListView cursistLijst, newCurslijst;
    private ArrayList<String> telnrOpslag, plaatsOpslag;
    private ArrayList<Cursist> cursOpslag, newCursOpslag;
    private Button zoekLes, addCursist;

    private DbConnector dbConnector = new DbConnector();

    public LesAanpassenView(Pane p) {
        // Declareren ArrayListen
        telnrOpslag = new ArrayList();
        plaatsOpslag = new ArrayList();
        cursOpslag = new ArrayList();
        newCursOpslag = new ArrayList();

        // Declareren observableList
        lesOpslag = FXCollections.observableArrayList();
        weekOpslag = FXCollections.observableArrayList();
        buurtOpslag = FXCollections.observableArrayList();
        cursStringOpslag = FXCollections.observableArrayList();
        newCursStringOpslag = FXCollections.observableArrayList();

        //vult alle lijsten
        fillLijst();
        
        //comboboxen vullen en declareren
        weekBox = new ComboBox(weekOpslag);
        buurtBox = new ComboBox(buurtOpslag);
        lesLijst = new ComboBox<>(lesOpslag);

        // lijst cursisten vullen
        cursistLijst = new ListView(cursStringOpslag);
        cursistLijst.setOnMouseClicked(e -> {
            moveCursist();
        });

        //declareren lisview
        newCurslijst = new ListView(newCursStringOpslag);

        //declareren labels
        buurtTxt = new Text("Buurthuis: ");
        weekTxt = new Text("Week: ");
        lesTxt = new Text("Les (ID, Dag, uur, docent)");

        //declareren buttons
        zoekLes = new Button("Zoek Lessen");
        zoekLes.setOnAction(e -> {
            getLessen();
            fillCursistData();
            fillCursistLijst();

        });

        addCursist = new Button("Verzenden");
        addCursist.setOnAction(e -> {
            sendGegevens();
        });

        //alles toevoegen aan de pane
        add(buurtTxt, 0, 0);
        add(buurtBox, 1, 0);

        add(weekTxt, 0, 1);
        add(weekBox, 1, 1);
        add(zoekLes, 2, 1);

        add(lesTxt, 0, 2);
        add(lesLijst, 0, 3);
        add(cursistLijst, 0, 4);
        add(newCurslijst, 1, 4);
        add(addCursist, 0, 5);

        this.setVgap(5);
        this.setHgap(5);
        this.setPadding(new Insets(10, 10, 10, 10));
        p.getChildren().add(this);
    }

    public void fillLijst() {
        fillBuurthuis();
        fillWeek();
    }

    private void fillBuurthuis() {
        ResultSet result = null;
        try {
            String strSQL = "SELECT * FROM Buurthuis";
            result = dbConnector.getData(strSQL);
            while (result.next()) {
                String buurthuisNaam = result.getString("Naam");
                String buurthuistelNr = result.getString("Telnr");
                String buurthuisPlaats = result.getString("Plaats");
                buurtOpslag.add(buurthuisNaam + " " + buurthuisPlaats);
                telnrOpslag.add(buurthuistelNr);
                plaatsOpslag.add(buurthuisPlaats);
            }
        } catch (Exception e) {
            String eMessage = e.toString();
            AlertBox.display("Error", eMessage);
            System.out.println(e);
        }
    }

    public void fillWeek() {
        for (int i = 1; i <= 52; i++) {
            String w = String.valueOf(i);
            weekOpslag.add(w);
        }
    }

    public void getLessen() {
        ResultSet result = null;
        Integer pk = buurtBox.getSelectionModel().getSelectedIndex();
        String telnr = telnrOpslag.get(pk);
        String week = weekBox.getValue().toString();
        lesOpslag.clear();
        try {
            String strSQL = "SELECT * FROM Les where buurthuis_telnr ='" + telnr + "' AND Week ='" + week + "'";
            result = dbConnector.getData(strSQL);
            while (result.next()) {
                String lesId = result.getString("Idles");
                String dag = getDag(result.getString("Dag"));
                String uur = getUur(result.getString("uur"));
                String vrijwilliger = result.getString("Vrijwilliger_email");
                lesOpslag.add(lesId + " " + dag + " " + uur + " " + vrijwilliger);
            }
        } catch (Exception e) {
            String eMessage = e.toString();
            AlertBox.display("Error", eMessage);
            System.out.println(e);
        }
    }

    public void fillCursistData() {
        cursOpslag.clear();
        cursStringOpslag.clear();
        Cursist nCurs;
        ResultSet result = null;
        Integer plek = buurtBox.getSelectionModel().getSelectedIndex();
        String plaats = plaatsOpslag.get(plek);
        try {
            String strSQL = "SELECT * FROM Cursist where woonplaats = '" + plaats + "'";
            result = dbConnector.getData(strSQL);
            while (result.next()) {
                nCurs = new Cursist();
                nCurs.setIdCursist(result.getInt("IDCURSIST"));
                nCurs.setEmail(result.getString("Email"));
                nCurs.setFirstName(result.getString("Voornaam"));
                nCurs.setTussenvoegsel(result.getString("ACHTERNAAM"));
                nCurs.setPhoneNumber(result.getString("TELNR"));
                nCurs.setCountryOfOrigin(result.getString("LANDVHERKOMST"));
                nCurs.setPlaceOfLiving(result.getString("WOONPLAATS"));

                cursOpslag.add(nCurs);
            }
        } catch (Exception e) {
            String eMessage = e.toString();
            AlertBox.display("Error", eMessage);
            System.out.println(e);
        }
    }

    public void fillCursistLijst() {
        for (int i = 0; i < cursOpslag.size(); i++) {
            Cursist curs = cursOpslag.get(i);
            String id = Integer.toString(curs.getIdCursist());
            String vnaam = curs.getFirstName();
            String tvoegs = curs.getTussenvoegsel();
            String anaam = curs.getSureName();
            String email = curs.getEmail();

            cursStringOpslag.add(id + " " + vnaam + " " + tvoegs + " " + anaam + " " + email);
        }
    }

    public void moveCursist() {
        int plek = cursistLijst.getSelectionModel().getSelectedIndex();
        Cursist curs = cursOpslag.get(plek);
        newCursOpslag.add(curs);
        cursOpslag.remove(plek);
        cursStringOpslag.remove(plek);

        String id = Integer.toString(curs.getIdCursist());
        String vnaam = curs.getFirstName();
        String tvoegs = curs.getTussenvoegsel();
        String anaam = curs.getSureName();
        String email = curs.getEmail();

        newCursStringOpslag.add(id + " " + vnaam + " " + tvoegs + " " + anaam + " " + email);
    }

    public void sendGegevens() {
        String str = lesLijst.getValue().toString();
        String[] strSplit = str.split("\\s+");
        String lesId = strSplit[0];

        try {
            for (int i = 0; i < newCursOpslag.size(); i++) {
                String strQuery = "insert into les_cursist values (seq_lesCursist.nextval,'" + lesId + "','" + newCursOpslag.get(i).getIdCursist() + "')";
                int result = dbConnector.executeDML(strQuery);

                if (result == 1) {
                    System.out.println("Gegevens verzonden naar de database");
                }

            }
        } catch (Exception e) {
            String eMessage = e.toString();
            AlertBox.display("Error", eMessage);
            System.out.println(e);
        }
    }

    private String getDag(String dagNummer) {
        String dag = "";

        switch (dagNummer) {
            case "1":
                dag = "Maandag";
                break;
            case "2":
                dag = "Dinsdag";
                break;
            case "3":
                dag = "Woensdag";
                break;
            case "4":
                dag = "Donderdag";
                break;
            case "5":
                dag = "Vrijdag";
                break;
            case "6":
                dag = "Zaterdag";
                break;
            case "7":
                dag = "Zondag";
                break;

        }
        return dag;
    }

    private String getUur(String uurNummer) {
        String dag = "";

        switch (uurNummer) {
            case "1":
                dag = "14:00";
                break;
            case "2":
                dag = "15:00";
                break;
            case "3":
                dag = "16:00";
                break;
            case "4":
                dag = "17:00";
                break;
            case "5":
                dag = "18:00";
                break;
            case "6":
                dag = "19:00";
                break;
            case "7":
                dag = "20:00";
                break;

        }
        return dag;
    }
}
