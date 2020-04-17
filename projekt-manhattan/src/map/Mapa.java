package map;

public class Mapa {
    //Pole identyfikujące rozmiar mapy - ilość pól tekstowych w konsoli
    private int dlugosc;
    private int szerokosc;     
    
    //Pole będące tablicą obiektów typu Byt
    public Byt[][] tablica;

    //Konstruktor mapy
    public Mapa(int dlugosc, int szerokosc){
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        tablica = new Byt[this.dlugosc][this.szerokosc];

        for(int i=0; i<this.dlugosc; i++){
            for(int j=0; j<this.szerokosc; j++){
                this.tablica[i][j] = new Byt("0");
            }
        }
    }
    @Override
    public String toString(){
        return "Mapa o rozmiarze: " + this.dlugosc + " na " + this.szerokosc;
    }

    public void wyswietlMape(){
        for(int i=0; i<this.dlugosc; i++){
            for(int j=0; j<this.szerokosc; j++){
                System.out.print(this.tablica[i][j]);
            }
            System.out.print("\n");
        }
    }
}