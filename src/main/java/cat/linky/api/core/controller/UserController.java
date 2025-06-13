package cat.linky.api.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cat.linky.api.core.model.User;
import cat.linky.api.core.model.dto.UserDTO;
import cat.linky.api.core.service.UserService;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{req}")
    public ResponseEntity<User> findByUsername(@PathVariable String req) {
        User res = service.findByUsername(req);

        if (res == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/")
    public ResponseEntity<User> insert(@RequestBody UserDTO req) {
        User res = service.insert(req);

        if (res == null)
            return ResponseEntity.badRequest().build();

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(res.getId())
            .toUri();

        return ResponseEntity.created(uri).body(res);
    }
    
}
