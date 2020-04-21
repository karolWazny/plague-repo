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

    public IPrintable getField(int vertical, int horizontal)
    {
        return table[vertical][horizontal];
    }

    public IPrintable getField(int[] verHor)
    {
        return table[verHor[0]][verHor[1]];
    }

    public void setField(IPrintable obj, int[] verHor)
    {
        table[verHor[0]][verHor[1]] = obj;
    }

    public void setField(IPrintable obj, int ver, int hor)
    {
        table[ver][hor] = obj;
    }
}