package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ramka extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = -1694177375713118479L;

    public Ramka() {
        super("wyświetlamy obrazek");

        JPanel panel = new MyPanel();
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}