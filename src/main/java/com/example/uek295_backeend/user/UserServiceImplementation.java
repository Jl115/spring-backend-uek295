package com.example.uek295_backeend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserAuthDTO create(UserAuthDTO userAuthDTO) {
        User user = convertToEntity(userAuthDTO);
        User savedUser = userRepository.save(user);
        return convertToAuthDto(savedUser);
    }


    @Override
    public UserDTO getById(Long id) {
        User user = userRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("User with the " + id + " not found"));
        return convertToDto(user);
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    @Override
    public void promoteToAdmin(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setAdmin(true);
            userRepository.save(user);
        }
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("User with the " + id + " not found"));
        User userToUpdate = convertToEntity(userDTO);
        existingUser.setName(userToUpdate.getName());
        existingUser.setDescription(userToUpdate.getDescription());
        //existingUser.setUserId(userToUpdate.getUserId());
        existingUser.setImage(userToUpdate.getImage());
        existingUser.setChannelId(userToUpdate.getChannelId());
        existingUser.setActive(userToUpdate.getActive());
        if (userToUpdate.getPassword() != null && !userToUpdate.getPassword().isEmpty()) {
            existingUser.setPassword(userToUpdate.getPassword());
        }
        //existingUser.setProductId(userToUpdate.getProductId());
        User updatedUser = userRepository.save(existingUser);
        return convertToDto(updatedUser);
    }

    @Override
    public UserAuthDTO update(Long id, UserAuthDTO userAuthDTO) {
        User existingUser = userRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("User with the " + id + " not found"));
        User userToUpdate = convertToEntity(userAuthDTO);
        existingUser.setName(userToUpdate.getName());
        existingUser.setDescription(userToUpdate.getDescription());
        //existingUser.setUserId(userToUpdate.getUserId());
        existingUser.setImage(userToUpdate.getImage());
        existingUser.setChannelId(userToUpdate.getChannelId());
        existingUser.setActive(userToUpdate.getActive());
        existingUser.setAdmin(userToUpdate.getAdmin());
        if (userToUpdate.getPassword() != null && !userToUpdate.getPassword().isEmpty()) {
            existingUser.setPassword(userToUpdate.getPassword());
        }
        //existingUser.setProductId(userToUpdate.getProductId());
        User updatedUser = userRepository.save(existingUser);
        return convertToAuthDto(updatedUser);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id.intValue())) {
            throw new ResourceNotFoundException("User with the " + id + " not found");
        }
        userRepository.deleteById(id.intValue());
    }

    @Override
    public UserDTO convertToDto(User user) {
        return UserService.super.convertToDto(user);
    }

    @Override
    public UserAuthDTO convertToAuthDto(User user) {
        return UserService.super.convertToAuthDto(user);
    }


    @Override
    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        if (userDTO.getUserId() != null) {
            user.setUserId(userDTO.getUserId());
        }
        user.setName(userDTO.getName());
        user.setDescription(userDTO.getDescription());
        user.setActive(userDTO.getActive());
        user.setImage(userDTO.getImage());
        return user;
    }
}
