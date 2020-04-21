package map;

public abstract class  Record implements IMapable {
    private IMovable content;
    private Coordinates coordinates;

    public Record(IMovable content, int vertical, int horizontal) 
    {
        this.content = content;
        coordinates = new Coordinates(vertical, horizontal);
    }

    public Record(IMovable content, Coordinates coords) 
    {
        this.content = content;
        coordinates = new Coordinates(coords);
    }

    public IMovable getContent()
    {
        return content;
    }

    @Override
    public void move()
    {
        setCoordinates(content.move(getCoordinates()));
    }

    @Override
    public Coordinates getCoordinates()
    {
        return coordinates;
    }

    @Override
    public void setCoordinates(Coordinates newCoords)
    {
        coordinates.setCoordinates(newCoords);
    }
}