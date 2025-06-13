package cat.linky.api.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cat.linky.api.core.model.Link;
import cat.linky.api.core.model.dto.LinkDTO;
import cat.linky.api.core.service.LinkService;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/link")
public class LinkController {
    
    private LinkService service;

    public LinkController(LinkService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<Link>> findAll() {
        List<Link> res = service.findAll();

        if (res == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/")
    public ResponseEntity<Link> insert(@RequestBody LinkDTO req) {
        Link res = service.insert(req);

        if (res == null)
            return ResponseEntity.badRequest().build();

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(res.getId())
            .toUri();

        return ResponseEntity.created(uri).body(res);
    }
    
}
