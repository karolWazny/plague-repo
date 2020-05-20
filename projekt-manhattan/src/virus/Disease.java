package virus;

import human.IDiseaseSensitive;

public abstract class Disease implements IDisease {
    private int timeTilSymptoms;
    private int timeTilInfect;
    private int timeTilCured;
    private String id;
    private int infectionRate;
    private int activeRate;
    protected static Infector infector = new Infector();

    ////////////////////////////
    
    public Disease(String id, int timeTilInfect, int timeTilCured, int infectionRate, int activeRate) {
        this.timeTilInfect = timeTilInfect;
        this.timeTilCured = timeTilCured;
        this.id = id;
        this.infectionRate = infectionRate;
        this.activeRate = activeRate;
    }

    public Disease(Disease prototype) {
        this(prototype.getId(), prototype.getTimeTilInfect(), prototype.getTimeTilCured(), prototype.getInfectionRate(), prototype.getActiveRate());
    }

    ////////////////////////////

    @Override
    public abstract int progress(IDiseaseSensitive infected, DiseaseRecord record);
    
    @Override
    public abstract int infect(IDiseaseSensitive man); //zarażenie wirusem zwraca 1, zarażenie czymś innym lub brak zarażenia zwraca 0

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