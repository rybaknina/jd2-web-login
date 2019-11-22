package by.htp.ts.dao;

import by.htp.ts.dao.impl.SqlRoleDAO;
import by.htp.ts.dao.impl.SqlUserDAO;

public class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();
    private final UserDAO sqlUserDAO = new SqlUserDAO();
    private final RoleDAO sqlRoleDAO = new SqlRoleDAO();
    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }
    public UserDAO getUserDAO() {
        return sqlUserDAO;
    }
    public RoleDAO getRoleDAO(){
        return sqlRoleDAO;
    }
}
