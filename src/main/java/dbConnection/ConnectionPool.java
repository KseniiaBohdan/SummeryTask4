package dbConnection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

import java.util.Vector;
import java.util.logging.Logger;

public class ConnectionPool {
    private Vector<Connection> freeConnections;
    private Vector<Connection> usedConnections;
    private final static String url = "jdbc:mysql://localhost:3306/payment_system";
    private final static String userName = "root";
    private final static String password = "root";
    //private final static String driverName = ;
    private final static int size = 10;

    /*
        private static Connection test(){
            try {
                Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_system", "root", "root");
                return con;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }


        public ConnectionPool(String url, int size, String userName, String password, String driverName) {
            this.userName = userName;
            this.driverName = driverName;
            this.password = password;
            this.size = size;
            /*try {
                Class.forName(this.driverName).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }*/
      /*  this.url = url;
        for (int i = 0; i < this.size; i++) {
            freeConnections.addElement(getConnection());
        }
*/

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver()");
            Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_system", "root", "root");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
/*
    public synchronized Connection getFreeConnections() {
        if (freeConnections.size() > 0) {
            Connection con = null;
            con = freeConnections.lastElement();
            freeConnections.removeElement(con);
            usedConnections.addElement(con);
            return con;
        } else {
            return this.getFreeConnections();
        }
    }

    public synchronized boolean putUnUsedConnection(Connection connection) {
        if (!freeConnections.contains(connection) && freeConnections.size() < size) {
            freeConnections.addElement(connection);
            return true;
        }
        return false;   //exception
    }*/
}
