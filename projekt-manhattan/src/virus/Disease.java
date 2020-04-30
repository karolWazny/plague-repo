package virus;

import map.Human;

public abstract class Disease implements IDisease {
    //pola
    private boolean isActive;
    private int timeTilSymptoms;
    private int timeTilInfect;
    private int timeTilCured;
    private String id;
    private int infectionRate;
    private int activeRate;
    protected Infector infector;

    //metody
    @Override
    public abstract void progress(Human infected, DiseaseRecord record);
    
    @Override
    public abstract void infect(Human man);
    //konstruktor
    public Disease(boolean isActive, String id, int timeTilInfect, int timeTilCured, int infectionRate, int activeRate) {
        this.timeTilInfect = timeTilInfect;
        this.timeTilCured = timeTilCured;
        this.isActive = isActive;
        this.id = id;
        this.infectionRate = infectionRate;
        this.activeRate = activeRate;
    }

    // set/get
    @Override
    public boolean getIsActive() {
        return isActive;
    }


    public String getId() {
        return id;
    }

    public int getTimeTilInfect() {
        return timeTilInfect;
    }

    public int getTimeTilCured() {
        return timeTilCured;
    }

    @Override
    public int getInfectionRate() {
        return infectionRate;
    }

    @Override
    public int getTimeTilSymptoms() {
        return timeTilSymptoms;
    }

    @Override
    public int getActiveRate() {
        return activeRate;
    }
}