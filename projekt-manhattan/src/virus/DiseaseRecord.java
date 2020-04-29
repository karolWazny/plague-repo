package virus;

import map.Human;
import random.Dice;

public class DiseaseRecord {
    //pola
    private Disease disease;
    private boolean isActive;
    private boolean infects;
    private boolean isCured;
    private int state;
    //metody
    public void progress(Human infected) {
        disease.progress(infected);
        state+=Dice.d4();
    }

    public void infect(Human human) {
        disease.infect(human); //dokończyć metodę
    }
    //konstruktor
    public DiseaseRecord(Disease disease, Human infected) {
        this.disease = disease;
        isActive = true; //na ten moment na sztywno, później będzie losowo
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

    public boolean getInfects(){
        return infects;
    }

    public boolean getIsCured(){
        return isCured;
    }

    public int getState(){
        return state;
    }
}