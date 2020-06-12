package virus;

import human.IDiseaseSensitive;

/**
 * Klasa, ktora w rzeczywistosci bylaby pojeciem "choroba"
 * Posiada informacje bezposrednio o chorobie i jej dzialanie na czlowieka
 * @version 1.0
 * @see human.IDiseaseSensitive
 */
public abstract class Disease implements IDisease {
    /**
     * Pole z informacja: czas do objawow choroby
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
     * Wskaznik infekcji
     */
    private int infectionRate;
    /**
     * Szansa na wystapienie objawow
     */
    private int activeRate;
    /**
     * Obiekt odpowiedzialny za zarazanie - wydzielona odpowiedzialnosc
     */
    protected static Infector infector = new Infector();
    
    /**
     * Metoda - konstruktor obiektow klasy choroba
     * @param id identyfikator
     * @param timeTilInfect czas do zainfekowania
     * @param timeTilCured czas do wyzdrowienia
     * @param infectionRate wskaznik infekcji
     * @param activeRate szansa na wystapienie objawow
     */
    public Disease(String id, int timeTilInfect, int timeTilCured, int infectionRate, int activeRate) {
        this.timeTilInfect = timeTilInfect;
        this.timeTilCured = timeTilCured;
        this.id = id;
        this.infectionRate = infectionRate;
        this.activeRate = activeRate;
    }

    /**
<<<<<<< HEAD
     * Metoda konstruktow, ktora jako parametr przyjmuje inna instancje tej samej klasy
=======
     * Metoda konstruktor, która jako parametr przyjmuje inną instancję tej samej klasy
>>>>>>> 538007c06d7b4c6e7a34d9ff1a1d922de984e8c7
     * @param prototype obiekt instancja tej samej klasy
     */
    public Disease(Disease prototype) {
        this(prototype.getId(), prototype.getTimeTilInfect(), prototype.getTimeTilCured(), prototype.getInfectionRate(), prototype.getActiveRate());
    }

    
    /** 
     * Deklaracja metody progress
     * @param infected
     * @param getId(
     * @return int
     */
    public abstract int progress(IDiseaseSensitive infected, DiseaseRecord record);
    
    
    /** 
     * Deklaracja metody infect
     * @param getId(
     * @return int
     */
    //@Override
    public abstract int infect(IDiseaseSensitive man); //zarazenie wirusem zwraca 1, zarazenie czyms innym lub brak zarazenia zwraca 0

    /**
     * Metoda pobierajaca identyfikator choroby
     * @return identyfikator
     */
    public String getId() {
        return id;
    }

    /**
     * Metoda pobierajaca wartosc czasu potrzebnego do zainfekowania
     * @return czas do zainfekowania
     */
    public int getTimeTilInfect() {
        return timeTilInfect;
    }

    /**
<<<<<<< HEAD
     * MEtoda pobierajaca wartosc czasu potrzebnego do wyzdrowienia
=======
     * Metoda pobierająca wartośc czasu potrzebnego do wyzdrowienia
>>>>>>> 538007c06d7b4c6e7a34d9ff1a1d922de984e8c7
     * @return czas do wyzdrowienia
     */
    public int getTimeTilCured() {
        return timeTilCured;
    }

    /**
     * Metoda zwracajaca wskaznik infekcji
     * @return wskaznik infekcji
     */
    public int getInfectionRate() {
        return infectionRate;
    }

    /**
     * Metoda zwracajaca Czas do wystapienia symptomow
     * @return czas do wystapienia symptomow
     */
    public int getTimeTilSymptoms() {
        return timeTilSymptoms;
    }

    /**
     * Metoda zwracajaca szanse na wystapieni objawow
     * @return szansa na wystapienie objawow
     */
    public int getActiveRate() {
        return activeRate;
    }
}