package org.example.dao;

import org.example.entities.Roles;

import java.util.List;

public interface RoleDao {
    public  void addRole(Roles role);
    public Roles getRoleById(Long id);
    public List<Roles> getAllRoles();
    public void deleteRole(Long id);
    public Roles updateRole(Roles role);
}
