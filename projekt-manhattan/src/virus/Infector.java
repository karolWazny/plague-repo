package virus;

import map.Human;

public class Infector {
    public void performInfection(Human human, Disease disease) {
        for(DiseaseRecord illness: human.getDiseases()) {
            if(illness.getDiseaseId()==disease.getId()) {
                return;
            }
        }
        human.getDiseases().add(new DiseaseRecord(disease, human));
    }
}