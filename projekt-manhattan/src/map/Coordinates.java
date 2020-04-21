package map;

public class Coordinates
{
    private int vertical;
    private int horizontal;

    public Coordinates()
    {
        vertical = 0;
        horizontal = 0;
    }

    public Coordinates(int vertical, int horizontal)
    {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public Coordinates(Coordinates coords)
    {
        this.vertical = coords.vertical;
        this.horizontal = coords.horizontal;
    }

    public int getVertical()
    {
        return vertical;
    }

    public int getHorizontal()
    {
        return horizontal;
    }

    public void setVertical(int vertical)
    {
        this.vertical = vertical;
    }

    public void setHorizontal(int horizontal)
    {
        this.horizontal = horizontal;
    }

    public void setCoordinates(Coordinates coords)
    {
        this.vertical = coords.vertical;
        this.horizontal = coords.horizontal;
    }
} 