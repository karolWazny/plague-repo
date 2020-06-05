package container;

import virus.DiseaseRecord;
import map.Being;
import human.IDiseaseSensitive;
import human.IRecoverable;
import map.Map;

/**
 * Klasa, która jest swoistym rekordem w kontenerze bytów.
 * Obiekty tego typu przechowywane są w kontenerze i na nich są wykonywane operacje
 * @version 1.0
 * @see virus.DiseaseRecord
 * @see map.Being
 * @see human.IDiseaseSensitive
 * @see human.IRecoverable
 * @see map.Map
 * @see container.Coordinates
 */
public class  Record implements IRecord {
    /**
     * Pole, w którym przypisywany jest konkretny byt wchodzący do kontenera
     */
    private Being being;
    /**
     * Koordynaty bytu
     */
    private Coordinates position;

    /**
     * Metoda, konstruktor, która tworzy instancję klasy rekord 
     * @param being byt, który wchodzi do rekordu
     * @param position jego koordynaty na mapie
     */
    public Record(Being being, Coordinates position){
        this.being = being;
        this.position = new Coordinates(position);
    }
   
    @Override
    /**
     * Metoda, która na obiektach rekordu wykonuje ruch
     */
    public void move(){
        if(being instanceof IDiseaseSensitive) {
            if(!((IDiseaseSensitive)being).getIsAlive())
            return; //trupy nie chodzą
        }
        if( being instanceof IDiseaseSensitive) {
            if(((IDiseaseSensitive)being).getHealthPoints() < 50)
            return;
        }
        if(being instanceof IMovable){
            IMovable being = (IMovable) this.being;
            position = being.move(position);
        }
    }

    @Override
    /**
     * Metoda, która symuluje zarażanie sąsiadów na mapie, zwraca informację
     * Co wydarzyło się z sąsiednim obiektem
     * @param map mapa przez nas wykorzystywana
     * @return liczba zainfekowanych 
     */
    public int infectNeighbours(Map map){        
        if(!(being instanceof IDiseaseSensitive)) {
            return 0;
        }
        if(!((IDiseaseSensitive)being).getIsAlive()) {
            return 0; 
        }
        Being neighbour;
        int newInfected = 0;
        for(DiseaseRecord disease:((IDiseaseSensitive)being).getDiseases()) {
            for(int i = 0; i<8; i++) {
                neighbour = (Being)map.getField(position.neighboursClockwise(i));
                if(neighbour instanceof IDiseaseSensitive) {
                   newInfected += disease.infect((IDiseaseSensitive)neighbour);
                }
            }
        }
        return newInfected;
    }

    @Override
    /**
     * Metoda, która jest odpowiedzialna za rozwój choroby dla elementów kontenera bytów
     * @return tablica z informacjami
     */
    public int[] progressIllness(){
        int tab[] = {0,0};
        if(!(being instanceof IDiseaseSensitive)) {
            return tab;
        }
        if(!((IDiseaseSensitive)being).getIsAlive()) {
            return tab; 
        }
        if( being instanceof IDiseaseSensitive) {
            if(((IDiseaseSensitive)being).getHealthPoints() < 50)
            tab[1] = 1;
            
        }
        
        tab[0] = ((IDiseaseSensitive)being).performIllness();
        return tab;
    }

    @Override
    /**
     * Metoda, która symuluje zdrowienie obiektu w kontenerze
     */
    public void performRecovery(){
        if(!(being instanceof IRecoverable)) {
            return;
        }
        ((IRecoverable)being).recover();
    }

    @Override
    /**
     * Metoda, setter, która ustawia nową pozycję dla obiektu w kontenerze
     * @param newVerHor nowe koordynaty
     * @return nowe koordynaty
     */
    public void setVerHor(Coordinates newVerHor){
        if(newVerHor == null){
            position = null;
            return;
        }
        position = new Coordinates(newVerHor);
    }

    @Override
    /**
     * Metoda, getter, która zwraca aktualne koordynaty
     * @return aktualne koordynaty
     */
    public Coordinates getVerHor(){
        return position;
    }

    @Override
    /**
     * Metoda, getter, która zwraca byt w rekordzie
     * @return byt w rekordzie
     */
    public Being getBeing(){
        return being;
    }
}