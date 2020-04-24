package map;

public class Map {
    //Pole identyfikujące rozmiar mapy - ilość pól tekstowych w konsoli
    private int length;
    private int width;     
    
    //Pole będące tablicą obiektów implementujących IPrintable
    
    private IPrintable[][] table;

    //Puste pole, do którego prowadzą wszystkie referencje z pól, gdzie nic nie ma

    private static EmptySlot empty = new EmptySlot();

    //Konstruktor mapy
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
    @Override
    public String toString(){
        return "Mapa o rozmiarze: " + this.length + " na " + this.width;
    }

    //wyswietla mape w konsoli

    public void displayMap(){
        for(int i=0; i<this.length; i++){
            for(int j=0; j<this.width; j++){
                System.out.print(this.table[i][j].getRepresentation());
            }
            System.out.print("\n");
        }
    }

    //setter i getter pola

    public void setField(IPrintable obj, Coordinates coords)
    {
        table[coords.getVertical()][coords.getHorizontal()] = obj;
    }

    @Deprecated
    public void setField(IPrintable obj, int vertical, int horizontal)
    {
        table[vertical][horizontal] = obj;
    }

	public IPrintable getField(Coordinates newVerHor) {
		return table[newVerHor.getVertical()][newVerHor.getHorizontal()];
    }

    public void emptyField(Coordinates coords) {
        setField(empty, coords);
    }
    
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}