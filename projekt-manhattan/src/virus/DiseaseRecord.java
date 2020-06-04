package virus;

import human.IDiseaseSensitive;
import random.Dice;

/**
 * Klasa, która jest sztucznym "rekordem" choroby na liście chorób człowieka
 * Obiekty tej klasy znajdują się w polu człowieka - lista chorób
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
     * pole prywatne - informacja czy zaraża
     */
    private boolean infects;
    /**
     * pole prywatne - informacja czy występują symptomy choroby
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
     * Metoda - konstruktor, tworzy obiekty instancji tej klasy w zależności od parametrów
     * @param disease Choroba, która ma znajeźć się w rekordzie
     * @param infected Człowiek infekowany
     */
    public DiseaseRecord(Disease disease, IDiseaseSensitive infected) {
        this.disease = disease;
        isActive = (Dice.d100()<=disease.getActiveRate());
        infects = false;
        isCured = false;
        state = 0;
    }

    /**
     * Metoda, która symuluje rozwój choroby - informacje w rekordzie
     * @param infected Chorujący
     */
    public void progress(IDiseaseSensitive infected) {
        if(!isCured) {
            disease.progress(infected, this);
        }       
    }

    /**
     * Metoda, która infekuje inną instancję człowieka
     * @param human Instancja człowieka infekowanego
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
     * Metoda setter do informacji czy zaraża
     * @param infects stan logiczny czy zaraża
     */
    public void setInfects(boolean infects) {
        this.infects = infects;
    }

    /**
     * Metoda setter do stanu czy wyzdrowiał
     * @param isCured stan logiczny czy wyzdrowiał
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
     * Metoda setter do stanu czy są symptomy
     * @param areSymptoms stan logiczny czy są symptomy
     */
    public void setAreSymptoms(boolean areSymptoms) {
        this.areSymptoms = areSymptoms;
    }

    /**
     * Metoda zwracająca identyfikator choroby
     * @return String identyfikator
     */
    public String getDiseaseId(){
        return disease.getId();
    }

    /**
     * Metoda zwracająca stan logiczny czy jest aktywna choroba
     * @return stan logiczny czy jest aktywna
     */
    public boolean getIsActive(){
        return isActive;
    }

    /**
     * Metoda zwracająca stan logiczny czy zaraża
     * @return stan logiczny czy zaraża
     */
    public boolean getInfects(){
        return infects;
    }

    /**
     * Metoda zwracająca stan logiczny czy wyzdrowiał
     * @return stan logiczny informacji czy wyzdrowiał
     */
    public boolean getIsCured(){
        return isCured;
    }

    /**
     * Metoda zwracająca stadium rozwoju choroby
     * @return stan choroby
     */
    public int getState(){
        return state;
    }

    /**
     * Metoda zwracająca stan logiczny informacji czy są objawy
     * @return stan logiczny występowania objawów
     */
    public boolean getAreSymptoms() {
        return areSymptoms;
    }
}