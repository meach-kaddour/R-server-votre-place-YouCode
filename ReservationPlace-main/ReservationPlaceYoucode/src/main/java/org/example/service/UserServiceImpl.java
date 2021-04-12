package org.example.service;

import org.example.DAO.UserDAO;
import org.example.Entity.UseradminEntity;
import org.example.Repostory.LoginRepostory;
import org.example.Repostory.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Component("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("userDao")
    private UserDAO userDAO;

    LoginRepostory loginRepostory = new LoginRepostory();
    UserRepostory UserRepostory=new UserRepostory();

    @Override
    @Transactional
    public void addUser(UseradminEntity user) {

        userDAO.createUser(user);

    }

    @Override
    @Transactional
    public UseradminEntity getUserById(int id) {

      return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public List<UseradminEntity> getAllUsers() {

        return  userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void deleteUser(int id) {

        userDAO.deleteUser(id);

    }

    @Override
    @Transactional
    public UseradminEntity updateUser(UseradminEntity user) {

       return  userDAO.updateUser(user);
    }

	@Override
	@Transactional
	public UseradminEntity getUserByEmail(String email) {
		return loginRepostory.getUserByEmail(email);
	}
	
	@Override
	@Transactional
	public UseradminEntity setAcceptation(UseradminEntity user) {
		return  UserRepostory.updateUserAccpect(user);
	}
}
