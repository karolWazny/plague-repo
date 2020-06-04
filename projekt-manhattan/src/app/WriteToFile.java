package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

public class WriteToFile {
    private String FilePath;

    public WriteToFile(String FilePath){
        this.FilePath = FilePath;
    }

    public WriteToFile(){
        this.FilePath = "AfterSim.txt";
    }

    @Override
    public String toString(){
        return "This object writes data to: " + this.FilePath;
    }

    public void WriteTheData(SimulationLog LOG) throws FileNotFoundException{
        File file = new File(FilePath);
        PrintWriter out = new PrintWriter(file);
        
        out.print(LOG.toString());

        out.close();
    }
}