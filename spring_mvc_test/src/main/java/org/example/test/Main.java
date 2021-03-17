package org.example.test;

import org.example.dao.*;
import org.example.entities.Roles;
import org.example.entities.Student;
import org.example.entities.Users;

public class Main {
    public static void main(String[] args) {
        RoleDao d=new RoleDaoImpl();
        Roles role=d.getRoleById(1L);


       /* UserDao user = new UserDaoImpl();
        user.createUser(new Users("hh","kk","hhh","jjj",role));


        Users user1 = user.getUserById(1L);
        System.out.println(user1.toString());*/
        //StudentDao student=new StudentDaoImpl();
        //student.createStudent(new Student("hhh","vvvv","hhhh","ddd",role,"0"));


    }

}

