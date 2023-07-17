package com.example.inventorymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connectDb() {
        Connection connect = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory-management", "root", "");
        }
        catch (Exception e){
            e.printStackTrace();  // Database name: inventory-management; default username: root; "": default pass
        }
        return connect;
    }
}
