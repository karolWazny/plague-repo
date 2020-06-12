package map;

/**
 * Klasa, po ktorej dziedziczy wiekszosć klas obiektow bedacych na mapie
 * Abstrakcyjna klasa, ktora nie tworzy instancji
 * @version 1.0
 * @see map.IPrintable
 */
public abstract class Being implements IPrintable {
    /**
     * Pole - identyfikator bytu
     */
    private final String id;
    /**
     * Reprezentacja znakowa (w konsoli)
     */
    protected final Character representation;

    /**
     * Metoda konstruktor klasy byt
     * @param id ciag znakowy - identyfikator
     * @param representation znak, reprezentacja znakowa
     */
    public Being(String id, char representation){
        this.id = id;
        this.representation = representation;
    }

    //@Override
    /**
     * Metoda zwracajaca reprezentacje znakowa bytu
     * @return reprezentacja znakowa
     */
    public String toString(){
        return representation.toString();
    }

    
    //@Override
    /**
     * Metoda getter, ktora zwraca ciag znakowy - identyfikator bytu
     * @return ciag znakowy identyfikatora
     */
    public String getId() {
        return id;
    }

    //@Override
    /**
     * Metoda getter, ktora zwraca reprezentacje znakowa bytu
     * @return reprezentacja znakowa w konsoli
     */
    public char getRepresentation(){
        return representation;
    }
}
