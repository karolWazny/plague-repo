package container;

/**
 * Klasa, której obiekty posiadają wszelkie informacje dotyczące
 * szeroko pojętych koordynatów, poza tym metody umożliwiają zmianę tychże
 * koordynatów, przesunięcia o wektor, itd...
 * @version 1.0
 */
public class Coordinates {
    /**
     * Pole, które posiada informację o współrzędnej Y
     */
    private int vertical;
    /**
     * Pole, które posiada informację o współrzędnej X
     */
    private int horizontal;
    
    /**
     * Metoda, konstruktor, która tworzy instancję klasy koordynaty
     * @param vertical współrzędna Y
     * @param horizontal współrzędna X
     */
    public Coordinates(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    /**
     * Metoda, konstruktor domyślny, który ustawia współrzędne na początek układu współrzędnych
     */
    public Coordinates() {
        this(0, 0);
    }

    /**
     * Metoda, konstruktor, która tworzy obiekt klasy koordynaty na wzór innej instancji
     * @param Coor inna instancja klasy koordynaty
     */
    public Coordinates(Coordinates Coor){
        if(Coor == null){
            return;
        }
        this.vertical = Coor.getVertical();
        this.horizontal = Coor.getHorizontal();
    }

    @Override
    /**
     * Metoda, która zwraca ciąg znaków opisujący obiekt typu koordynaty
     * @return ciąg znaków opisowych
     */
    public String toString(){
        return "Vertical = " + vertical + "; horizontal = " + horizontal;
    }

    /**
     * Metoda, która zwraca stan logiczny i odpowiada na pytanie:
     * Czy można przejść w docelowe miejsce?
     * @param coords koordynaty celu
     * @return stan logiczny odpowiadający na pytanie z opisu metody
     */
    public boolean isNextTo(Coordinates coords){
        if(this.horizontal-coords.horizontal>1||this.horizontal-coords.horizontal<-1){
            return false;
        }
        if(this.vertical-coords.vertical>1||this.vertical-coords.vertical<-1){
            return false;
        }
        return true;
    }

    /**
     * Metoda, która pozwala wykonać przesunięcie o wektor
     * @param vector Wektor, o który chcemy przesunąć
     */
    public void addVector(Coordinates vector){
        this.horizontal+=vector.getHorizontal();
        this.vertical+=vector.getVertical();
    }

    /**
     * Metoda, która wykorzystuje metodę addVector do przesunięcia o wektor, 
     * ale z wykorzystaniem konkretnych wartości liczbowych wektora
     * @param vertical składowa wektora Y
     * @param horizontal składowa wektora X
     * @return Obiekt koordynat po przesunięciu o wektor
     */
    public Coordinates changedVector(int vertical, int horizontal) {
        Coordinates coords = new Coordinates(vertical, horizontal);
        coords.addVector(this);
        return coords;
    }

    /**
     * Metoda, która porównuje dwa obiektu tej klasy
     * @param coords porównywany koordynat
     * @return stan logiczny, który odpowiada na pytanie: czy są równe?
     */
    public boolean equals(Coordinates coords) {
        if(vertical != coords.getVertical()) {
            return false;
        }
        if(horizontal != coords.getHorizontal()) {
            return false;
        }
        return true;
    }

    /**
     * Metoda, która zgodnie z ruchem wskazówek zegara sprawdza, czy w zależności od 
     * wylosowanej liczby w danym miejscu jest sąsiad i czy możliwe jest przesunięcie
     * obiektu w dane miejsce. Zwraca koordynaty nowego miejsca, bądź starego jeśli nie można
     * @param direction wylosowana wartość celu
     * @return koordynaty nowe
     */
    public Coordinates neighboursClockwise(int direction) {
        Coordinates coords = new Coordinates(this);
        switch(direction) {
            case 0: coords.addVector(new Coordinates(1, 0));
                break;
            case 1: coords.addVector(new Coordinates(1,1));
                break;
            case 2: coords.addVector(new Coordinates(0,1));
                break;
            case 3: coords.addVector(new Coordinates(-1,1));
                break;
            case 4: coords.addVector(new Coordinates(-1,0));
                break;
            case 5:coords.addVector(new Coordinates(-1,-1));
                break;
            case 6: coords.addVector(new Coordinates(0,-1));
                break;
            case 7:coords.addVector(new Coordinates(1,-1));
                break;
            default:
                break;
        }
        return coords;
    }

    /**
     * Metoda, setter, która ustawia koordynaty na konkretne wartości liczbowe
     * @param vertical składowa Y
     * @param horizontal składowa X
     */
    public void setCoordinates(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    /**
     * Metoda, setter, która ustawia koordynaty w miejscu innego obiektu koordynaty
     * @param Coor inny obiekt tego samego typu
     */
    public void setCoordinates(Coordinates Coor){
        this.vertical = Coor.getVertical();
        this.horizontal = Coor.getHorizontal();
    }
    
    /**
     * Metoda, setter, która ustawia składową Y koordynatów
     * @param vertical składowa Y
     */
    public void setVertical(int vertical){
        this.vertical = vertical;
    }

    /**
     * Metoda, setter, która ustawia składową X koordynatów
     * @param horizontal składowa X
     */
    public void setHorizontal(int horizontal){
        this.horizontal = horizontal;
    }

    /**
     * Metoda, getter, która zwraca wartość składowej Y koordynatu
     * @return składowa Y
     */
    public int getVertical(){
        return vertical;
    }

    /**
     * Metoda, getter, która zwraca wartość składowej X koordynatu
     * @return
     */
    public int getHorizontal(){
        return horizontal;
    }
}