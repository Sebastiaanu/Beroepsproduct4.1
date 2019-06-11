/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.Connector;

import beroepsproductblok4.View.AlertBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnector {

    ResultSet result = null;

    public DbConnector() {

    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String strConnString = "jdbc:oracle:thin:@145.49.75.86:1521:XE";
            conn = DriverManager.getConnection(strConnString, "DATABASE4", "Muis1993");
        } catch (Exception e) {
            String eMessage = e.toString();
            AlertBox.display("Connection error", eMessage);
            System.out.println(e.getMessage());

        }
        return conn;
    }

    public ResultSet getData(String strSQL) {
        try {
            Statement stmt = createConnection().createStatement();
            result = stmt.executeQuery(strSQL);
        } catch (Exception e) {
            System.out.println(e);
            String eMessage = e.toString();
            AlertBox.display("Recieving data error", eMessage);
            System.out.println("ERROR in getting data");
            //error
        }
        return result;
    }

    public int executeDML(String strSQL) {

        int result = 0;
        try {
            Statement stmt = createConnection().createStatement();
            result = stmt.executeUpdate(strSQL);
        } catch (Exception e) {
            String eMessage = e.toString();
            AlertBox.display("Error", eMessage);
            System.err.println(e.getMessage());
        }
        return result;
    }
}
