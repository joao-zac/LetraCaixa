package org.example.demo2.util;

import java.sql.*;

public class ConnectionFactory {
    private static Connection conn = null;
    
    private static final String url = "jdbc:mysql://localhost:3306/logfilme";
    private static final String user = "root";
    private static final String password = "Jornalzin123"; 


    public static Connection getConnection() {
        if(conn==null){
            try {
                conn = DriverManager.getConnection(url,user,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    public static void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeStatement(Statement st){
        if(st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}