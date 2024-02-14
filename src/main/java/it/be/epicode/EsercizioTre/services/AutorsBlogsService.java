package it.be.epicode.EsercizioTre.Services;

import it.be.epicode.EsercizioTre.Entities.BlogPost;
//import it.be.epicode.EsercizioTre.Repositories.BlogPostDAO;
import it.be.epicode.EsercizioTre.Repositories.BlogPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutorsBlogsService {
    @Autowired
    private BlogPostDAO blogPostDAO;
    private  List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getBlogs() {
        return this.blogPostDAO.findAll();
    }

    public BlogPost saveBlogs(BlogPost newBlog) {
        Random rndm = new Random();
newBlog.setId(rndm.nextInt(1,100000));
        this.blogPosts.add(newBlog);
        this.blogPostDAO.save(newBlog);
        return newBlog;
    }
}
