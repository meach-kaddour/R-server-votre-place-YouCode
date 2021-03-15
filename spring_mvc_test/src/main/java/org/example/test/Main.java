package org.example.test;

import org.example.Repository.UserRepositoryDao;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.entities.Users;

public class Main {
    public static void main(String[] args) {
        UserDao user = new UserDaoImpl();
        Users user1 = user.getUserById(1);
        System.out.println(user1.toString());
    }
}

