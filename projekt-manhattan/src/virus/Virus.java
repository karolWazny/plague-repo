package virus;

import random.Dice;
import human.IDiseaseSensitive;

/**
 * Klasa odzwierciedlajaca realnego wirusa.
 * Obiekty tej klasy jak w zyciu poruszaja sie po ludziach, 
 * namnazaja, rozprzestrzeniaja.
 * @version 1.0
 * @see random.Dice
 * @see human.IdiseaseSensitive
 * @see Virus.Disease
 */
public class Virus extends Disease {
    /**
     * Liczba kosci
     */
    private int power1;
    /**
     * Liczba scian na kosci do losowania
     */
    private int power2;
    /**
     * Konstruktor, ktory tworzy nam instancje wirusa
     * @param power1
     *          Liczba kosci
     * @param power2
     *          Liczba scian kosci do losowania
     * @param timeTilInfect
     *          Czas do zarazenia
     * @param timeTilCured
     *          Czas do wyzdrowienia
     * @param infectionRate
     *          wskaznik infekcji
     * @param activeRate
     *          Szansa na wystapienie objawow
     */
    public Virus(int power1, int power2, int timeTilInfect, int timeTilCured, int infectionRate, int activeRate) {
        super("korona", timeTilInfect, timeTilCured, infectionRate, activeRate);
        this.power1 = power1;
        this.power2 = power2;
    }
    /**
     * Konstruktor, ktory jako parametr przyjmuje inna instancje klasy
     * @param prototype
     *          Instancja tej samej klasy
     */
    public Virus(Virus prototype) {
        super(prototype);
        this.power1 = prototype.getPower1();
        this.power2 = prototype.getPower2();
    }
    //@Override
    /**
     * Metoda, ktora symuluje rozwoj choroby
     * @see IDiseaseSensitive
     * @see DiseaseRecord
     * @param infected
     *          Obiekt podatny na choroby
     * @param record
     *          Choroba, na ktora sie choruje
     * @return Zwraca 0 jesli nie zmienil sie stan, 1 jesli wyzdrowial, -1 jesli umarl
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

    //@Override
    /**
     * Metoda, ktora symuluje zarazanie nastepnej instancji czlowieka
     * @param human
     *          Instancja klasy czlowieka
     * @return Czy obiekt czlowiek zostal zarazony 
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
     * Metoda pobierajaca ilosc kostek
     * @return Zwraca wartosc prywatnego pola power1
     */
    public int getPower1() {
        return power1;
    }
    /**
     * Metoda pobierajaca ilosc scian w kostkach
     * @return Zwraca wartosc prywatnego pola power2
     */
    public int getPower2() {
        return power2;
    }
}