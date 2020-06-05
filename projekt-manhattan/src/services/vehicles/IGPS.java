package services.vehicles;

import container.Coordinates;
import map.Map;

/**
 * Interfejs, który implementuje klasa GPS-u 
 * Zawiera deklaracje metod
 * @version 1.0
 * @see container.Coordinates
 * @see map.Map
 */
public interface IGPS {
    /**
     * Metoda, która nawiguje pojazdem, aby dotarł w odpowiednie miejsce
     * @param position aktualna pozycja
     * @param destination cel podróży
     * @param velocity szybkość poruszania się
     * @return nowe koordynaty
     */
    public Coordinates navigate(Coordinates position, Coordinates destination, int velocity);
    /**
     * Metoda, getter, która zwraca używaną mapę
     * @return obiekt typu mapa
     */
    public Map getMap();
}