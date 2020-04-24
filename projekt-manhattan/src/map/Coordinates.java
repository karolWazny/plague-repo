package map;

public class Coordinates {
    private int vertical;
    private int horizontal;
    
    public Coordinates(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    @Override
    public String toString(){
        return "Vertical = " + vertical + "; horizontal = " + horizontal;
    }
}