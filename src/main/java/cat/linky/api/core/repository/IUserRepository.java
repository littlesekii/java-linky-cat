package cat.linky.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.linky.api.core.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
