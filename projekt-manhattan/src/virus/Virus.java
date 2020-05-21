package virus;

import random.Dice;
import human.IDiseaseSensitive;

public class Virus extends Disease {
    private int power1;
    private int power2;

    ////////////////////////////
    
    public Virus(int power1, int power2, int timeTilInfect, int timeTilCured, int infectionRate, int activeRate) {
        super("korona", timeTilInfect, timeTilCured, infectionRate, activeRate);
        this.power1 = power1;
        this.power2 = power2;
    }

    public Virus(Virus prototype) {
        super(prototype);
        this.power1 = prototype.getPower1();
        this.power2 = prototype.getPower2();
    }

    ////////////////////////////

    @Override
    public int progress(IDiseaseSensitive infected, DiseaseRecord record) {
        int output = 0; //1 - wyzdrowiał, -1 umarł
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
    public int infect(IDiseaseSensitive human) {
        int infectionSuccessful = 0;
        infectionSuccessful = infector.performInfection(human, this);
        if(infectionSuccessful == 1) { 
            human.setIsInfected(true);
        }
        return infectionSuccessful;
    }

    ////////////////////////////

    public int getPower1() {
        return power1;
    }

    public int getPower2() {
        return power2;
    }
}