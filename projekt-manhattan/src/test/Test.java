package test;
import map.Map;
import map.Man;

public class Test {
    public static void main(String[] Args) {
        Man ludek1 = new Man();
        Man ludek2 = new Man();
        Map mapa = new Map(10, 20);
        System.out.println(ludek1.getId());
        System.out.println(ludek2.getId());
        mapa.displayMap();
    }
}