package virus;

import human.IDiseaseSensitive;
import random.Dice;

public class DiseaseRecord {
    private Disease disease;
    private boolean isActive;
    private boolean infects;
    private boolean areSymptoms;
    private boolean isCured;
    private int state;

    ////////////////////////////

    public DiseaseRecord(Disease disease, IDiseaseSensitive infected) {
        this.disease = disease;
        isActive = (Dice.d100()<=disease.getActiveRate());
        infects = false;
        isCured = false;
        state = 0;
    }

    ////////////////////////////

    public void progress(IDiseaseSensitive infected) {
        if(!isCured) {
            disease.progress(infected, this);
        }       
    }

    public int infect(IDiseaseSensitive human) {
        if(!infects)
            return 0;
        return disease.infect(human);
    }
    
    ////////////////////////////
    
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public void setInfects(boolean infects) {
        this.infects = infects;
    }

    public void setIsCured(boolean isCured) {
        this.isCured = isCured;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setAreSymptoms(boolean areSymptoms) {
        this.areSymptoms = areSymptoms;
    }

    ////////////////////////////

    public String getDiseaseId(){
        return disease.getId();
    }

    public boolean getIsActive(){
        return isActive;
    }

    public boolean getInfects(){
        return infects;
    }

    public boolean getIsCured(){
        return isCured;
    }

    public int getState(){
        return state;
    }

    public boolean getAreSymptoms() {
        return areSymptoms;
    }
}