package container;

public interface IMovable {
    public Coordinates move(Coordinates currentPosition); //zwraca wektor przemieszczenia, nie nowe koordynaty!
}