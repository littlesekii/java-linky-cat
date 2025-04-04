package cat.linky.api.core.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.linky.api.core.model.Link;

@Repository
public interface ILinkRepository extends JpaRepository<Link, UUID> {
    
}
