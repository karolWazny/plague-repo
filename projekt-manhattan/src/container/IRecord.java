package container;

import map.Map;
import map.Being;

/**
 * Interfejs, ktory jest wykorzystywany przy operacjach w kontenerze obiektow
 * W zwiezly sposob pozwala wykonywac po kolei operacje na obiektach
 * @version 1.0
 * @see map.Map
 * @see map.Being
 * @see container.Coordinates
 */
public interface IRecord {
    /**
     * deklaracja metody odpowiedzialnej za ruch
     */
    public void move();
    /**
     * Deklaracja metody getter, ktora zwraca obiekt typu koordynaty danego obiektu
     * @return koordynaty obiektu
     */
    public Coordinates getVerHor();
    /**
     * Deklaracja metody setter, ktora ustawia koordynaty
     * @param currentVerHor aktualne koordynaty
     */
    public void setVerHor(Coordinates currentVerHor);
    /**
     * Deklaracja metody zarazajacej sasiadow
     * @param map mapa, na ktorej jest obiekt
     * @return infromacja czy sie powiodlo
     */
    public int infectNeighbours(Map map);
    /**
     * Deklaracja metody, symulujacej rozwoj i przebieg choroby
     * @return zwraca tablice z informacjami o stanie obiektu
     */
    public int[] progressIllness();
    /**
     * Deklaracja metody, ktora symuluje zdrowienie obiektu
     */
    public void performRecovery();
    /**
     * Deklaracja metody, getter, ktora pobiera byt z kontenera
     * @return obiekt typu byt
     */
    public Being getBeing();
}