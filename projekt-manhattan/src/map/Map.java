package map;

public class Map {
    //Pole identyfikujące rozmiar mapy - ilość pól tekstowych w konsoli
    private int length;
    private int width;     
    
    //Pole będące tablicą obiektów typu Byt
    public IPrintable[][] table;

    //Konstruktor mapy
    public Map(int dlugosc, int szerokosc){
        this.length = dlugosc;
        this.width = szerokosc;
        table = new Being[this.length][this.width];

        for(int i=0; i<this.length; i++){
            for(int j=0; j<this.width; j++){
                this.table[i][j] = new Man("0");
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
                System.out.print(this.table[i][j]);
            }
            System.out.print("\n");
        }
    }
}