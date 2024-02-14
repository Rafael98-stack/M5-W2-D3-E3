package it.be.epicode.EsercizioTre.Exeptions;

public class NotFoundExeption extends RuntimeException{
    public NotFoundExeption(String message) {
        super(message);
    }

    public NotFoundExeption(int id) {
        super(id + " non trovato!");
    }
}
