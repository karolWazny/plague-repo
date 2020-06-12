package services.vehicles;

import map.Map;
import container.Coordinates;

/**
 * Klasa, ktora jest odpowiedzialna za nawigowanie karetkami
 * Posiada informacje o mapie i jej aktualnym stanie
 */
public class GPS1 implements IGPS {
    /** Pole, ktore jest obiektem klasy map - informacje o aktualnej sytuacji na mapie */
    private Map map;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt klasy GPS1
     * @param map mapa, na ktorej dziala GPS
     */
    public GPS1(Map map) {
        this.map = map;
    }

    /**
     * Metoda, ktora nawiguje obiektem
     * @param position aktualna pozycja
     * @param destination cel ruchu
     * @param velocity szybkosć 
     * @return nowe koordynaty
     */
    public Coordinates navigate(Coordinates position, Coordinates destination, int velocity) {

        Coordinates output = new Coordinates(position);
        Coordinates next = new Coordinates(position);

        int verticalToGo = destination.getVertical() - position.getVertical();
        int horizontalToGo = destination.getHorizontal() - position.getHorizontal();

        for (int i = 0; i < velocity; i++) {

            if(verticalToGo != 0) { 
                next.addVector(new Coordinates(Integer.signum(verticalToGo),0));
                if(map.getField(next).getId() == "empty") {
                    verticalToGo -= Integer.signum(verticalToGo);
                    continue;
                } else {
                    next.addVector(new Coordinates(-Integer.signum(verticalToGo),0));
                }
            }

            if(horizontalToGo != 0) {
                next.addVector(new Coordinates(0, Integer.signum(horizontalToGo)));
                if(map.getField(next).getId()=="empty") {
                    horizontalToGo -= Integer.signum(horizontalToGo);
                } else {
                    next.addVector(new Coordinates (0, -Integer.signum(horizontalToGo)));
                }
            }

            output.setCoordinates(next);

            if(Integer.signum(horizontalToGo) * horizontalToGo <= 1 && Integer.signum(verticalToGo) * verticalToGo <= 1) {
                return output;
            }
        }
        return output;
    }

    /**
     * Metoda, getter, ktora zwraca obiekt mapy
     * @return mapa
     */
    public Map getMap(){
        return map;
    }
}