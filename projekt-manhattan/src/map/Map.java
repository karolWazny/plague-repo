package map;

import container.Coordinates;
import java.util.List;
import java.util.LinkedList;

public class Map {
    //Pole identyfikujące rozmiar mapy - ilość pól tekstowych w konsoli
    private int length;
    private int width;     
    //Pole będące tablicą obiektów implementujących IPrintable
    private IPrintable[][] table;
    //Puste pole, do którego prowadzą wszystkie referencje z pól, gdzie nic nie ma
    private static EmptySlot empty = new EmptySlot();

    ////////////////////////////

    public Map(int length, int width){
        this.length = length;
        this.width = width;
        table = new IPrintable[this.length][this.width];

        for(int i=0; i<this.length; i++){
            for(int j=0; j<this.width; j++){
                this.table[i][j] = empty;
            }
        }
    }

    ////////////////////////////

    @Override
    public String toString(){
        return "Mapa o rozmiarze: " + this.length + " na " + this.width;
    }

    ////////////////////////////
    //wyswietla mape w konsoli
    public void displayMap(){
        for(int i=0; i<this.length; i++){
            for(int j=0; j<this.width; j++){
                System.out.print(this.table[i][j].getRepresentation());
            }
            System.out.print("\n");
        }
    }

    public List<Coordinates> emptyFieldsList () {
        List<Coordinates> list = new LinkedList<>();
        for(int i = 0; i < length ; i++) {
            for(int j = 0; j < width; j++) {
                if(table[i][j] instanceof EmptySlot) {
                    list.add(new Coordinates(i, j));
                }
            }
        }
        return list;
    }
    ////////////////////////////

    public void setField(IPrintable obj, Coordinates coords){
        if(coords.getVertical()>=this.length) {
            System.out.println("setField exception: coordinates out of range");
            return;
            //Tutaj trzeba te printy zmienić, tak jak mówiliśmy
            //Bo nam mapę spierdzielą
        }
        if(coords.getHorizontal()>=this.width) {
            System.out.println("setField exception: coordinates out of range");
            return;
        }
        if(coords.getVertical()<0||coords.getHorizontal()<0) {
            System.out.println("setField exception: coordinates out of range");
            return;
        }
        table[coords.getVertical()][coords.getHorizontal()] = obj;
    }
    
    public void emptyField(Coordinates coords) {
        setField(empty, coords);
    }

    @Deprecated
    public void setField(IPrintable obj, int vertical, int horizontal) {
        table[vertical][horizontal] = obj;
    }

    ////////////////////////////

	public IPrintable getField(Coordinates newVerHor) {
        if(newVerHor.getVertical()>=this.length) {
            return null;
        }
        if(newVerHor.getHorizontal()>=this.width) {
            return null;
        }
        if(newVerHor.getVertical()<0||newVerHor.getHorizontal()<0) {
            return null;
        }
		return table[newVerHor.getVertical()][newVerHor.getHorizontal()];
    }
    
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}