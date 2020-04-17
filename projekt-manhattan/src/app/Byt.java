package app;

public class Byt {
    //Pole - identyfikator bytu
    private String id;

    //Konstruktor klasy Byt
    public Byt(String id){
        this.id = id;
    }

    //Metoda do wyświetlenia identyfikatora klasy Byt
    public String toString(){
        return id;
    }
}