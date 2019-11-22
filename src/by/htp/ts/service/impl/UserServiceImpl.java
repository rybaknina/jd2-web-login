package by.htp.ts.service.impl;

import by.htp.ts.bean.User;
import by.htp.ts.dao.DAOException;
import by.htp.ts.dao.DAOFactory;
import by.htp.ts.dao.UserDAO;
import by.htp.ts.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
    @Override
    public void save(User user) throws DAOException {
        this.userDAO.save(user);
    }

    @Override
    public User findByEmail(String email) throws DAOException {
        return this.userDAO.findByEmail(email);
    }
}
