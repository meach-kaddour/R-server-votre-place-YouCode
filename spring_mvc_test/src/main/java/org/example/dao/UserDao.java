package org.example.dao;

import org.example.entities.Users;

import java.sql.SQLException;
import java.util.List;

public interface UserDao{

    public  void createUser(Users user)throws ClassNotFoundException, SQLException;
    public Users getUserById(Long id)throws ClassNotFoundException, SQLException;
    public List<Users> getAllUsers()throws ClassNotFoundException, SQLException;
    public void dropUser(long id)throws ClassNotFoundException, SQLException;
    public Users updateUser(Users user)throws ClassNotFoundException, SQLException;
}
