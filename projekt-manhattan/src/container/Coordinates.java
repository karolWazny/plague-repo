package container;

public class Coordinates {
    private int vertical;
    private int horizontal;
    
    ////////////////////////////

    public Coordinates() {
        this(0, 0);
    }

    public Coordinates(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public Coordinates(Coordinates Coor){
        if(Coor == null){
            return;
        }
        this.vertical = Coor.getVertical();
        this.horizontal = Coor.getHorizontal();
    }

    ////////////////////////////

    @Override
    public String toString(){
        return "Vertical = " + vertical + "; horizontal = " + horizontal;
    }

    ////////////////////////////

    public boolean isNextTo(Coordinates coords){
        if(this.horizontal-coords.horizontal>1||this.horizontal-coords.horizontal<-1){
            return false;
        }
        if(this.vertical-coords.vertical>1||this.vertical-coords.vertical<-1){
            return false;
        }
        return true;
    }

    public void addVector(Coordinates vector){
        this.horizontal+=vector.getHorizontal();
        this.vertical+=vector.getVertical();
    }

    public Coordinates changedVector(int vertical, int horizontal) {
        Coordinates coords = new Coordinates(vertical, horizontal);
        coords.addVector(this);
        return coords;
    }

    public boolean equals(Coordinates coords) {
        if(vertical != coords.getVertical()) {
            return false;
        }
        if(horizontal != coords.getHorizontal()) {
            return false;
        }
        return true;
    }

    public Coordinates neighboursClockwise(int direction) {
        Coordinates coords = new Coordinates(this);
        switch(direction) {
            case 0: coords.addVector(new Coordinates(1, 0));
                break;
            case 1: coords.addVector(new Coordinates(1,1));
                break;
            case 2: coords.addVector(new Coordinates(0,1));
                break;
            case 3: coords.addVector(new Coordinates(-1,1));
                break;
            case 4: coords.addVector(new Coordinates(-1,0));
                break;
            case 5:coords.addVector(new Coordinates(-1,-1));
                break;
            case 6: coords.addVector(new Coordinates(0,-1));
                break;
            case 7:coords.addVector(new Coordinates(1,-1));
                break;
            default:
                break;
        }
        return coords;
    }

    ////////////////////////////

    public void setCoordinates(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public void setCoordinates(Coordinates Coor){
        this.vertical = Coor.getVertical();
        this.horizontal = Coor.getHorizontal();
    }
    
    public void setVertical(int vertical){
        this.vertical = vertical;
    }

    public void setHorizontal(int horizontal){
        this.horizontal = horizontal;
    }
    
    ////////////////////////////

    public int getVertical(){
        return vertical;
    }

    public int getHorizontal(){
        return horizontal;
    }
}