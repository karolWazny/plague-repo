package virus;

import human.IDiseaseSensitive;
import random.Dice;

/**
 * Klasa, ktora jest sztucznym "rekordem" choroby na liscie chorob czlowieka
 * Obiekty tej klasy znajduja sie w polu czlowieka - lista chorob
 * @version 1.0
 * @see human
 * @see random.Dice
 */
public class DiseaseRecord {
    /**
     * pole prywatne - choroba
     */
    private Disease disease;
    /**
     * pole prywatne - informacja czy jest aktywna
     */
    private boolean isActive;
    /**
     * pole prywatne - informacja czy zaraza
     */
    private boolean infects;
    /**
     * pole prywatne - informacja czy wystepuja symptomy choroby
     */
    private boolean areSymptoms;
    /**
     * pole prywatne - czy jest wyleczony
     */
    private boolean isCured;
    /**
     * pole prywatne - stadium rozwoju choroby
     */
    private int state;

    /**
     * Metoda - konstruktor, tworzy obiekty instancji tej klasy w zaleznosci od parametrow
     * @param disease Choroba, ktora ma znajezć sie w rekordzie
     * @param infected Czlowiek infekowany
     */
    public DiseaseRecord(Disease disease, IDiseaseSensitive infected) {
        this.disease = disease;
        isActive = (Dice.d100()<=disease.getActiveRate());
        infects = false;
        isCured = false;
        state = 0;
    }

    /**
     * Metoda, ktora symuluje rozwoj choroby - informacje w rekordzie
     * @param infected Chorujacy
     */
    public void progress(IDiseaseSensitive infected) {
        if(!isCured) {
            disease.progress(infected, this);
        }       
    }

    /**
     * Metoda, ktora infekuje inna instancje czlowieka
     * @param human Instancja czlowieka infekowanego
     * @return Zwraca 0 jesli nie zainfekowano
     */
    public int infect(IDiseaseSensitive human) {
        if(!infects)
            return 0;
        return disease.infect(human);
    }

    /**
     * Metoda setter do stanu czy przypadek jest aktywny
     * @param isActive informacja o stanie
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    /**
     * Metoda setter do informacji czy zaraza
     * @param infects stan logiczny czy zaraza
     */
    public void setInfects(boolean infects) {
        this.infects = infects;
    }

    /**
     * Metoda setter do stanu czy wyzdrowial
     * @param isCured stan logiczny czy wyzdrowial
     */
    public void setIsCured(boolean isCured) {
        this.isCured = isCured;
    }

    /**
     * Metoda setter do ustawiania stanu
     * @param state stan
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * Metoda setter do stanu czy sa symptomy
     * @param areSymptoms stan logiczny czy sa symptomy
     */
    public void setAreSymptoms(boolean areSymptoms) {
        this.areSymptoms = areSymptoms;
    }

    /**
     * Metoda zwracajaca identyfikator choroby
     * @return String identyfikator
     */
    public String getDiseaseId(){
        return disease.getId();
    }

    /**
     * Metoda zwracajaca stan logiczny czy jest aktywna choroba
     * @return stan logiczny czy jest aktywna
     */
    public boolean getIsActive(){
        return isActive;
    }

    /**
     * Metoda zwracajaca stan logiczny czy zaraza
     * @return stan logiczny czy zaraza
     */
    public boolean getInfects(){
        return infects;
    }

    /**
     * Metoda zwracajaca stan logiczny czy wyzdrowial
     * @return stan logiczny informacji czy wyzdrowial
     */
    public boolean getIsCured(){
        return isCured;
    }

    /**
     * Metoda zwracajaca stadium rozwoju choroby
     * @return stan choroby
     */
    public int getState(){
        return state;
    }

    /**
     * Metoda zwracajaca stan logiczny informacji czy sa objawy
     * @return stan logiczny wystepowania objawow
     */
    public boolean getAreSymptoms() {
        return areSymptoms;
    }
}