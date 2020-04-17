package app;

public class Mapa {
    //Pole identyfikujące rozmiar mapy - ilość pól tekstowych w konsoli
    private int rozmiar;     
    
    //Pole będące tablicą obiektów typu Byt
    public app.Byt[][] tablica;

    //Konstruktor mapy
    public Mapa(int rozmiar){
        this.rozmiar = rozmiar;
    
        tablica = new app.Byt[this.rozmiar][this.rozmiar];

        for(int i=0; i<this.rozmiar; i++){
            for(int j=0; j<this.rozmiar; j++){
                this.tablica[i][j] = new Byt("0");
            }
        }
    }

    public String toString(){
        return "Mapa o rozmiarze: " + this.rozmiar + " na " + this.rozmiar;
    }

    public void wyswietl_Mape(){
        for(int i=0; i<this.rozmiar; i++){
            for(int j=0; j<this.rozmiar; j++){
                System.out.print(this.tablica[i][j]);
            }
            System.out.print("\n");
        }
    }
}