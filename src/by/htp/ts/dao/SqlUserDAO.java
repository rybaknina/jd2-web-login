package by.htp.ts.dao;

import _java._se._07_connectionpool.ConnectionPool.ConnectionPool;
import _java._se._07_connectionpool.ConnectionPool.ConnectionPoolException;
import by.htp.ts.been.User;
import by.htp.ts.command.impl.RequestParameter;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlUserDAO implements UserDAO{
    private static final Logger LOGGER = Logger.getLogger(SqlUserDAO.class.getName());
    private ConnectionPool pool = ConnectionPool.getInstance();
    private PreparedStatement ps=null;
    private ResultSet rs=null;

    private static final String INSERT_USER_SQL = "INSERT INTO user" + "  (email, password) VALUES " +
            " (?, ?);";
    private static final String SELECT_USER_BY_EMAIL = "select email, password from user where email =?";


//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("org.gjt.mm.mysql.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jd2_ex06?useSSL=false","root","123456");
//        } catch (SQLException e) {
//            LOGGER.log(Level.SEVERE, "SQLException occur", e);
//        } catch (ClassNotFoundException e) {
//            LOGGER.log(Level.SEVERE, "ClassNotFoundException occur", e);
//        }
//        return connection;
//
//    }

    @Override
    public void save(User user) {

        try{
        //    pool.initPoolData();
        //    pool = ConnectionPool.getInstance();
            ps = pool.createPrepareStatement(INSERT_USER_SQL);
            ps.setString(1, user.getEmail());
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
        ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException occur", e);
        }

    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        try {
        //        pool = ConnectionPool.getInstance();
                ps = pool.createPrepareStatement(SELECT_USER_BY_EMAIL);
                ps.setString(1, email);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String password = rs.getString(RequestParameter.PASSWORD);
                    user = new User(email, password);
                }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException occur", e);
        }
        return user;
    }
}
