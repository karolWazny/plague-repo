package map;

public abstract class Being implements IPrintable {
    //Pole - identyfikator bytu
    private final String id;

    protected final Character representation;

    //Konstruktor klasy Byt
    public Being(String id, char representation){
        this.id = id;
        this.representation = representation;
    }

    //Metoda do wyświetlenia identyfikatora klasy Byt
    @Override
    public String toString(){
        return representation.toString();
    }

    public String getId() {
        return id;
    }
}