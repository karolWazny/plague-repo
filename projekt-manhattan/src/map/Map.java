package map;

public class Map {
    //Pole identyfikujące rozmiar mapy - ilość pól tekstowych w konsoli
    private int length;
    private int width;     
    
    //Pole będące tablicą obiektów implementujących IPrintable
    
    private IPrintable[][] table;

    //Konstruktor mapy
    public Map(int length, int width){
        this.length = length;
        this.width = width;
        table = new IPrintable[this.length][this.width];

        for(int i=0; i<this.length; i++){
            for(int j=0; j<this.width; j++){
                this.table[i][j] = new EmptySlot();
            }
        }
    }
    @Override
    public String toString(){
        return "Mapa o rozmiarze: " + this.length + " na " + this.width;
    }

    public void displayMap(){
        for(int i=0; i<this.length; i++){
            for(int j=0; j<this.width; j++){
                System.out.print(this.table[i][j].toString());
            }
            System.out.print("\n");
        }
    }
}