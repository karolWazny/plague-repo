package map;

import container.Coordinates;
import java.util.List;
import java.util.LinkedList;

/**
 * Klasa zawierająca wszystkie informacje potrzebne do wyświetlenia na mapie
 * Instancja tej klasy - obiekt mapa
 * @version 1.0
 * @see container.Coordinates
 * @see map.IPrintable
 */
public class Map {
    /**
     * Długość obszaru reprezentującego mapę
     */
    private int length;
    /**
     * Szerokość obszaru reprezentującego mapę
     */
    private int width;
    /**
     * Pole będące tablicą obiektów implementujących IPrintable
     */     
    private IPrintable[][] table;
    /**
     * Puste pole, do którego prowadzą wszystkie referencje z pól, gdzie nic nie ma
     */
    private static EmptySlot empty = new EmptySlot();

    /**
     * Metoda, konstruktor, która tworzy instancję klasy mapa
     * W tablicy pól pierwotnie umieszcza puste pola
     * @param length długość obszaru reprezentującego mapę
     * @param width szerokość obszaru reprezentującego mapę
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
     * Metoda, która zwraca reprezentację tekstową instancji klasy mapa
     * @return ciąg znakowy z informacjami o instancji klasy
     */
    public String toString(){
        return "Mapa o rozmiarze: " + this.length + " na " + this.width;
    }

    /**
     * Metoda, która wyświetla mapę w konsoli
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
     * Metoda zwracająca listę obiektów klasy container.Coordinates będących 
     * pustymi polami na mapie
     * @return Lista koordynatów
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
     * Metoda ustawiająca na mapie w konkretnym miejscu obiekt 
     * implementujący interfejs IPrintable
     * @param obj obiekt umieszczany na mapie
     * @param coords koordynaty miejsca, w którym chcemy obiekt ustawić
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
     * Metoda, która w konkretnym miejscu ustawia puste pole
     * @param coords koordynaty nowego pustego pola
     */
    public void emptyField(Coordinates coords) {
        setField(empty, coords);
    }

    @Deprecated
    /**
     * Metoda, której używaliśmy przed wprowadzeniem klasy container.Coordinates
     * do umieszczania obiektów na mapie
     * @param obj obiekt do umieszczenia
     * @param vertical współrzędna Y
     * @param horizontal współrzędna X
     */
    public void setField(IPrintable obj, int vertical, int horizontal) {
        table[vertical][horizontal] = obj;
    }

    /**
     * Metoda, która przekształca reprezentację koordynatów
     * @param newVerHor Nowe koordynaty
     * @return tablica ze współrzędnymi X i Y
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
     * Metoda getter, która zwraca długość konkretnej instancji mapy
     * @return długość mapy
     */
    public int getLength() {
        return length;
    }

    /**
     * Metoda getter, która zwraca szerokość mapy
     * @return szerokość mapy
     */
    public int getWidth() {
        return width;
    }
}