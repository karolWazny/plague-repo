package map;

/**
 * Klasa, po której dziedziczy większość klas obiektów będących na mapie
 * Abstrakcyjna klasa, która nie tworzy instancji
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
     * @param id ciąg znakowy - identyfikator
     * @param representation znak, reprezentacja znakowa
     */
    public Being(String id, char representation){
        this.id = id;
        this.representation = representation;
    }

    @Override
    /**
     * Metoda zwracająca reprezentację znakową bytu
     * @return reprezentacja znakowa
     */
    public String toString(){
        return representation.toString();
    }

    
    @Override
    /**
     * Metoda getter, która zwraca ciąg znakowy - identyfikator bytu
     * @return ciąg znakowy identyfikatora
     */
    public String getId() {
        return id;
    }

    @Override
    /**
     * Metoda getter, która zwraca reprezentację znakową bytu
     * @return reprezentacja znakowa w konsoli
     */
    public char getRepresentation(){
        return representation;
    }
}
