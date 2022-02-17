package edu.escuelaing.ieti.demo.data;

import edu.escuelaing.ieti.demo.controller.RoleEnum;
import edu.escuelaing.ieti.demo.dto.UserDto;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;

@Document
public class User {
    @Id
    private String id;
    private String name;
    @Indexed( unique = true)
    private String email;
    private String lastName;
    private String createdAt;
    private String passwordHash;
    private List<RoleEnum> roles;

    public User(String id, String name, String email, String lastName, String createdAt, UserDto userDto){
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
    }

    public User(UserDto userDto){
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    public void update(UserDto user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
        if (user.getPassword() != null) {
            this.passwordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        }
    }
}
