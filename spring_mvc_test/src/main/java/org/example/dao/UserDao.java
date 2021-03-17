package org.example.dao;

import org.example.entities.Users;

import java.util.List;

public interface UserDao {
    public  void createUser(Users user);
    public Users getUserById(Long id);
    public List<Users> getAllUsers();
    public void dropUser(Long id);
    public Users updateUser(Users user);
}
