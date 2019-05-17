/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.Connector;

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

            String strConnString = "jdbc:oracle:thin:@localhost:1521:XE";
            conn = DriverManager.getConnection(strConnString, "DATABASE4", "Muis1993");
        } catch (Exception e) {
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
            System.out.println("ERROR");
            //error
        }
        return result;
    }
    

     public int executeDML(String strSQL){

        int result = 0;
        try{
            Statement stmt = createConnection().createStatement();
            result = stmt.executeUpdate(strSQL);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return result;
    }
}

