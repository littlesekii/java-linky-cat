package cat.linky.api.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cat.linky.api.core.model.Link;
import cat.linky.api.core.model.dto.LinkDTO;
import cat.linky.api.core.repository.ILinkRepository;

@Service
public class LinkService {
    
    private final ILinkRepository repository;

    public LinkService(ILinkRepository repository) {
        this.repository = repository;
    }

    public List<Link> findAll() {
        return repository.findAll();
    }

    public Link insert(LinkDTO dto) {
       return repository.save(dto.toEntity());
    }
  
}
