package services.vehicles;

import container.Coordinates;
import map.Map;

/**
 * Interfejs, ktory implementuje klasa GPS-u 
 * Zawiera deklaracje metod
 * @version 1.0
 * @see container.Coordinates
 * @see map.Map
 */
public interface IGPS {
    /**
     * Metoda, ktora nawiguje pojazdem, aby dotarl w odpowiednie miejsce
     * @param position aktualna pozycja
     * @param destination cel podrozy
     * @param velocity szybkosć poruszania sie
     * @return nowe koordynaty
     */
    public Coordinates navigate(Coordinates position, Coordinates destination, int velocity);
    /**
     * Metoda, getter, ktora zwraca uzywana mape
     * @return obiekt typu mapa
     */
    public Map getMap();
}