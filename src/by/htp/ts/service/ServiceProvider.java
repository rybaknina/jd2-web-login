package by.htp.ts.service;

import by.htp.ts.service.impl.RoleServiceImpl;
import by.htp.ts.service.impl.UserServiceImpl;

public class ServiceProvider {
    private final static ServiceProvider INSTANCE = new ServiceProvider();
    private final UserServiceImpl userService = new UserServiceImpl();
    private final RoleServiceImpl roleService = new RoleServiceImpl();

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return INSTANCE;
    }

    public UserServiceImpl getUserService() {
        return INSTANCE.userService;
    }
    public RoleServiceImpl getRoleService(){
        return INSTANCE.roleService;
    }

}
