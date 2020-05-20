package virus;

import human.IDiseaseSensitive;
import random.Dice;

public class Infector {
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