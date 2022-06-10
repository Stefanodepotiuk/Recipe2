package com.example.recipe2.services;

import com.example.recipe2.dao.UserDAO;
import com.example.recipe2.models.dto.UserDTO;
import com.example.recipe2.models.entity.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserDAO userDAO;

    public List<UserDTO> getAll() {
        List<UserModel> user = userDAO.findAll();
        return user.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO getById(int id) {
        UserModel user = userDAO.findById(id).orElse(new UserModel());
        return new UserDTO(user);
    }

    public UserDTO createUser(UserModel user) {
        UserModel saveUser = userDAO.save(user);
        return new UserDTO(saveUser);
    }

    public UserDTO upDateUser(int id, UserModel user) {
        user.setId(id);
        UserModel saveUser = userDAO.save(user);
        return new UserDTO(saveUser);
    }

    public List<UserDTO> deleteUser(int id) {
        userDAO.deleteById(id);
        List<UserModel> all = userDAO.findAll();
        return all.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
