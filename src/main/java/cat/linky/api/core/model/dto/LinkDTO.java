package cat.linky.api.core.model.dto;

import cat.linky.api.core.model.Link;
import cat.linky.api.core.model.User;

public record LinkDTO(String title, String url, User user) {

    public Link toEntity() {
        return new Link(null, title, url, user);
    }
}
