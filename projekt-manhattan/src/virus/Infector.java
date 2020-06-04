package virus;

import human.IDiseaseSensitive;
import random.Dice;
/**
 * Klasa, która jest odpowiedzialna za zarażanie następnych ludzi
 * @see human.IDiseaseSensitive
 * @see random.Dice
 */
public class Infector {
    /**
     * Metoda, która jest odpowiedzialna za zarażanie następnej instancji człowieka
     * @param human
     *          instancja człowieka - cel infekcji
     * @param disease
     *          choroba, którą się zaraża
     * @return Zwraca 0 jeśli nie doszło do zarażenia i 1 jeśli się powiodło
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