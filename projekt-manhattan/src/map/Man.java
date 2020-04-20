package map;

public class Man extends Being implements IMovable, IDiseaseSensitive {
    public Man(String id)
    {
        super(id, 'm');
    }
    @Override
    public void move() {

    }
    @Override
    public void performIllness() {
        
    }

    private byte healthPoints;
    private boolean isInfected;
    private final Sex sex;

    public Sex getSex()
    {
        return sex;
    }

    public byte getHealthPoints()
    {
        return healthPoints;
    }

    public boolean getIsInfected()
    {
        return isInfected;
    }

}