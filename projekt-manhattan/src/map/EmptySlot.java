package map;

/**
 * Klasa pustego pola na mapie
 * Jego reprezentacja znakowa jest spacja
 * @version 1.0
 * @see map.Being
 */
public final class EmptySlot extends Being {
    /**
     * Metoda konstruktor pustego pola w konsoli, wykorzystuje konstruktor bytu
     * @see map.Being
     */
    public EmptySlot() {
        super("empty", ' ');
    }
}