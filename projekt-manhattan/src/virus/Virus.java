package virus;

import random.Dice;
import human.IDiseaseSensitive;

/**
 * Klasa odzwierciedlająca realnego wirusa.
 * Obiekty tej klasy jak w życiu poruszają się po ludziach, 
 * namnażają, rozprzestrzeniają.
 * @version 1.0
 * @see random.Dice
 * @see human.IdiseaseSensitive
 * @see Virus.Disease
 */
public class Virus extends Disease {
    /**
     * Liczba kości
     */
    private int power1;
    /**
     * Liczba ścian na kości do losowania
     */
    private int power2;
    /**
     * Konstruktor, który tworzy nam instancję wirusa
     * @param power1
     *          Liczba kości
     * @param power2
     *          Liczba ścian kości do losowania
     * @param timeTilInfect
     *          Czas do zarażenia
     * @param timeTilCured
     *          Czas do wyzdrowienia
     * @param infectionRate
     *          wskaźnik infekcji
     * @param activeRate
     *          Szansa na wystąpienie objawów
     */
    public Virus(int power1, int power2, int timeTilInfect, int timeTilCured, int infectionRate, int activeRate) {
        super("korona", timeTilInfect, timeTilCured, infectionRate, activeRate);
        this.power1 = power1;
        this.power2 = power2;
    }
    /**
     * Konstruktor, który jako parametr przyjmuje inną instancję klasy
     * @param prototype
     *          Instancja tej samej klasy
     */
    public Virus(Virus prototype) {
        super(prototype);
        this.power1 = prototype.getPower1();
        this.power2 = prototype.getPower2();
    }
    @Override
    /**
     * Metoda, która symuluje rozwój choroby
     * @see IDiseaseSensitive
     * @see DiseaseRecord
     * @param infected
     *          Obiekt podatny na choroby
     * @param record
     *          Choroba, na którą się choruje
     */
    public int progress(IDiseaseSensitive infected, DiseaseRecord record) {
        int output = 0; 
        record.setState(record.getState()+Dice.d4()); 
        if(record.getIsActive()) {
                if((!record.getInfects())&&(record.getState()>=this.getTimeTilInfect())) {
                    record.setInfects(true);
                }
                if((!record.getAreSymptoms())&&(record.getState()>=this.getTimeTilSymptoms())) {
                    record.setAreSymptoms(true);
                }
                if((record.getState()>=this.getTimeTilCured())) {
                    record.setIsActive(false);
                    record.setIsCured(true);
                    record.setInfects(false);
                    record.setAreSymptoms(false);
                    infected.setIsInfected(false);
                    output++;
                }
            }
        if(!(record.getIsActive()||record.getIsCured())) {
            if((!record.getInfects())&&record.getState()>=this.getTimeTilInfect()) {
                record.setInfects(true);
            }
            if(record.getState()>=this.getTimeTilCured()) {
                record.setIsCured(true);
                record.setInfects(false);
                infected.setIsInfected(false);
                output = 1;
            }
        }
        if(record.getAreSymptoms()) {
            infected.setHealthPoints(infected.getHealthPoints()-Dice.custom(power1, power2));
            if(infected.getHealthPoints()<=0) {
                infected.setIsAlive(false);
                output = -1;
            }
        }
        return output;
    }

    @Override
    /**
     * Metoda, która symuluje zarażanie następnej instancji człowieka
     * @param human
     *          Instancja klasy człowieka
     * @return Czy obiekt człowiek został zarażony 
     */
    public int infect(IDiseaseSensitive human) {
        int infectionSuccessful = 0;
        infectionSuccessful = infector.performInfection(human, this);
        if(infectionSuccessful == 1) { 
            human.setIsInfected(true);
        }
        return infectionSuccessful;
    }
    /**
     * Metoda pobierająca ilość kostek
     * @return Zwraca wartość prywatnego pola power1
     */
    public int getPower1() {
        return power1;
    }
    /**
     * Metoda pobierająca ilość ścian w kostkach
     * @return Zwraca wartość prywatnego pola power2
     */
    public int getPower2() {
        return power2;
    }
}