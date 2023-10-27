package com.example.uek295_backeend.user;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for managing users.
 */
@Service
public interface UserService {

    /**
     * Creates a new user using the provided DTO.
     *
     * @param userAuthDTO The DTO containing user details.
     * @return The created user's auth DTO.
     */
    UserAuthDTO create(UserAuthDTO userAuthDTO);

    /**
     * Retrieves a user by its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user DTO.
     */
    UserDTO getById(Long id);

    /**
     * Retrieves all users.
     *
     * @return List of user DTOs.
     */
    List<UserDTO> getAll();

    /**
     * Updates a specific user.
     *
     * @param id The ID of the user to update.
     * @param userDTO The updated user details.
     * @return The updated user DTO.
     */
    UserDTO update(Long id, UserDTO userDTO);

    /**
     * Updates a specific user to admin role.
     *
     * @param id The ID of the user to update.
     * @param userAuthDTO The updated user details.
     * @return The updated user's auth DTO.
     */
    UserAuthDTO update(Long id, UserAuthDTO userAuthDTO);

    /**
     * Promotes a user to admin.
     *
     * @param userId The ID of the user to promote.
     */
    void promoteToAdmin(int userId);

    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to delete.
     */
    void delete(Long id);

    /**
     * Converts a User entity to a UserDTO.
     *
     * @param user The user entity.
     * @return The converted UserDTO.
     */
    default UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setDescription(user.getDescription());
        userDTO.setActive(user.getActive());
        userDTO.setImage(user.getImage());
        return userDTO;
    }

    /**
     * Converts a User entity to a UserAuthDTO.
     *
     * @param user The user entity.
     * @return The converted UserAuthDTO.
     */
    default UserAuthDTO convertToAuthDto(User user) {
        UserAuthDTO userAuthDTO = new UserAuthDTO();
        userAuthDTO.setUserId(user.getUserId());
        userAuthDTO.setName(user.getName());
        userAuthDTO.setDescription(user.getDescription());
        userAuthDTO.setActive(user.getActive());
        userAuthDTO.setImage(user.getImage());
        return userAuthDTO;
    }

    /**
     * Converts a UserDTO to a User entity.
     *
     * @param userDTO The user DTO.
     * @return The converted User entity.
     */
    default User convertToEntity(UserDTO userDTO) {
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
