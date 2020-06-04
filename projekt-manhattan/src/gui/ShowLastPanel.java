package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import app.Settings;

public class ShowLastPanel extends JPanel{
    private Settings settings;

    private JTextArea tArea;

    public ShowLastPanel(Settings settings){
        this.settings = settings;

        tArea = new JTextArea();
        add(tArea);

        // File last = new File("last_output.txt");

        // try{
        //     Scanner scanner = new Scanner(last);

        //     while(scanner.hasNextLine()){
        //         tArea.append(scanner.nextLine()+'\n');
        //     }
        // } catch (FileNotFoundException e){
        //     tArea.setText("Nothing to show!\nRun simulation, so its output can be viewed here.");
        // }

        String buffer;
        try{
            buffer = new String(Files.readAllBytes(Paths.get("last_output.txt")));
        } catch (Exception e){
            buffer = "Nothing to show!\nRun simulation, so its output can be viewed here.";
        }
        
        tArea.setText(buffer);
        tArea.setEditable(false);
        tArea.setCaretPosition(0);
        setSize(458, 500);
    }
}