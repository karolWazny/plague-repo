package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

/**
 * Klasa ta zapewnia funkcjonalność zapisywania do pliku wszystkich danych
 * z przebiegu symulacji. Wykorzystuje informacje zawarte w obiekcie klasy SimulationLog
 * @version 1.0
 * @see app.SimulationLog
 * @see app.SimulationState
 */
public class WriteToFile {
    /**
     * Pole prywatne, które zawiera informację o miejscu doceolwego zapisu. Ciąg znaków
     */
    private String FilePath;

    /**
     * Metoda, konstruktor, która tworzy obiekt zapisujący do pliku, którego
     * ścieżkę lub nazwę podajemy w postaci argumentu
     * @param FilePath ścieżka lub nazwa pliku
     */
    public WriteToFile(String FilePath){
        this.FilePath = FilePath;
    }

    /**
     * Metoda, konstruktor domyślny, która tworzy domyślnie obiekt klasy 
     * zapisującej do pliku
     */
    public WriteToFile(){
        this.FilePath = "AfterSim.txt";
    }

    /**
     * Metoda, która zwraca ciąg znaków opisujący obiekt tej klasy
     * @return ciąg znaków opisujących
     */
    public String toString(){
        return "This object writes data to: " + this.FilePath;
    }

    /**
     * Metoda, która konkretnie wykonuje operację zapisu danych do pliku
     * Wykorzystuje obiekt klasy SimulationLog
     * @param LOG Obiekt z danymi do zapisu
     * @throws FileNotFoundException Wyrzcua wyjątek, gdy nie znajdzie pliku
     */
    public void WriteTheData(SimulationLog LOG) throws FileNotFoundException{
        File file = new File(FilePath);
        PrintWriter out = new PrintWriter(file);
        
        out.print(LOG.toString());

        out.close();
    }
}