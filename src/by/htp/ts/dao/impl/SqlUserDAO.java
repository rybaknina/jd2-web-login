package by.htp.ts.dao.impl;

import by.htp.ts._java._se_07_connectionpool.connectionpool.ConnectionPool;
import by.htp.ts._java._se_07_connectionpool.connectionpool.ConnectionPoolException;
import by.htp.ts.bean.User;
import by.htp.ts.command.impl.RequestParameter;
import by.htp.ts.controller.Controller;
import by.htp.ts.dao.DAOException;
import by.htp.ts.dao.UserDAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlUserDAO implements UserDAO {
    private static final Logger LOGGER = Logger.getLogger(SqlUserDAO.class.getName());
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private static final String INSERT_USER_SQL = "INSERT INTO user" + "  (email, password, role_id) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_USER_BY_EMAIL = "select email, password from user where email =?";


    @Override
    public void save(User user){

        try{
            connection = Controller.pool.takeConnection();
            ps = connection.prepareStatement(INSERT_USER_SQL);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setInt(3, 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException occur", e);
        } catch (ConnectionPoolException e) {
            LOGGER.log(Level.SEVERE, "ConnectionPoolException occur", e);
        }
        finally {
            Controller.pool.closeConnection(connection,ps,rs);
        }

    }

    @Override
    public User findByEmail(String email){
        User user = null;
        try {
                connection = Controller.pool.takeConnection();
                ps = connection.prepareStatement(SELECT_USER_BY_EMAIL);
                ps.setString(1, email);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String password = rs.getString(RequestParameter.PASSWORD);
                    user = new User(email, password);
                }

        } catch (ConnectionPoolException e) {
            LOGGER.log(Level.SEVERE, "ConnectionPoolException occur", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException occur", e);
        } finally {
            Controller.pool.closeConnection(connection,ps,rs);
        }
        return user;
    }
}
