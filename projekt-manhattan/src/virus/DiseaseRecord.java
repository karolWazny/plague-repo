package virus;

import map.Human;
import random.Dice;

public class DiseaseRecord {
    //pola
    private Disease disease;
    private boolean isActive;
    private boolean infects;
    private boolean areSymptoms;
    private boolean isCured;
    private int state;
    //metody
    public void progress(Human infected) {
        if(!isCured) {
            disease.progress(infected, this);
        }       
    }

    public void infect(Human human) {
        if(!infects)
            return;
        disease.infect(human);
    }
    //konstruktor
    public DiseaseRecord(Disease disease, Human infected) {
        this.disease = disease;
        isActive = (Dice.d100()<=disease.getActiveRate());
        infects = false;
        isCured = false;
        state = 0;
    }
    // set/get
    public String getDiseaseId(){
        return disease.getId();
    }

    public boolean getIsActive(){
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getInfects(){
        return infects;
    }

    public void setInfects(boolean infects) {
        this.infects = infects;
    }

    public boolean getIsCured(){
        return isCured;
    }

    public void setIsCured(boolean isCured) {
        this.isCured = isCured;
    }

    public int getState(){
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean getAreSymptoms() {
        return areSymptoms;
    }

    public void setAreSymptoms(boolean areSymptoms) {
        this.areSymptoms = areSymptoms;
    }
}