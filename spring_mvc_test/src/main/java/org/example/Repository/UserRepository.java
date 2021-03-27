package org.example.Repository;

import org.example.entities.Roles;
import org.example.entities.Users;

public interface UserRepository {
    public boolean validate(String email,  String password);
    public Roles getByRole(Long id);
    public Users getByEmail(String email);


}
