package it.be.epicode.EsercizioTre.PayLoad;

import lombok.Data;

@Data
public class BlogPostPayLoad {
    private int authorId;
    private String category;
    private String content;
    private double readingTime;
    private String title;
}
