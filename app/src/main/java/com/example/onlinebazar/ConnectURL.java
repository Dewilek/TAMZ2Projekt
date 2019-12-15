package com.example.onlinebazar;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectURL {
    String connecitonurl = "jdbc:sqlserver://localhost:3306;databaseName=OnlineBazar;user=DESKTOP-IDCJ8NJ\\Dewi;password=" + "";
    public int[] ID;
    public String[] aName;
    public int[] abPrice;
    public int[] abPriceBlue;
    public int[] abPriceGrey;
    public String[] descri;
    int i = 0;

    public void TryConenction() {

        try {
            Connection con = DriverManager.getConnection(connecitonurl);
            Statement stmt = con.createStatement();
            String SQL = "SELECT TOP 10 * FROM test_db";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " " + rs.getString("aName") + " " + rs.getInt("abPrice")+ " "
                        + rs.getInt("abPriceBlue")+ " " + rs.getInt("abPriceGrey")+ " " + rs.getString("descri"));

                ID[i] = rs.getInt("ID");
                aName[i] = rs.getString("aName");
                abPrice[i] = rs.getInt("abPrice");
                abPriceBlue[i] = rs.getInt("abPriceBlue");
                abPriceGrey[i] = rs.getInt("abPriceGrey");
                descri[i] = rs.getString("descri");
                i++;
            }
            i = 0;
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("KONEC","NEFUNGUJE TO KURVAAA");
        }
    }
}
