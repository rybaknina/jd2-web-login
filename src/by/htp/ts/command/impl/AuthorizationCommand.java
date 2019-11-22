package by.htp.ts.command.impl;


import by.htp.ts.bean.User;
import by.htp.ts.command.Command;
import by.htp.ts.dao.DAOException;
import by.htp.ts.service.RoleService;
import by.htp.ts.service.ServiceProvider;
import by.htp.ts.service.UserService;
import com.mysql.jdbc.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthorizationCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(AuthorizationCommand.class.getName());
    ServiceProvider provider = ServiceProvider.getInstance();
    UserService userService = provider.getUserService();
    //RoleService roleService = provider.getRoleService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {

        String email;
        String password;

        email = request.getParameter(RequestParameter.EMAIL);
        password = request.getParameter(RequestParameter.PASSWORD);
        int role_id = 1;
        User user = userService.findByEmail(email);

        if (user != null) {
            request.setAttribute("errMessage", "User already exist");
        }
        else {
            if (StringUtils.isNullOrEmpty(email) || StringUtils.isNullOrEmpty(password)){
                request.setAttribute("errMessage", "Enter email and password, please");
            }
            else {
                user = new User(email, password, role_id);
                userService.save(user);
            }
        }

        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(RequestParameter.MAIN_VIEW);
        requestDispatcher.forward(request, response);

    }
}
