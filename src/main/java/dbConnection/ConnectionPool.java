package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Vector;

public class ConnectionPool {
    private Vector<Connection> freeConnection;
    private Vector<Connection> usedConnection;
    private String url;
    private String user;
    private String password;
    private int connectionNumb;


    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/payment_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";

        ConnectionPool connectionPool = new ConnectionPool(URL, 10, username, password);

    }


    public ConnectionPool(String url, int size, String user, String password) {
        this.user = user;
        this.password = password;
        connectionNumb = size;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.url = url;
        for (int i = 0; i < connectionNumb; i++) {
            freeConnection.addElement(getConnection());
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost/payment_system", "root", "root");
            return connection;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public synchronized Connection getFreeConnection() {
        if (freeConnection.size() > 0) {
            Connection con = null;
            con = freeConnection.lastElement();
            freeConnection.removeElement(con);
            usedConnection.addElement(con);
            return con;
        } else {
            return this.getFreeConnection();
        }
    }

    public synchronized boolean putUnUsedConnection(Connection connection) {
        if (!freeConnection.contains(connection) && freeConnection.size() < connectionNumb) {
            freeConnection.addElement(connection);
            return true;
        }
        return false;   //exception
    }
}
