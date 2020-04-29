package map;

public abstract class  Record implements IMapable {
    private Being being;
    private Coordinates position;

    public Record(Being being, Coordinates position) 
    {
        this.being = being;
        this.position = new Coordinates(position);
    }

    public Being getBeing()
    {
        return being;
    }

    @Override
    public void move()
    {
        if(being instanceof IDiseaseSensitive) {
            if(((IDiseaseSensitive)being).getIsAlive()==false)
            return; //trupy nie chodzą
        }
        if(being instanceof IMovable){
            IMovable being = (IMovable) this.being;
            position.addVector(being.move());
        }
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