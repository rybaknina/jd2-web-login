package by.htp.ts.command.impl;

import by.htp.ts.been.User;
import by.htp.ts.command.Command;
import by.htp.ts.service.UserService;
import by.htp.ts.service.UserServiceImpl;
import com.mysql.jdbc.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationCommand implements Command {
    UserService userService = new UserServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email;
        String password;
        email = request.getParameter(RequestParameter.EMAIL);
        password = request.getParameter(RequestParameter.PASSWORD);

        User user = null;
        user = userService.findByEmail(email);
        if (user != null) {
            request.setAttribute("message", "User already exist");
        }
        else {
            if (StringUtils.isNullOrEmpty(email) || StringUtils.isNullOrEmpty(password)){
                request.setAttribute("message", "Enter email and password, please");
            }
            else {
                user = new User(email, password);
                userService.save(user);
            }
        }

        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
        requestDispatcher.forward(request, response);

    }
}
