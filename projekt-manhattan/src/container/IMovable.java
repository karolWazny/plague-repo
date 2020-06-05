package container;

/**
 * Interfejs, który ma zadeklarowaną metodę Move()
 * Przyjmuje ona jako parametr obiekt typu koordynaty, które są 
 * aktualną pozycją obiektu
 * @version 1.0
 * @see container.Coordinates
 */
public interface IMovable {
    /**
     * Metoda, która wykonuje ruch, przyjmuje jako parametr aktualną pozycję
     * @param currentPosition aktualna pozycja
     * @return obiekt typu koordynaty nową pozycją
     */
    public Coordinates move(Coordinates currentPosition);
}