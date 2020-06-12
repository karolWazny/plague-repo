package virus;

import human.IDiseaseSensitive;

/**
 * Interfejs zawierajacy metody potrzebne przy infekcjach
 * @version 1.0
 * @see human.IDiseaseSensitive
 */
public interface IDisease {
    /**
     * Deklaracja metody odpowiedzialnej za zarazanie
     * @param human
     *          instancja czlowieka
     * @return Zwraca informacje czy powiodlo sie zarazenie       
     */
    public int infect(IDiseaseSensitive human);
    /**
     * Metoda, ktora symuluje rozwoj choroby
     * @param infected
     *          Obiekt podatny na choroby
     * @param record
     *          Choroba, na ktora sie choruje
     * @return informacje o przebiegu choroby i stanie obiektu
     */
    public int progress(IDiseaseSensitive infected, DiseaseRecord record);
    /**
     * Metoda, ktora zwraca wskaznik infekcji
     * @return Wskaznik infekcji
     */
    public int getInfectionRate();
    /**
     * Metoda, ktora zwraca szanse na wystapienie objawow
     * @return Szansa na wystapienie objawow
     */
    public int getActiveRate();
    /**
     * Metoda, ktora zwraca czas potrzebny do zarazenia
     * @return Czas do zarazania
     */
    public int getTimeTilSymptoms();
}