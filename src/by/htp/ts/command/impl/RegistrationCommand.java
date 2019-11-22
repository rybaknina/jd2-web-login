package by.htp.ts.command.impl;

import by.htp.ts.bean.User;
import by.htp.ts.command.Command;
import by.htp.ts.dao.DAOException;
import by.htp.ts.service.ServiceProvider;
import by.htp.ts.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class.getName());
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter(RequestParameter.EMAIL);
		String password = request.getParameter(RequestParameter.PASSWORD);
		String name = request.getParameter(RequestParameter.NAME);
		String lastName = request.getParameter(RequestParameter.LAST_NAME);
		String birthday = request.getParameter(RequestParameter.BIRTHDAY);
		int role_id = Integer.parseInt(request.getParameter(RequestParameter.ROLE));


      //  User user = new User(email, password, name, lastName, birthday, role_id);
        User user = new User(email, password,role_id);

        ServiceProvider provider = ServiceProvider.getInstance();
        UserServiceImpl userService = provider.getUserService();
        try {
            userService.save(user);
        } catch (DAOException e) {
            LOGGER.log(Level.SEVERE, "DAOException occur", e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(RequestParameter.REGISTRATION_VIEW);
		dispatcher.forward(request, response);

	}
}
