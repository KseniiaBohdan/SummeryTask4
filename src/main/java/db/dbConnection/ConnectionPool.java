package db.dbConnection;

import db.dbConstant.DbUtilConstant;

import java.sql.*;

import java.util.Vector;

public class ConnectionPool {
    private static Vector<Connection> freeConnections = new Vector();
    private static Vector<Connection> usedConnections = new Vector();
    private final static int size = 30;
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(ConnectionPool.class);
    private static ConnectionPool connectionPool= new ConnectionPool();

    private ConnectionPool() {
        try {
            Class.forName(DbUtilConstant.DRIVER).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < size; i++) {
            freeConnections.addElement(getConnection());
        }
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    private static Connection getConnection() {
        try {
            Class.forName(DbUtilConstant.DRIVER).newInstance();
            Connection con = DriverManager.getConnection(DbUtilConstant.DB_URL, DbUtilConstant.USER_NAME, DbUtilConstant.PASSWORD);
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

    public static synchronized Connection getFreeConnection() {
        if (freeConnections.size() > 0) {
            Connection con = freeConnections.lastElement();
            freeConnections.removeElement(con);
            usedConnections.addElement(con);
            LOGGER.debug("Free Connections : " + freeConnections.size());
            LOGGER.debug("Used Connections : " + usedConnections.size());
            return con;
        } else {
            return getFreeConnection();
        }
    }

    public static synchronized boolean putUnusedConnection(Connection connection) {
        if (!freeConnections.contains(connection) && freeConnections.size() < size) {
            freeConnections.addElement(connection);
            usedConnections.remove(connection);
            return true;
        } else {
            return false;
        }
    }
}
