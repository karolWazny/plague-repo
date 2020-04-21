package map;

import java.util.List;
import java.util.ArrayList;

public class BeingContainer {
    private List<IMapable> list;
    
    private Map map;

    public BeingContainer(Map map)
    {
        list = new ArrayList<IMapable>();
        this.map = map;
    }
    
    public List<IMapable> getList()
    {
        return list;
    }

    public Map getMap()
    {
        return map;
    }

    public void performMovementRound()
    {
        Coordinates currentPosition = new Coordinates();
        Coordinates newPosition = new Coordinates();
        boolean newLocationAccessible = true;
        for(IMapable obj:list)
        {
            currentPosition.setCoordinates(obj.getCoordinates());
            obj.move();
            newPosition.setCoordinates(obj.getCoordinates());
            if(map.getLength() <= newPosition.getVertical() || newPosition.getVertical() < 0)
            {
                newLocationAccessible = false;
            }
            else if(map.getWidth() <= newPosition.getHorizontal() || newPosition.getHorizontal() < 0)
            {
                newLocationAccessible = false;
            }
            else if(map.getField(newPosition).getId()!="empty")
            {
                newLocationAccessible = false;
            }
            if(!newLocationAccessible)
            {
                obj.setCoordinates(currentPosition);;
            }
        }
    }
}