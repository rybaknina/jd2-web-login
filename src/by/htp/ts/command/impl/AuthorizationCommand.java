package by.htp.ts.command.impl;


import by.htp.ts.bean.User;
import by.htp.ts.command.Command;
import by.htp.ts.dao.DAOException;
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
    private ServiceProvider provider = ServiceProvider.getInstance();
    private UserService userService = provider.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {

        String email = request.getParameter(RequestParameter.EMAIL);;

        User user = userService.findByEmail(email);

        if (user == null) {
            request.setAttribute("errMessage", "You are not in the Test-System.");
        }

        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(RequestParameter.MAIN_VIEW);
        requestDispatcher.forward(request, response);

    }
}
