package by.htp.ts.service;

import by.htp.ts.been.User;
import by.htp.ts.dao.SqlUserDAO;
import by.htp.ts.dao.UserDAO;

public class UserServiceImpl implements UserService{
private UserDAO userDAO = new SqlUserDAO();
    @Override
    public void save(User user) {
        this.userDAO.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return this.userDAO.findByEmail(email);
    }
}
