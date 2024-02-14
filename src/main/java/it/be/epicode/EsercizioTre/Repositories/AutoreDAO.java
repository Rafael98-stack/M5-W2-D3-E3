package it.be.epicode.EsercizioTre.Repositories;

import it.be.epicode.EsercizioTre.Entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoreDAO extends JpaRepository<Autore,Integer> {
    Optional<Autore> findByEmail(String email);
}
