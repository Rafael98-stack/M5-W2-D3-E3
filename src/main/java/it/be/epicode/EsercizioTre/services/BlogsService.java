package it.be.epicode.EsercizioTre.services;


import it.be.epicode.EsercizioTre.Entities.BlogPost;
import it.be.epicode.EsercizioTre.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogsService {

    private final List<BlogPost> blogs = new ArrayList<>();

    public BlogPost save(BlogPost blogpost) {
        Random rndm = new Random();
        blogpost.setId(rndm.nextInt());
        blogpost.setCover("https://picsum.photos/200/300");
        this.blogs.add(blogpost);
        return blogpost;
    }

    public List<BlogPost> getBlogs() {
        return this.blogs;
    }

    public BlogPost findById(int id) {
        BlogPost found = null;

        for (BlogPost blogpost : blogs) {
            if (blogpost.getId() == id)
                found = blogpost;
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        ListIterator<BlogPost> iterator = this.blogs.listIterator();

        while (iterator.hasNext()) {
            BlogPost currentBlog = iterator.next();
            if (currentBlog.getId() == id) {
                iterator.remove();
            }
        }
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost body) {
        BlogPost found = null;

        for (BlogPost currentBlog : blogs) {
            if (currentBlog.getId() == id) {
                found = currentBlog;
                found.setCover(body.getCover());
                found.setCategoria(body.getCategoria());
                found.setContenuto(body.getCover());
                found.setTempoDiLettura(body.getTempoDiLettura());
                found.setId(id);
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;

    }
}
