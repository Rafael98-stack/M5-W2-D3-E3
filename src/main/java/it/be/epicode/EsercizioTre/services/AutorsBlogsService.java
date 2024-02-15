package it.be.epicode.EsercizioTre.Services;

import it.be.epicode.EsercizioTre.Entities.Autore;
import it.be.epicode.EsercizioTre.Entities.BlogPost;
//import it.be.epicode.EsercizioTre.Repositories.BlogPostDAO;
import it.be.epicode.EsercizioTre.Exeptions.BadRequestExeption;
import it.be.epicode.EsercizioTre.Exeptions.NotFoundExeption;
import it.be.epicode.EsercizioTre.PayLoad.BlogPostPayLoad;
import it.be.epicode.EsercizioTre.Repositories.AutoreDAO;
import it.be.epicode.EsercizioTre.Repositories.BlogPostDAO;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutorsBlogsService {
    @Autowired
    private BlogPostDAO blogPostDAO;
    @Autowired
    private AutoreDAO autoreDAO;
    private  List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getBlogs() {
        return this.blogPostDAO.findAll();
    }

    public BlogPost saveBlogs(BlogPostPayLoad body) {
        Autore author = findById(body.getAuthorId());
        BlogPost newBlogPost = new BlogPost();
        newBlogPost.setTempoDiLettura(body.getReadingTime());
        newBlogPost.setContenuto(body.getContent());
        newBlogPost.setTitolo(body.getTitle());
        newBlogPost.setAutore(author);
        newBlogPost.setCategoria(body.getCategory());
        newBlogPost.setCover("http://picsum.photos/200/300");
        return blogPostDAO.save(newBlogPost);
    }

    ////////////////////////AUTORS SERVICE //////////////////////////////

    public Autore findById(int id) {
        return autoreDAO.findById(id).orElseThrow(() -> new NotFoundExeption(id));
    }

    public Autore saveAutore(Autore body) {
        autoreDAO.findByEmail(body.getEmail()).ifPresent(user -> {
            throw new BadRequestExeption("L'email " + body.getEmail() + " è già stata utilizzata");
        });
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome().charAt(0) + "+" + body.getCognome().charAt(0));
        return autoreDAO.save(body);
    }

    public Page<Autore> getAuthors(int page, int size, String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return autoreDAO.findAll(pageable);
    }
}
