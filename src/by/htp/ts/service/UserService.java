package by.htp.ts.service;

import by.htp.ts.been.User;

public interface UserService {
    void save(User user);
    User findByEmail(String email);
}
