/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.View;

import beroepsproductblok4.Connector.DbConnector;

import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author jelmu
 */
public class LesToevoegenView extends GridPane {

    private Text vrijwText, weekText, dagText, uurText, buurtText;
    private ComboBox vrijwilliger, week, dag, buurthuis;
    private ObservableList<String> vrijwOpslag = FXCollections.observableArrayList();
    private ObservableList<String> weekOpslag = FXCollections.observableArrayList();
    private ObservableList<String> dagOpslag = FXCollections.observableArrayList("Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag", "Zondag");
    private ObservableList<String> buurtOpslag = FXCollections.observableArrayList();
    private RadioButton uur1, uur2, uur3, uur4, uur5, uur6, uur7;
    private Button send;
    private ArrayList<String> telnrOpslag = new ArrayList<>();
    DbConnector dbConnector = new DbConnector();

    public LesToevoegenView(Pane p) {
        buurtText = new Text("Buurthuis: ");
        vrijwText = new Text("Vrijwilliger: ");
        weekText = new Text("Week: ");
        dagText = new Text("Dag: ");
        uurText = new Text("Uur: ");

        uur1 = new RadioButton("14:00");
        uur2 = new RadioButton("15:00");
        uur3 = new RadioButton("16:00");
        uur4 = new RadioButton("17:00");
        uur5 = new RadioButton("18:00");
        uur6 = new RadioButton("19:00");
        uur7 = new RadioButton("20:00");

        send = new Button("Les aanmaken");
        send.setOnAction(e -> sendGegevens());

        fillLijst();

        buurthuis = new ComboBox(buurtOpslag);
        vrijwilliger = new ComboBox(vrijwOpslag);
        week = new ComboBox(weekOpslag);
        dag = new ComboBox(dagOpslag);

        add(buurtText, 0, 0);
        add(buurthuis, 1, 0);

        add(vrijwText, 0, 1);
        add(vrijwilliger, 1, 1);

        add(weekText, 0, 2);
        add(week, 1, 2);

        add(dagText, 0, 3);
        add(dag, 1, 3);

        add(uurText, 0, 4);
        add(uur1, 1, 4);
        add(uur2, 1, 5);
        add(uur3, 1, 6);
        add(uur4, 1, 7);
        add(uur5, 2, 4);
        add(uur6, 2, 5);
        add(uur7, 2, 6);

        add(send, 0, 8);

        setPadding(new Insets(10, 10, 10, 10));
        setHgap(5);
        setVgap(5);
        p.getChildren().add(this);

    }

    public void fillLijst() {
        fillWeek();
        fillVrijwilliger();
        fillBuurthuis();
    }

    public void fillWeek() {
        for (int i = 1; i <= 52; i++) {
            String w = String.valueOf(i);
            weekOpslag.add(w);
        }
    }

    private void fillVrijwilliger() {
        ResultSet result = null;
        try {
            String strSQL = "SELECT * FROM Vrijwilliger";
            result = dbConnector.getData(strSQL);
            while (result.next()) {
                String vrijEmail = result.getString("Email");
                vrijwOpslag.add(vrijEmail);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void fillBuurthuis() {
        ResultSet result = null;
        try {
            String strSQL = "SELECT * FROM Buurthuis";
            result = dbConnector.getData(strSQL);
            while (result.next()) {
                String buurthuisNaam = result.getString("Naam");
                String buurthuistelNr = result.getString("Telnr");
                buurtOpslag.add(buurthuisNaam);
                telnrOpslag.add(buurthuistelNr);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sendGegevens() {
        int weekN = Integer.parseInt(week.getValue().toString());
        int dagN = dag.getSelectionModel().getSelectedIndex() + 1;
        int telnrIndex = buurthuis.getSelectionModel().getSelectedIndex();
        String vrijEmail = vrijwilliger.getValue().toString();
        ArrayList<Integer> lesuren = getLesuren();
        try {
            for (int i = 0; i < lesuren.size(); i++) {
                String strQuery = "insert into Les (IDLES, WEEK, DAG, UUR, BUURTHUIS_TELNR, VRIJWILLIGER_EMAIL) values (seq_les.nextval,'" + weekN + "','" + dagN + "','" + lesuren.get(i) + "','" + telnrOpslag.get(telnrIndex) + "','" + vrijEmail + "')";
                int result = dbConnector.executeDML(strQuery);

                if (result == 1) {
                    System.out.println("Gegevens verzonden naar de database");
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ArrayList<Integer> getLesuren() {
        ArrayList<Integer> lesuren = new ArrayList<>();

        if (uur1.isSelected()) {
            lesuren.add(1);
        }
        if (uur2.isSelected()) {
            lesuren.add(2);
        }
        if (uur3.isSelected()) {
            lesuren.add(3);
        }
        if (uur4.isSelected()) {
            lesuren.add(4);
        }
        if (uur5.isSelected()) {
            lesuren.add(5);
        }
        if (uur6.isSelected()) {
            lesuren.add(6);
        }
        if (uur7.isSelected()) {
            lesuren.add(7);
        }
        return lesuren;
    }
}
