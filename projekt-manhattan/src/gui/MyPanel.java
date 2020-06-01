package gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MyPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 514841987818650670L;
    private BufferedImage obraz;

    public MyPanel (){
        super();
        
        File plik = new File("cute_cat.jpg");
        try {
            obraz = ImageIO.read(plik);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(obraz.getWidth(),obraz.getHeight()));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(obraz,0,0,this);
    }
}