package org.example.services;

import org.example.Repository.UserRepository;
import org.example.Repository.UserRepositoryImpl;
import org.example.dao.UserDao;
import org.example.entities.Roles;
import org.example.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Component("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("UserDao")
    private UserDao userDao ;
    private UserRepository userRepository =new UserRepositoryImpl();
    @Override
    public List<Users> findAll() throws ClassNotFoundException, SQLException {
        return userDao.getAllUsers();
    }

    @Override
    public Users findById(Long id) throws ClassNotFoundException, SQLException {
        return userDao.getUserById(id);
    }

    @Override
    public void save(Users user) throws ClassNotFoundException, SQLException {
        userDao.createUser(user);

    }

    @Override
    public void delete(Long id) throws ClassNotFoundException, SQLException {
    userDao.dropUser(id);
    }

    @Override
    public boolean validate(String email, String password) throws ClassNotFoundException, SQLException {
       return userRepository.validate(email,password);
    }

    @Override
    public Roles getByRole(Long id) throws ClassNotFoundException, SQLException {
        return userRepository.getByRole(id);
    }

    @Override
    public Users getByEmail(String email) throws ClassNotFoundException, SQLException {
        return userRepository.getByEmail(email);
    }


    /*@Autowired
    @Qualifier("UserDao")
    private UserDao userDao ;
    private UserRepository userRepository =new UserRepositoryImpl();



    @Override
    @Transactional
    public List<Users> findAll() throws ClassNotFoundException, SQLException {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public Users findById(Long id) throws ClassNotFoundException, SQLException {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void save(Users user) throws ClassNotFoundException, SQLException {
    userDao.createUser(user);
    }

    @Override
    @Transactional
    public void delete(Long id) throws ClassNotFoundException, SQLException {
    userDao.dropUser(id);
    }

    @Override
    @Transactional
    public boolean validate(String email, String password) throws ClassNotFoundException, SQLException {
        return userRepository.validate(email,password);
    }*/
}
