package cat.linky.api.core.model.dto;

import cat.linky.api.core.model.User;

public record UserDTO(String username, String email, String name) {
    
    public User toEntity() {
        return new User(username, email, name);
    }
}
