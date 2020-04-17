package map;

public abstract class Being {
    //Pole - identyfikator bytu
    private final String id;

    private final char representation;

    //Konstruktor klasy Byt
    public Being(String id, char representation){
        this.id = id;
        this.representation = representation;
    }

    //Metoda do wyświetlenia identyfikatora klasy Byt
    @Override
    public String toString(){
        return id;
    }

    public printRepresentation() {
        
    }
}