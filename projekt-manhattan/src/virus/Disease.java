package virus;

import human.IDiseaseSensitive;

/**
 * Klasa, która w rzeczywistości byłaby pojęciem "choroba"
 * Posiada informacje bezpośrednio o chorobie i jej działanie na człowieka
 * @version 1.0
 * @see human.IDiseaseSensitive
 */
public abstract class Disease implements IDisease {
    /**
     * Pole z informacją: czas do objawów choroby
     */
    private int timeTilSymptoms;
    /**
     * Czas potrzebny do zainfekowania
     */
    private int timeTilInfect;
    /**
     * Czas potrzebny do wyzdrowienia
     */
    private int timeTilCured;
    /**
     * Identyfikator choroby
     */
    private String id;
    /**
     * Wskaźnik infekcji
     */
    private int infectionRate;
    /**
     * Szansa na wystąpienie objawów
     */
    private int activeRate;
    /**
     * Obiekt odpowiedzialny za zarażanie - wydzielona odpowiedzialność
     */
    protected static Infector infector = new Infector();
    
    /**
     * Metoda - konstruktor obiektów klasy choroba
     * @param id identyfikator
     * @param timeTilInfect czas do zainfekowania
     * @param timeTilCured czas do wyzdrowienia
     * @param infectionRate wskaźnik infekcji
     * @param activeRate szansa na wystąpienie objawów
     */
    public Disease(String id, int timeTilInfect, int timeTilCured, int infectionRate, int activeRate) {
        this.timeTilInfect = timeTilInfect;
        this.timeTilCured = timeTilCured;
        this.id = id;
        this.infectionRate = infectionRate;
        this.activeRate = activeRate;
    }

    /**
     * Metoda konstruktor, która jako parametr przyjmuje inną instancję tej samej klasy
     * @param prototype obiekt instancja tej samej klasy
     */
    public Disease(Disease prototype) {
        this(prototype.getId(), prototype.getTimeTilInfect(), prototype.getTimeTilCured(), prototype.getInfectionRate(), prototype.getActiveRate());
    }

    
    /** 
     * @param infected
     * @param getId(
     * @return int
     */
    /**
     * Deklaracja metody progress
     */
    public abstract int progress(IDiseaseSensitive infected, DiseaseRecord record);
    
    
    /** 
     * @param getId(
     * @return int
     */
    /**
     * Deklsaracja metody infect
     */
    public abstract int infect(IDiseaseSensitive man); //zarażenie wirusem zwraca 1, zarażenie czymś innym lub brak zarażenia zwraca 0

    /**
     * Metoda pobierająca identyfikator choroby
     * @return identyfikator
     */
    public String getId() {
        return id;
    }

    /**
     * Metoda pobierająca wartość czasu potrzebnego do zainfekowania
     * @return czas do zainfekowania
     */
    public int getTimeTilInfect() {
        return timeTilInfect;
    }

    /**
     * Metoda pobierająca wartość czasu potrzebnego do wyzdrowienia
     * @return czas do wyzdrowienia
     */
    public int getTimeTilCured() {
        return timeTilCured;
    }

    /**
     * Metoda zwracająca wskaźnik infekcji
     * @return wskaźnik infekcji
     */
    public int getInfectionRate() {
        return infectionRate;
    }

    /**
     * Metoda zwracająca Czas do wystąpienia symptomów
     * @return czas do wystąpienia symptomów
     */
    public int getTimeTilSymptoms() {
        return timeTilSymptoms;
    }

    /**
     * Metoda zwracająca szansę na wystąpieni objawów
     * @return szansa na wystąpienie objawów
     */
    public int getActiveRate() {
        return activeRate;
    }
}