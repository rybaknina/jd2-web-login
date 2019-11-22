package by.htp.ts.dao;

import by.htp.ts.bean.User;

public interface UserDAO {
    void save(User user) throws DAOException;
    User findByEmail(String email) throws DAOException;
}
