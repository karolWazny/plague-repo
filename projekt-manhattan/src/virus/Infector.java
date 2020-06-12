package virus;

import human.IDiseaseSensitive;
import random.Dice;
/**
 * Klasa, ktora jest odpowiedzialna za zarazanie nastepnych ludzi
 * @see human.IDiseaseSensitive
 * @see random.Dice
 */
public class Infector {
    /**
     * Metoda, ktora jest odpowiedzialna za zarazanie nastepnej instancji czlowieka
     * @param human
     *          instancja czlowieka - cel infekcji
     * @param disease
     *          choroba, ktora sie zaraza
     * @return Zwraca 0 jesli nie doszlo do zarazenia i 1 jesli sie powiodlo
     */
    public int performInfection(IDiseaseSensitive human, Disease disease) {
        for(DiseaseRecord illness: human.getDiseases()) {
            if(illness.getDiseaseId()==disease.getId()) {
                return 0;
            }
        }
        if(Dice.d100()<=disease.getInfectionRate()) {
            human.getDiseases().add(new DiseaseRecord(disease, human)); //naruszona zasada Demeter
            return 1;
        }
        return 0;
    }
}