package com.buiminhduc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySqlConnectionUtil {
    private static final ResourceBundle rb =ResourceBundle.getBundle("DatabaseInformation");
    private static final String user_name= rb.getString("datasource.user");
    private static final String pass_word = rb.getString("datasource.password");
    private static final String URL=rb.getString("datasource.url");
    private static final String DriverName=rb.getString("datasource.driver");
    public static Connection getConnection(){
        try {
            Class.forName(DriverName);
            return DriverManager.getConnection(URL,user_name,pass_word);
        } catch (ClassNotFoundException e) {
            return null;
        }   catch (SQLException e){
            return null;
        }
    }
    public static void disConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
