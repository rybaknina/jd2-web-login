package by.htp.ts.dao.impl;

import by.htp.ts.bean.User;
import by.htp.ts.command.impl.RequestParameter;
import by.htp.ts.controller.Controller;
import by.htp.ts.dao.UserDAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlUserDAO implements UserDAO {
    private static final Logger LOGGER = Logger.getLogger(SqlUserDAO.class.getName());

    private static final String INSERT_USER_SQL = "INSERT INTO user" + "  (email, password, name,lastname,birthday, role_id) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    private static final String INSERT_USER_SQL2 = "INSERT INTO user" + "  (email, password, role_id) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_USER_BY_EMAIL = "select email, password from user where email =?";


    @Override
    public void save(User user){
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = Controller.pool.takeConnection();
            ps = connection.prepareStatement(INSERT_USER_SQL);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getLastname());
            ps.setObject(5, user.getBirthday());
            ps.setInt(6, 1);
            if(ps.executeUpdate() == 0) {
//???
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException occur", e);
        } catch (ConnectionPoolException e) {
            LOGGER.log(Level.SEVERE, "ConnectionPoolException occur", e);
        }
        finally {
            Controller.pool.closeConnection(connection,ps);
        }

    }

    @Override
    public User findByEmail(String email){
        User user = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
                connection = Controller.pool.takeConnection();
                ps = connection.prepareStatement(SELECT_USER_BY_EMAIL);
                ps.setString(1, email);
                rs = ps.executeQuery();
                if (rs.next()) {
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
