package at.savovuksan.VSMServer.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import at.savovuksan.VSMServer.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
