package human;

import java.util.List;
import virus.DiseaseRecord;

/**
 * Interfejs, ktory zawiera deklaracje metod potrzebnych do operacji
 * na czlowieku i jego cechach
 * @version 1.0
 * @see virus.DiseaseRecord
 * @see IRecoverable
 */
public interface IDiseaseSensitive extends IRecoverable {
    /**
     * Deklaracja metody, ktora symuluje przebieg choroby
     * @return stan czlowieka
     */
    public int performIllness();
    /**
     * Deklaracja metody, ktora zwraca wartosć czy obiekt jest zywy
     * @return wartosć logiczna
     */
    public boolean getIsAlive();
    /**
     * Deklaracja metody, getter, ktora zwraca czy obiekt jest zarazony
     * @return wartosć logiczna czy zarazony
     */
    public boolean getIsInfected();
    /**
     * Deklaracja metody, getter, ktora zwraca punkty zdrowia obiektu
     * @return punkty zdrowia
     */
    public int getHealthPoints();
    /**
     * Deklaracja metody, getter, ktora zwraca liste chorob obiektu
     * @return lista chorob
     */
    public List<DiseaseRecord> getDiseases();
    /**
     * Deklaracja mateody, setter, ktora ustawia wartosć logiczna czy jest zarazony
     * @param isInfected wartosć logiczna czy jest zarazony
     */
    public void setIsInfected(boolean isInfected);
    /**
     * Deklaracja metody, setter, ktora ustawia wartosć punktow zdrowia obiektu
     * @param healthPoints punkty zdrowia obiektu
     */
    public void setHealthPoints(int healthPoints);
    /**
     * Deklaracja metody, setter, ktora ustawia stan logiczny aspektu czy obiekt jest zywy
     * @param isAlive stan logiczny czy zywy
     */ 
    public void setIsAlive(boolean isAlive);
}