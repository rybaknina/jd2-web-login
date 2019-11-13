package _java._se._07_connectionpool.Main;

import _java._se._07_connectionpool.ConnectionPool.ConnectionPool;
import _java._se._07_connectionpool.ConnectionPool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ConnectionPoolException {
        ConnectionPool pool = ConnectionPool.getInstance();

       // c.initPoolData();

        Connection con = pool.takeConnection();

        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.printf("%4d %10s %10s %20s",rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString("email"));
                System.out.println();
            }
            pool.closeConnection(con, st, rs);;
        } catch (SQLException e) {

        }
        finally {
            pool.dispose();
        }








    }
}
