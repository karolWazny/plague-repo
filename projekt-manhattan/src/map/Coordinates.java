package map;

public class Coordinates {
    private int vertical;
    private int horizontal;
    
    public Coordinates(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public Coordinates(Coordinates Coor){
        this.vertical = Coor.getVertical();
        this.horizontal = Coor.getHorizontal();
    }

    @Override
    public String toString(){
        return "Vertical = " + vertical + "; horizontal = " + horizontal;
    }

    public void setCoordinates(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public void setCoordinates(Coordinates Coor){
        this.vertical = Coor.getVertical();
        this.horizontal = Coor.getHorizontal();
    }

    public int getVertical(){
        return vertical;
    }

    public int getHorizontal(){
        return horizontal;
    }

    public void setVertical(int vertical){
        this.vertical = vertical;
    }

    public void setHorizontal(int horizontal){
        this.horizontal = horizontal;
    }

    public void addVector(Coordinates vector)
    {
        this.horizontal+=vector.getHorizontal();
        this.vertical+=vector.getVertical();
    }
}