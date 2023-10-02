package com.example.uek295_backeend.service.implementation;

import com.example.uek295_backeend.entity.User;
import com.example.uek295_backeend.repository.UserRepository;
import com.example.uek295_backeend.service.UserService;
import com.example.uek295_backeend.service.dtos.UserDTO;
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
    public User create(User user) {
        return null;
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDto(savedUser);
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
        return  userList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO update(Long id, UserDTO userDtoToUpdate) {
        User existingUser = userRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("User with the " + id + " not found"));
        User userToUpdate = convertToEntity(userDtoToUpdate);
        existingUser.setName(userToUpdate.getName());
        existingUser.setDescription(userToUpdate.getDescription());
        existingUser.setUserId(userToUpdate.getUserId());
        existingUser.setImage(userToUpdate.getImage());
        existingUser.setChannelId(userToUpdate.getChannelId());
        existingUser.setActive(userToUpdate.getActive());
        existingUser.setPassword(userToUpdate.getPassword());
        existingUser.setProductId(userToUpdate.getProductId());

        User updatedUser = userRepository.save(existingUser);
        return convertToDto(updatedUser);
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
    public User convertToEntity(UserDTO userDto) {
        return UserService.super.convertToEntity(userDto);
    }
}
