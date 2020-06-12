package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

/**
 * Klasa ta zapewnia funkcjonalnosc zapisywania do pliku wszystkich danych
 * z przebiegu symulacji. Wykorzystuje informacje zawarte w obiekcie klasy SimulationLog
 * @version 1.0
 * @see app.SimulationLog
 * @see app.SimulationState
 */
public class WriteToFile {
    /**
     * Pole prywatne, ktore zawiera informacje o miejscu doceolwego zapisu. Ciag znakow
     */
    private String FilePath;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt zapisujacy do pliku, ktorego
     * sciezke lub nazwe podajemy w postaci argumentu
     * @param FilePath sciezka lub nazwa pliku
     */
    public WriteToFile(String FilePath){
        this.FilePath = FilePath;
    }

    /**
     * Metoda, konstruktor domyslny, ktora tworzy domyslnie obiekt klasy 
     * zapisujacej do pliku
     */
    public WriteToFile(){
        this.FilePath = "AfterSim.txt";
    }

    /**
     * Metoda, ktora zwraca ciag znakow opisujacy obiekt tej klasy
     * @return ciag znakow opisujacych
     */
    public String toString(){
        return "This object writes data to: " + this.FilePath;
    }

    /**
     * Metoda, ktora konkretnie wykonuje operacje zapisu danych do pliku
     * Wykorzystuje obiekt klasy SimulationLog
     * @param LOG Obiekt z danymi do zapisu
     * @throws FileNotFoundException Wyrzcua wyjatek, gdy nie znajdzie pliku
     */
    public void WriteTheData(SimulationLog LOG) throws FileNotFoundException{
        File file = new File(FilePath);
        PrintWriter out = new PrintWriter(file);
        
        out.print(LOG.toString());

        out.close();
    }
}