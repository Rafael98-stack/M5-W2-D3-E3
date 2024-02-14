package it.be.epicode.EsercizioTre.Repositories;

import it.be.epicode.EsercizioTre.Entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  BlogPostDAO extends JpaRepository<BlogPost, Integer> {
    @Override
    Optional<BlogPost> findById(Integer integer);
}
