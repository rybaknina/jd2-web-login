package by.htp.ts.controller;

import by.htp.ts._java._se_07_connectionpool.connectionpool.ConnectionPool;
import by.htp.ts._java._se_07_connectionpool.connectionpool.ConnectionPoolException;
import by.htp.ts.command.Command;
import by.htp.ts.command.CommandProvider;
import by.htp.ts.dao.DAOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());
    private static final long serialVersionUID = 1L;
    private static final String COMMAND_NAME = "command";
    public static ConnectionPool pool;
    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        pool = ConnectionPool.getConnectionPool();
        try {
            pool.initPoolData();
        } catch (ConnectionPoolException e) {
            LOGGER.log(Level.SEVERE,"Error init the connection.", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Command command;

        String commandName = request.getParameter(COMMAND_NAME);
        command = provider.getCommand(commandName);

        try {
            command.execute(request, response);
        } catch (DAOException e) {
            LOGGER.log(Level.SEVERE, "DAOException occur", e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        pool.dispose();
    }
}
