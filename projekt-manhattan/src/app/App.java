package app;

//import map.Byt;
import map.Mapa;

public class App {
    public static void main(String[] args) throws Exception {
        Mapa map = new Mapa(10,20);
        map.wyswietlMape();

        System.out.println(map);
    }
}