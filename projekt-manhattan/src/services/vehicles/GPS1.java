package services.vehicles;

import map.Map;
import container.Coordinates;

public class GPS1 implements IGPS {
    private Map map;
    ////////////////////
    public GPS1(Map map) {
        this.map = map;
    }
    ////////////////////
    @Override
    public Coordinates navigate(Coordinates position, Coordinates destination, int velocity) {
        Coordinates output = new Coordinates(position);
        Coordinates next = new Coordinates(position);
        int verticalToGo = destination.getVertical() - position.getVertical();
        int horizontalToGo = destination.getHorizontal() - position.getHorizontal();
        for (int i = 0; i < velocity; i++) {
            if(verticalToGo != 0) { //jeżeli trzeba jechać w dół (ku wyższym wartościom)
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
                    continue;
                } else {
                    next.addVector(new Coordinates (0, -Integer.signum(horizontalToGo)));
                }
            }
            output.setCoordinates(next);
            if(output.equals(destination)) {
                return output;
            }
        }
        return output;
    }
}