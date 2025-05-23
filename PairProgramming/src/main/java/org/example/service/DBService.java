package org.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBService {

    public static Connection con;
    static final Logger logger = Logger.getLogger("DBService.class");

    public static void setConnection(String url, String userName, String password){
        try {
            con = DriverManager.getConnection(url,userName,password);
            if(con!=null){
                logger.info("Database Connection successful!");
                logger.info("Database Product: "+con.getMetaData().getDatabaseProductName());
                logger.info("Database Name: "+con.getCatalog());
            }
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

    public static void executeUserQuery(String query){
        try {
            PreparedStatement ps = con.prepareStatement(query);
            if (ps.execute()) {
                logger.info("selecting/creating operation successful!");
            } else {
                logger.info("updating operation successful!");
            }
        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

}
