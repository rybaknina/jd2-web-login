package by.htp.ts.dao.impl;

import by.htp.ts._java._se_07_connectionpool.connectionpool.ConnectionPoolException;
import by.htp.ts.bean.UserRole;
import by.htp.ts.command.impl.RequestParameter;
import by.htp.ts.controller.Controller;
import by.htp.ts.dao.RoleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlRoleDAO implements RoleDAO {
    private static final Logger LOGGER = Logger.getLogger(SqlRoleDAO.class.getName());
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private static final String SELECT_ROLE_ID = "select role_id from role where title = ?";

    @Override
    public int findRoleId() {
        int role_id=0;
        try {
            connection = Controller.pool.takeConnection();
            ps = connection.prepareStatement(SELECT_ROLE_ID);
            ps.setString(1, String.valueOf(UserRole.USER));
            rs = ps.executeQuery();
            while (rs.next()) {
                role_id = rs.getInt(rs.getString(RequestParameter.ROLE));
            }

        } catch (ConnectionPoolException e) {
            LOGGER.log(Level.SEVERE, "ConnectionPoolException occur", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException occur", e);
        } finally {
            Controller.pool.closeConnection(connection,ps,rs);
        }
        return role_id;
    }
}
