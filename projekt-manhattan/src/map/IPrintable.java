package map;

/**
 * Interfejs, ktory deklaruje metody potrzebne przy operacjach na mapie
 * @version 1.0
 * @see map.Being
 * @see map.Map
 */
public interface IPrintable {
    /**
     * Deklaracja metody zwracajacacej reprezentacje znakowa obiektu
     * @return ciag znakow - opis slowny instancji klasy
     */
    public String toString();
    /**
     * Deklaracja metody typu getter, ktora zwraca ciag znakow - identyfikator
     * @return identyfikator
     */
    public String getId();
    /**
     * Deklaracja metody zwracajacej reprezentacje znakowa klasy
     * @return znak - reprezentacja znakowa
     */
    public char getRepresentation();
}