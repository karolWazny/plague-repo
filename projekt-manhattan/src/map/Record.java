package map;

public abstract class  Record implements IMapable {
    private IMovable being;
    private Coordinates position;

    public Record(IMovable being, Coordinates position) 
    {
        this.being = being;
        this.position = new Coordinates(vertical, horizontal);
    }

    public IMovable getBeing()
    {
        return being;
    }

    @Override
    public void move()
    {
        setVerHor(being.move(getVerHor()));
    }

    @Override
    public Coordinates getVerHor()
    {
        return position;
    }

    @Override
    public void setVerHor(Coordinates newVerHor)
    {
        position = newVerHor;
    }
}