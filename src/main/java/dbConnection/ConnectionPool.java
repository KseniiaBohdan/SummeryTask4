package dbConnection;

import constant.dbConstant.DbUtilConstant;

import java.sql.*;

import java.util.Vector;

public class ConnectionPool {
    private Vector<Connection> freeConnections;
    private Vector<Connection> usedConnections;
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
            Class.forName(DbUtilConstant.DRIVER).newInstance();
            Connection con =  DriverManager.getConnection(DbUtilConstant.DB_URL, DbUtilConstant.USER_NAME, DbUtilConstant.PASSWORD);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
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
