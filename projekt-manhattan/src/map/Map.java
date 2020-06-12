package map;

import container.Coordinates;
import java.util.List;
import java.util.LinkedList;

/**
 * Klasa zawierajaca wszystkie informacje potrzebne do wyswietlenia na mapie
 * Instancja tej klasy - obiekt mapa
 * @version 1.0
 * @see container.Coordinates
 * @see map.IPrintable
 */
public class Map {
    /**
     * Dlugosc obszaru reprezentujacego mape
     */
    private int length;
    /**
     * Szerokosc obszaru reprezentujacego mape
     */
    private int width;
    /**
     * Pole bedace tablica obiektow implementujacych IPrintable
     */     
    private IPrintable[][] table;
    /**
     * Puste pole, do ktorego prowadza wszystkie referencje z pol, gdzie nic nie ma
     */
    private static EmptySlot empty = new EmptySlot();

    /**
     * Metoda, konstruktor, ktora tworzy instancje klasy mapa
     * W tablicy pol pierwotnie umieszcza puste pola
     * @param length dlugosc obszaru reprezentujacego mape
     * @param width szerokosc obszaru reprezentujacego mape
     */
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

    //@Override
    /**
     * Metoda, ktora zwraca reprezentacje tekstowa instancji klasy mapa
     * @return ciag znakowy z informacjami o instancji klasy
     */
    public String toString(){
        return "Mapa o rozmiarze: " + this.length + " na " + this.width;
    }

    /**
     * Metoda, ktora wyswietla mape w konsoli
     */
    public void displayMap(){
        for(int i=0; i<this.length; i++){
            for(int j=0; j<this.width; j++){
                System.out.print(this.table[i][j].getRepresentation());
            }
            System.out.print("\n");
        }
    }

    /**
     * Metoda zwracajaca liste obiektow klasy container.Coordinates bedacych 
     * pustymi polami na mapie
     * @return Lista koordynatow
     */
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

    /**
     * Metoda ustawiajaca na mapie w konkretnym miejscu obiekt 
     * implementujacy interfejs IPrintable
     * @param obj obiekt umieszczany na mapie
     * @param coords koordynaty miejsca, w ktorym chcemy obiekt ustawic
     */
    public void setField(IPrintable obj, Coordinates coords){
        if(coords == null){
            return;
        }
        if(coords.getVertical()>=this.length) {
            System.out.println("setField exception: coordinates out of range");
            return;
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
    
    /**
     * Metoda, ktora w konkretnym miejscu ustawia puste pole
     * @param coords koordynaty nowego pustego pola
     */
    public void emptyField(Coordinates coords) {
        setField(empty, coords);
    }

    @Deprecated
    /**
     * Metoda, ktorej uzywalismy przed wprowadzeniem klasy container.Coordinates
     * do umieszczania obiektow na mapie
     * @param obj obiekt do umieszczenia
     * @param vertical wspolrzedna Y
     * @param horizontal wspolrzedna X
     */
    public void setField(IPrintable obj, int vertical, int horizontal) {
        table[vertical][horizontal] = obj;
    }

    /**
     * Metoda, ktora przeksztalca reprezentacje koordynatow
     * @param newVerHor Nowe koordynaty
     * @return tablica ze wspolrzednymi X i Y
     */
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
    
    /**
     * Metoda getter, ktora zwraca dlugosc konkretnej instancji mapy
     * @return dlugosc mapy
     */
    public int getLength() {
        return length;
    }

    /**
     * Metoda getter, ktora zwraca szerokosc mapy
     * @return szerokosc mapy
     */
    public int getWidth() {
        return width;
    }
}