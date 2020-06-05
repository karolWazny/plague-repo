package map;

/**
 * Interfejs, który deklaruje metody potrzebne przy operacjach na mapie
 * @version 1.0
 * @see map.Being
 * @see map.Map
 */
public interface IPrintable {
    /**
     * Deklaracja metody zwracającacej reprezentację znakową obiektu
     * @return ciąg znaków - opis słowny instancji klasy
     */
    public String toString();
    /**
     * Deklaracja metody typu getter, która zwraca ciąg znaków - identyfikator
     * @return identyfikator
     */
    public String getId();
    /**
     * Deklaracja metody zwracającej reprezentację znakową klasy
     * @return znak - reprezentacja znakowa
     */
    public char getRepresentation();
}