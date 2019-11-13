package by.htp.ts.dao;

import by.htp.ts.been.User;

public interface UserDAO {
    void save(User user);
    User findByEmail(String email);
}
