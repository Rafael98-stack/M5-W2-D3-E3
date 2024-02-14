package it.be.epicode.EsercizioTre.Services;

import it.be.epicode.EsercizioTre.Entities.blogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutorsBlogsService {
    private  List<blogPost> blogPosts = new ArrayList<>();

    public List<blogPost> getBlog() {
        return this.blogPosts;
    }

    public blogPost saveBlogs(blogPost newBlog) {
        Random rndm = new Random();
        this.blogPosts.add(newBlog);
        return newBlog;
    }
}
