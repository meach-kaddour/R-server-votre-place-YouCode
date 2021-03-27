package org.example.services;


import org.example.entities.Roles;
import org.example.entities.Users;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public List<Users> findAll() throws ClassNotFoundException, SQLException;
    public Users findById(Long id) throws ClassNotFoundException, SQLException;
    public void save(Users user) throws ClassNotFoundException, SQLException;
    public void delete(Long id) throws ClassNotFoundException, SQLException;

    public boolean validate(String email,String password) throws ClassNotFoundException, SQLException;
    public Roles getByRole(Long id) throws ClassNotFoundException, SQLException;

    public Users getByEmail(String email) throws ClassNotFoundException, SQLException;
}
