package cat.linky.api.core.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.linky.api.core.model.User;

public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
