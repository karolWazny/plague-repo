package map;

import java.util.List;
import java.util.ArrayList;

public class BeingContainer {
    private List<IRecord> list;
    
    private Map map;

    public BeingContainer(Map map)
    {
        list = new ArrayList<IRecord>();
        this.map = map;
    }
    
    public List<IRecord> getList()
    {
        return list;
    }

    public Map getMap()
    {
        return map;
    }

    public void performMovementRound()
    {
        Coordinates currentVerHor = new Coordinates(0,0);
        Coordinates newVerHor = new Coordinates(0,0);
        boolean newLocationAccessible;
        for(IRecord obj:list)
        {
            newLocationAccessible = true;
            currentVerHor.setCoordinates(obj.getVerHor());
            obj.move();
            newVerHor.setCoordinates(obj.getVerHor());
            if(map.getLength() <= newVerHor.getVertical() || newVerHor.getVertical() < 0)
            {
                newLocationAccessible = false;
            }
            else if(map.getWidth() <= newVerHor.getHorizontal() || newVerHor.getHorizontal() < 0)
            {
                newLocationAccessible = false;
            }
            else if(map.getField(newVerHor).getId()!="empty")
            {
                newLocationAccessible = false;
            }
            if(!newLocationAccessible)
            {
                obj.setVerHor(currentVerHor);
            } else {
                map.emptyField(currentVerHor);
                map.setField((IPrintable) obj, newVerHor);
            }
        }
    }

    public void performInfectRound() {
        for(IRecord obj:list) {
            obj.infectNeighbours(map);
        }
    }
}