package virus;

import map.Human;

public abstract class Disease implements IDisease {
    private int timeTilSymptoms;
    private int timeTilInfect;
    private int timeTilCured;
    private String id;
    private int infectionRate;
    private int activeRate;
    protected Infector infector;

    ////////////////////////////
    
    public Disease(String id, int timeTilInfect, int timeTilCured, int infectionRate, int activeRate) {
        this.timeTilInfect = timeTilInfect;
        this.timeTilCured = timeTilCured;
        this.id = id;
        this.infectionRate = infectionRate;
        this.activeRate = activeRate;
    }

    ////////////////////////////

    @Override
    public abstract void progress(Human infected, DiseaseRecord record);
    
    @Override
    public abstract void infect(Human man);

    ////////////////////////////

    ////////////////////////////

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