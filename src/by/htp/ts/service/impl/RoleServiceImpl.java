package by.htp.ts.service.impl;

import by.htp.ts.dao.DAOFactory;
import by.htp.ts.dao.RoleDAO;
import by.htp.ts.service.RoleService;

public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO = DAOFactory.getInstance().getRoleDAO();

    @Override
    public int findRoleId() {
        return roleDAO.findRoleId();
    }
}
