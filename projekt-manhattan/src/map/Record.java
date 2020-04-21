package map;

public abstract class Record {
    private Being being;
    private int vertical;
    private int horizontal;

    public Record(Being being, int vertical, int horizontal) 
    {
        this.being = being;
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public Being getBeing()
    {
        return being;
    }

    public int[] getVerHor()
    {
        int location[] = new int[] {vertical, horizontal};
        return location;
    }
}