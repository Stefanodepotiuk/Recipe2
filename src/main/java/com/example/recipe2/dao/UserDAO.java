package com.example.recipe2.dao;

import com.example.recipe2.models.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserModel,Integer> {
}
