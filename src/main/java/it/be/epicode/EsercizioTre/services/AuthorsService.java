package it.be.epicode.EsercizioTre.services;


import it.be.epicode.EsercizioTre.exceptions.*;
import it.be.epicode.EsercizioTre.Entities.Autore;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorsService {

    private final List<Autore> authors = new ArrayList<>();

    public Autore save(Autore author) {
        Random rndm = new Random();
        author.setId(rndm.nextInt(1,100000));
        author.setAvatar("https://ui-avatars.com/api/?name="+ author.getNome() + "+" + author.getCognome());
        this.authors.add(author);
        return author;
    }

    public List<Autore> getAuthors() {
        return this.authors;
    }

    public Autore findById(int id) {
        Autore found = null;

        for (Autore author : authors) {
            if (author.getId() == id)
                found = author;
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        ListIterator<Autore> iterator = this.authors.listIterator();

        while (iterator.hasNext()) {
            Autore currentAuthor = iterator.next();
            if (currentAuthor.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Autore findByIdAndUpdate(int id, Autore author) {
        Autore found = null;

        for (Autore currentAuthor : authors) {
            if (currentAuthor.getId() == id) {
                found = currentAuthor;
                found.setNome(author.getNome());
                found.setCognome(author.getCognome());
                found.setId(id);
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;

    }
}
