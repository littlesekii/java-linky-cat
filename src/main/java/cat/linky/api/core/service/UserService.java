package cat.linky.api.core.service;

import org.springframework.stereotype.Service;

import cat.linky.api.core.model.User;
import cat.linky.api.core.model.dto.UserDTO;
import cat.linky.api.core.repository.IUserRepository;

@Service
public class UserService {
    
    private IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    public User findByUserName(String username) {
        return repository.findByUsername(username);
    }

    public User insert(UserDTO dto) {
       return repository.save(dto.toEntity());
    }
  
}
