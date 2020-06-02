package gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
    public MainFrame(){
        super("Plague Simulation: Project Manhattan");

        add(new MainMenu());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}