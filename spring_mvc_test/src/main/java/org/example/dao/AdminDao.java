package org.example.dao;

import org.example.entities.Administrator;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    public  void createAdministrator(Administrator admin)throws ClassNotFoundException, SQLException;
    public Administrator getAdministratorById(long id)throws ClassNotFoundException, SQLException;
    public List<Administrator> getAllAdministrators()throws ClassNotFoundException, SQLException;
    public void dropAdministrator(long id)throws ClassNotFoundException, SQLException;
    public Administrator updateAdministrator(Administrator admin)throws ClassNotFoundException, SQLException;
}
