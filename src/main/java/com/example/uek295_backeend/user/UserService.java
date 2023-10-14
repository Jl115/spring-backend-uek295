package com.example.uek295_backeend.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserAuthDTO create(UserAuthDTO userAuthDTO);

    UserDTO getById(Long id);

    List<UserDTO> getAll();

    UserDTO update(Long id, UserDTO userDTO);

    UserAuthDTO update(Long id, UserAuthDTO userAuthDTO);

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

    default UserAuthDTO convertToAuthDto(User user) {
        UserAuthDTO userAuthDTO = new UserAuthDTO();
        userAuthDTO.setUserId(user.getUserId());
        userAuthDTO.setName(user.getName());
        userAuthDTO.setDescription(user.getDescription());
        userAuthDTO.setActive(user.getActive());
        userAuthDTO.setImage(user.getImage());
        return userAuthDTO;
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
