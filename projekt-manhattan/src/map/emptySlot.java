package map;

public final class EmptySlot implements IPrintable {

    private final Character reprezentation;

    private final static String id = "puste pole";
    
    public EmptySlot() {
     reprezentation = '#';
    }

    @Override
    public String toString() {
        return reprezentation.toString();
    }

    public String getId() {
        return id;
    }
}