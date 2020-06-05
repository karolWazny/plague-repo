package container;

import map.Map;
import map.Being;

/**
 * Interfejs, który jest wykorzystywany przy operacjach w kontenerze obiektów
 * W zwięzły sposób pozwala wykonywać po kolei operacje na obiektach
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
     * Deklaracja metody getter, która zwraca obiekt typu koordynaty danego obiektu
     * @return koordynaty obiektu
     */
    public Coordinates getVerHor();
    /**
     * Deklaracja metody setter, która ustawia koordynaty
     * @param currentVerHor aktualne koordynaty
     */
    public void setVerHor(Coordinates currentVerHor);
    /**
     * Deklaracja metody zarażającej sąsiadów
     * @param map mapa, na której jest obiekt
     * @return infromacja czy się powiodło
     */
    public int infectNeighbours(Map map);
    /**
     * Deklaracja metody, symulującej rozwój i przebieg choroby
     * @return zwraca tablicę z informacjami o stanie obiektu
     */
    public int[] progressIllness();
    /**
     * Deklaracja metody, która symuluje zdrowienie obiektu
     */
    public void performRecovery();
    /**
     * Deklaracja metody, getter, która pobiera byt z kontenera
     * @return obiekt typu byt
     */
    public Being getBeing();
}