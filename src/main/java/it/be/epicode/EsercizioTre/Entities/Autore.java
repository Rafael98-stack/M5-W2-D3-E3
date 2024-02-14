package it.be.epicode.EsercizioDue.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autore {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private Date dataDiNascita;
    private String avatar;
}
