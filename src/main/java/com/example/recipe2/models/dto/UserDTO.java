package com.example.recipe2.models.dto;

import com.example.recipe2.models.entity.UserModel;
import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String login;
    private String password;
    private String photo;
    private String email;
    private int weight;
    private int height;
    private int age;
    private String gender;
    private String activityType;
    private String name;
    private String lastName;
    private String dataOfRegistration;

    public UserDTO(UserModel user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.photo = user.getPhoto();
        this.email = user.getEmail();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.activityType = user.getActivityType();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.dataOfRegistration = user.getDataOfRegistration();
    }
}
