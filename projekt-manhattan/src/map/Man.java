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

}