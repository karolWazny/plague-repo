package services.vehicles;

import container.Coordinates;
import map.Map;

public interface IGPS {
    public Coordinates navigate(Coordinates position, Coordinates destination, int velocity);
    public Map getMap();
}