package by.htp.ts.service;

import by.htp.ts.bean.User;
import by.htp.ts.dao.DAOException;

public interface UserService {
    void save(User user) throws DAOException;
    User findByEmail(String email) throws DAOException;
}
