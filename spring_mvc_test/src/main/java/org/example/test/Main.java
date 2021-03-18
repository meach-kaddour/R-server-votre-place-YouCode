package org.example.test;

import org.example.dao.*;
import org.example.entities.Roles;
import org.example.entities.Student;
import org.example.entities.Users;
import org.example.services.UserService;
import org.example.services.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       // RoleDao d=new RoleDaoImpl();
        //Roles role=d.getRoleById(1L);


        UserDao user = new UserDaoImpl();
        //List<Users> list=user.getAllUsers();
        System.out.println(user.getAllUsers());

        //user.createUser(new Users("hh","kk","hhh","jjj",role));


       // Users user1 = user.getUserById(1L);
        //System.out.println(user1.toString());*/
        //StudentDao student=new StudentDaoImpl();
        //student.createStudent(new Student("hhh","vvvv","hhhh","ddd",role,"0"));

        UserService ser=new UserServiceImpl();
        System.out.println(ser.validate("kaddourpro93@gmail.com","pepe"));
      //ser.validate("kaddourpro93@gmail.com","pepe");


    }

}

