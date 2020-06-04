package virus;

import human.IDiseaseSensitive;

/**
 * Interfejs zawierający metody potrzebne przy infekcjach
 * @version 1.0
 * @see human.IDiseaseSensitive
 */
public interface IDisease {
    /**
     * Deklaracja metody odpowiedzialnej za zarażanie
     * @param human
     *          instancja człowieka
     * @return Zwraca informację czy powiodło się zarażenie       
     */
    public int infect(IDiseaseSensitive human);
    /**
     * Metoda, która symuluje rozwój choroby
     * @param infected
     *          Obiekt podatny na choroby
     * @param record
     *          Choroba, na którą się choruje
     * @return informacje o przebiegu choroby i stanie obiektu
     */
    public int progress(IDiseaseSensitive infected, DiseaseRecord record);
    /**
     * Metoda, która zwraca wskaźnik infekcji
     * @return Wskaźnik infekcji
     */
    public int getInfectionRate();
    /**
     * Metoda, która zwraca szansę na wystąpienie objawów
     * @return Szansa na wystąpienie objawów
     */
    public int getActiveRate();
    /**
     * Metoda, która zwraca czas potrzebny do zarażenia
     * @return Czas do zarażania
     */
    public int getTimeTilSymptoms();
}