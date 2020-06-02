package gui;

import map.Map;
import app.Simulation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Ramka extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = -1694177375713118479L;
    Simulation sim;
    JPanel panel;

    public Ramka(Simulation sim) {
        super("wyświetlamy obrazek");
        this.sim = sim;

        panel = new PanelMap(sim.getMap());
        add(panel);
        JButton next = new JButton("next");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}