package virus;

import random.Dice;
import map.Human;

public class Virus extends Disease {
    //pola
    private int power1;
    private int power2;

    //metody
    @Override
    public void progress(Human infected, DiseaseRecord record) {
            record.setState(record.getState()+Dice.d4()); //ta metoda i tak wywoła się tylko, jeżeli choroba nie jest cured
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
                }
            }
        if(!(record.getIsActive()||record.getIsCured())) {
            if((!record.getInfects())&&record.getState()>=this.getTimeTilInfect()) {
                record.setInfects(true);
            }
            if(record.getState()>=this.getTimeTilCured()) {
                record.setIsCured(true);;
                record.setInfects(false);;
            }
        }
        infected.setHealthPoints(infected.getHealthPoints()-Dice.custom(power1, power2));
    }

    @Override
    public void infect(Human human) {
        infector.performInfection(human, this);
        human.setIsInfected(true);
    }
    //konstruktor
    public Virus(Human infected, int power1, int power2) {
        super(Dice.d100()>5, "korona", 5, 50, 25, 100);
        this.power1 = power1;
        this.power2 = power2;
    }
    // get/set
}