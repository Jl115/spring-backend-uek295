package com.example.uek295_backeend.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing users.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Retrieves all users with the given name.
     *
     * @param name The name of the user.
     * @return An optional containing the user, if found.
     */
    Optional<User> findAllByName(String name);

    /**
     * Retrieves a user by its name.
     *
     * @param name The name of the user.
     * @return An optional containing the user, if found.
     */
    Optional<User> findByName(String name);

}
