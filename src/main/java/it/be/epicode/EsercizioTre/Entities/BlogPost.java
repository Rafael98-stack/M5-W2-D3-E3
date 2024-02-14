package it.be.epicode.EsercizioTre.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "blog_post")
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue
    private long id;
private String categoria;
private String titolo;
private String cover;
private String contenuto;
private int tempoDiLettura;

//    public BlogPost() {
//    }
//
//    public BlogPost(long id, String categoria, String titolo, String cover, String contenuto, int tempoDiLettura) {
//        this.id = id;
//        this.categoria = categoria;
//        this.titolo = titolo;
//        this.cover = cover;
//        this.contenuto = contenuto;
//        this.tempoDiLettura = tempoDiLettura;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

    public void setTempoDiLettura(int tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }

    @Override
    public String toString() {
        return "Blog_Post{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", cover='" + cover + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", tempoDiLettura=" + tempoDiLettura +
                '}';
    }
}
