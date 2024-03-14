package com.blog.blogappapis.payloads;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UserDto {

    private int id;
    @NotEmpty
    @Size(min = 4,message = "username must be min 4 characters")
    private String name;
    @Email(message = "Email address is not valid!!")
    private String email;
    @NotEmpty
    @Size(min = 3,max = 10,message = "password must be minimum of 3 chars and max of 10 chars!!")

    private String password;
    @NotEmpty
    private String about;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAbout() {
        return about;
    }

    public UserDto() {
    }
}
