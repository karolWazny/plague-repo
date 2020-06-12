package container;

/**
 * Interfejs, ktory ma zadeklarowana metode Move()
 * Przyjmuje ona jako parametr obiekt typu koordynaty, ktore sa 
 * aktualna pozycja obiektu
 * @version 1.0
 * @see container.Coordinates
 */
public interface IMovable {
    /**
     * Metoda, ktora wykonuje ruch, przyjmuje jako parametr aktualna pozycje
     * @param currentPosition aktualna pozycja
     * @return obiekt typu koordynaty nowa pozycja
     */
    public Coordinates move(Coordinates currentPosition);
}