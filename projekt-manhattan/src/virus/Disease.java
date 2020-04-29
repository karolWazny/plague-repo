package virus;

import map.Human;

public abstract class Disease implements IDisease {
    //pola
    private boolean isActive;
    protected int timeTilInfect;
    private String id;

    //metody
    @Override
    public abstract void progress(Human infected);
    
    @Override
    public abstract void infect(Human man);
    //konstruktor
    public Disease(boolean isActive, String id) {
        this.isActive = isActive;
        this.id = id;
    }

    // set/get
    @Override
    public boolean getIsActive() {
        return isActive;
    }

    public String getId() {
        return id;
    }
}