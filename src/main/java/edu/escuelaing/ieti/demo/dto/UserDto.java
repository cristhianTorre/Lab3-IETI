package edu.escuelaing.ieti.demo.dto;

public class UserDto {
    private String name;
    private String password;
    private String email;
    private String lastName;

    public UserDto(String name, String email, String lastName){
        this.name = name;
        this.email = email;
        this.lastName = lastName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
