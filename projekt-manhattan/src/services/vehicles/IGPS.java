package services.vehicles;

import container.Coordinates;

public interface IGPS {
    public Coordinates navigate(Coordinates position, Coordinates destination, int velocity);
}