package map;

public final class EmptySlot implements IPrintable {

    private final static Character representation = '#';

    private final static String id = "puste pole";
    
    public EmptySlot() {
    }

    @Override
    public String toString() {
        return representation.toString();
    }

    public String getId() {
        return id;
    }
}