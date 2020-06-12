package container;

/**
 * Klasa, ktorej obiekty posiadaja wszelkie informacje dotyczace
 * szeroko pojetych koordynatow, poza tym metody umozliwiaja zmiane tychze
 * koordynatow, przesuniecia o wektor, itd...
 * @version 1.0
 */
public class Coordinates {
    /**
     * Pole, ktore posiada informacje o wspolrzednej Y
     */
    private int vertical;
    /**
     * Pole, ktore posiada informacje o wspolrzednej X
     */
    private int horizontal;
    
    /**
     * Metoda, konstruktor, ktora tworzy instancje klasy koordynaty
     * @param vertical wspolrzedna Y
     * @param horizontal wspolrzedna X
     */
    public Coordinates(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    /**
     * Metoda, konstruktor domyslny, ktory ustawia wspolrzedne na poczatek ukladu wspolrzednych
     */
    public Coordinates() {
        this(0, 0);
    }

    /**
     * Metoda, konstruktor, ktora tworzy obiekt klasy koordynaty na wzor innej instancji
     * @param Coor inna instancja klasy koordynaty
     */
    public Coordinates(Coordinates Coor){
        if(Coor == null){
            return;
        }
        this.vertical = Coor.getVertical();
        this.horizontal = Coor.getHorizontal();
    }

    //@Override
    /**
     * Metoda, ktora zwraca ciag znakow opisujacy obiekt typu koordynaty
     * @return ciag znakow opisowych
     */
    public String toString(){
        return "Vertical = " + vertical + "; horizontal = " + horizontal;
    }

    /**
     * Metoda, ktora zwraca stan logiczny i odpowiada na pytanie:
     * Czy mozna przejsc w docelowe miejsce?
     * @param coords koordynaty celu
     * @return stan logiczny odpowiadajacy na pytanie z opisu metody
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
     * Metoda, ktora pozwala wykonac przesuniecie o wektor
     * @param vector Wektor, o ktory chcemy przesunac
     */
    public void addVector(Coordinates vector){
        this.horizontal+=vector.getHorizontal();
        this.vertical+=vector.getVertical();
    }

    /**
     * Metoda, ktora wykorzystuje metode addVector do przesuniecia o wektor, 
     * ale z wykorzystaniem konkretnych wartosci liczbowych wektora
     * @param vertical skladowa wektora Y
     * @param horizontal skladowa wektora X
     * @return Obiekt koordynat po przesunieciu o wektor
     */
    public Coordinates changedVector(int vertical, int horizontal) {
        Coordinates coords = new Coordinates(vertical, horizontal);
        coords.addVector(this);
        return coords;
    }

    /**
     * Metoda, ktora porownuje dwa obiektu tej klasy
     * @param coords porownywany koordynat
     * @return stan logiczny, ktory odpowiada na pytanie: czy sa rowne?
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
     * Metoda, ktora zgodnie z ruchem wskazowek zegara sprawdza, czy w zaleznosci od 
     * wylosowanej liczby w danym miejscu jest sasiad i czy mozliwe jest przesuniecie
     * obiektu w dane miejsce. Zwraca koordynaty nowego miejsca, badz starego jesli nie mozna
     * @param direction wylosowana wartosc celu
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
     * Metoda, setter, ktora ustawia koordynaty na konkretne wartosci liczbowe
     * @param vertical skladowa Y
     * @param horizontal skladowa X
     */
    public void setCoordinates(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    /**
     * Metoda, setter, ktora ustawia koordynaty w miejscu innego obiektu koordynaty
     * @param Coor inny obiekt tego samego typu
     */
    public void setCoordinates(Coordinates Coor){
        this.vertical = Coor.getVertical();
        this.horizontal = Coor.getHorizontal();
    }
    
    /**
     * Metoda, setter, ktora ustawia skladowa Y koordynatow
     * @param vertical skladowa Y
     */
    public void setVertical(int vertical){
        this.vertical = vertical;
    }

    /**
     * Metoda, setter, ktora ustawia skladowa X koordynatow
     * @param horizontal skladowa X
     */
    public void setHorizontal(int horizontal){
        this.horizontal = horizontal;
    }

    /**
     * Metoda, getter, ktora zwraca wartosc skladowej Y koordynatu
     * @return skladowa Y
     */
    public int getVertical(){
        return vertical;
    }

    /**
     * Metoda, getter, ktora zwraca wartosc skladowej X koordynatu
     * @return
     */
    public int getHorizontal(){
        return horizontal;
    }
}