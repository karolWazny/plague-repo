package map;

public abstract class  Record implements IMapable {
    private IMovable being;
    private int vertical;
    private int horizontal;

    public Record(IMovable being, int vertical, int horizontal) 
    {
        this.being = being;
        this.vertical = vertical;
        this.horizontal = horizontal;
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
    public int[] getVerHor()
    {
        int location[] = new int[] {vertical, horizontal};
        return location;
    }

    @Override
    public void setVerHor(int[] newVerHor)
    {
        vertical = newVerHor[0];
        horizontal = newVerHor[1];
    }
}