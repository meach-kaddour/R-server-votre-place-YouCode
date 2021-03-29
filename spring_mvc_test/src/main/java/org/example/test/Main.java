package org.example.test;

import org.example.dao.*;
import org.example.entities.*;
import org.example.services.UserService;
import org.example.services.UserServiceImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       //RoleDao d=new RoleDaoImpl();
       // Roles role=d.getRoleById(1L);

       // UserService u=new UserServiceImpl();
        //u.validate("kaddour@gmail.com","admin");
        //u.findAll();
        //Test Dao
//DAO_USER
       UserDao user = new UserDaoImpl();
       List<Users> list=user.getAllUsers();
       System.out.println("ww  :"+list);
        //user.createUser(new Users("kamal","kamil","kaddour","howa",null ,null,null));

        //user.updateUser(new Users(1L,"jamil","jamal","jamal","howa",null ,null,null));

       //Users user1 = user.getUserById(1L);
        //System.out.println(user1.toString());
        //user.dropUser(19L);


 ///DAO_STUDENT
        //StudentDao student=new StudentDaoImpl();
        //student.createStudent(new Student("ilyass","chakir","gmail","root",null,null,null,null,false));

        /*  student.getStudentById(2L);
        Student user1 = student.getStudentById(2L);
        System.out.println(user1.toString());*/

        //System.out.println(student.getAllStudents());
        //student.dropStudent(2L);

 //DAO_Reservation

        /*StudentDao student=new StudentDaoImpl();*/
       //ReservationDao r=new ReservationDaoImpl();
        //Student stu=student.getStudentById(4L);
        //Date dt=new Date();
        //TypeReservation tR=new TypeReservation("week",30);
        //r.createReservation(new Reservation(stu,dt,false,tR));
        //System.out.println(r.getAllReservations());
        //r.getReservationById(8L);
        //r.updateReservation(r.getReservationById(8L));
        //r.dropReservation(8L);

//Dao admin
     //AdminDao user = new AdminDaoImpl();
        //List<Administrator> list=user.getAllAdministrators();
        //System.out.println("ww  :"+list);
       //user.createAdministrator(new Administrator("kamal","kamil","kaddour@gmail.com","admin",null ,null,null));

        //user.updateAdministrator(new Administrator("jamil","jamal","jamal","howa",null ,null,null));

        //Administrator user1 = user.getAdministratorById(10L);
        //System.out.println(user1.toString());
        //user.dropUser(1L);*/


    }

}

