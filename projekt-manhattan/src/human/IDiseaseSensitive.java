package human;

import java.util.List;
import virus.DiseaseRecord;

/**
 * Interfejs, który zawiera deklaracje metod potrzebnych do operacji
 * na człowieku i jego cechach
 * @version 1.0
 * @see virus.DiseaseRecord
 * @see IRecoverable
 */
public interface IDiseaseSensitive extends IRecoverable {
    /**
     * Deklaracja metody, która symuluje przebieg choroby
     * @return stan człowieka
     */
    public int performIllness();
    /**
     * Deklaracja metody, która zwraca wartość czy obiekt jest żywy
     * @return wartość logiczna
     */
    public boolean getIsAlive();
    /**
     * Deklaracja metody, getter, która zwraca czy obiekt jest zarażony
     * @return wartość logiczna czy zarażony
     */
    public boolean getIsInfected();
    /**
     * Deklaracja metody, getter, która zwraca punkty zdrowia obiektu
     * @return punkty zdrowia
     */
    public int getHealthPoints();
    /**
     * Deklaracja metody, getter, która zwraca listę chorób obiektu
     * @return lista chorób
     */
    public List<DiseaseRecord> getDiseases();
    /**
     * Deklaracja mateody, setter, która ustawia wartość logiczną czy jest zarażony
     * @param isInfected wartość logiczna czy jest zarażony
     */
    public void setIsInfected(boolean isInfected);
    /**
     * Deklaracja metody, setter, która ustawia wartość punktów zdrowia obiektu
     * @param healthPoints punkty zdrowia obiektu
     */
    public void setHealthPoints(int healthPoints);
    /**
     * Deklaracja metody, setter, która ustawia stan logiczny aspektu czy obiekt jest żywy
     * @param isAlive stan logiczny czy żywy
     */ 
    public void setIsAlive(boolean isAlive);
}