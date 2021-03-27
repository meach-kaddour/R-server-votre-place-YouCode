package org.example.dao;

import org.example.entities.SignUp;

import java.sql.SQLException;
import java.util.List;

public interface SignUpDao {
    public  void createSignUp(SignUp signUp)throws ClassNotFoundException, SQLException;
    public SignUp getSignUpById(long id)throws ClassNotFoundException, SQLException;
    public List<SignUp> getAllSignUp()throws ClassNotFoundException, SQLException;
    public void dropSignUp(long id)throws ClassNotFoundException, SQLException;
    public SignUp  updateSignUp(SignUp SignUp)throws ClassNotFoundException, SQLException;
}
