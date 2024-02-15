package it.be.epicode.EsercizioTre.Controllers;

import it.be.epicode.EsercizioTre.Entities.Autore;
import it.be.epicode.EsercizioTre.Services.AutorsBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AutorsController {
    @Autowired
  private   AutorsBlogsService autorsBlogsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveAutore(@RequestBody Autore body) throws Exception {
        return autorsBlogsService.saveAutore(body);
    }

    @GetMapping
    public Page<Autore> getAuthors(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return autorsBlogsService.getAuthors(page, size, sortBy);
    }
}
