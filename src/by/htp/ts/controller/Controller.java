package by.htp.ts.controller;

import _java._se._07_connectionpool.ConnectionPool.ConnectionPool;
import by.htp.ts.command.Command;
import by.htp.ts.command.CommandProvider;
import by.htp.ts.command.impl.RequestParameter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String COMMAND_NAME = "command";
    private static ConnectionPool pool;
    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        pool = ConnectionPool.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Command command;

        String commandName = request.getParameter(COMMAND_NAME);
        command = provider.getCommand(commandName);

        command.execute(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        pool.dispose();
    }
}
