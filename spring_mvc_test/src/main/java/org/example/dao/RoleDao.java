package org.example.dao;

import org.example.entities.Roles;

import java.util.List;

public interface RoleDao {
    public  void addRole(Roles role);
    public Roles getRoleById(int id);
    public List<Roles> getAllRoles();
    public void deleteRole(int id);
    public Roles updateRole(Roles role);
}
