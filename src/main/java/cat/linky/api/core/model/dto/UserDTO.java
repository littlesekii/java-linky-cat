package cat.linky.api.core.model.dto;

import cat.linky.api.core.model.User;

public record UserDTO(String username, String name) {
    
    public User toEntity() {
        return new User(null, username, name);
    }
}
