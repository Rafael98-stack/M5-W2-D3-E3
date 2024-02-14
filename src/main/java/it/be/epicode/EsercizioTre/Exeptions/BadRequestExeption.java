package it.be.epicode.EsercizioTre.Exeptions;

public class BadRequestExeption extends RuntimeException{
    public  BadRequestExeption(String message) {
        super(message);
    }

}
