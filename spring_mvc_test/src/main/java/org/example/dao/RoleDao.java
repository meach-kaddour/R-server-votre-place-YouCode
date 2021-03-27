package org.example.dao;

import org.example.entities.Roles;
import java.sql.SQLException;
import java.util.List;

public interface RoleDao {
    public  void createRole(Roles role)throws ClassNotFoundException, SQLException;
    public Roles getRoleById(long id)throws ClassNotFoundException, SQLException;
    public List<Roles> getAllRoles()throws ClassNotFoundException, SQLException;
    public void dropRole(long id)throws ClassNotFoundException, SQLException;
    public Roles updateRole(Roles role)throws ClassNotFoundException, SQLException;
}
