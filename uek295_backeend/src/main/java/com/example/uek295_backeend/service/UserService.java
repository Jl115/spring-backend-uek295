package com.example.uek295_backeend.service;

import com.example.uek295_backeend.entity.User;
import com.example.uek295_backeend.service.dtos.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User create(User user);

    UserDTO getById(Long id);

    List<UserDTO> getAll();

    UserDTO update(Long id, UserDTO userDTO);

    void delete(Long id);

    default UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setDescription(user.getDescription());
        userDTO.setActive(user.getActive());
        userDTO.setImage(user.getImage());
        return userDTO;
    }

    default User convertToEntity(UserDTO userDTO) {
        User user = new  User();
        if (userDTO.getUserId() != null) {
            user.setUserId(user.getProductId());
        }
        user.setName(userDTO.getName());
        user.setDescription(userDTO.getDescription());
        user.setActive(userDTO.getActive());
        user.setImage(userDTO.getImage());
        return user;
    }
}
