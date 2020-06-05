package app;

public class SimulationState {
    private final int numPeople;
    private final int numInfected;

    //////////////////////////

    public SimulationState (int numPeople, int numInfected) {
        this.numPeople = numPeople;
        this.numInfected = numInfected;
    }

    /////////////////////////

    //@Override
    public String toString(){
        return "Alive: "+numPeople+", infected: "+numInfected;
    }
    /////////////////////////
    public int getNumPeople() {
        return numPeople;
    }

    public int getNumInfected(){
        return numInfected;
    }
}