package it.be.epicode.EsercizioTre.Controllers;

import it.be.epicode.EsercizioTre.Entities.BlogPost;
import it.be.epicode.EsercizioTre.PayLoad.BlogPostPayLoad;
import it.be.epicode.EsercizioTre.Services.AutorsBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    private AutorsBlogsService autorsBlogsService;



    @GetMapping
    public List<BlogPost> getAllBlogs() {
        return this.autorsBlogsService.getBlogs();
    }

    @PostMapping
  public BlogPost saveBlogs(@RequestBody BlogPostPayLoad body) {
        return this.autorsBlogsService.saveBlogs(body);
    }
}
