package map;

public abstract class Being implements IPrintable {
    private final String id;
    protected final Character representation;

    ////////////////////////////
    public Being(String id, char representation){
        this.id = id;
        this.representation = representation;
    }

    ////////////////////////////

    @Override
    public String toString(){
        return representation.toString();
    }

    ////////////////////////////

    ////////////////////////////

    @Override
    public String getId() {
        return id;
    }

    @Override
    public char getRepresentation(){
        return representation;
    }
}
