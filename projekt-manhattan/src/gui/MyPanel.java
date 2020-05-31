package gui;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;

public class MyPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 514841987818650670L;
    private BufferedImage obraz;

    public MyPanel (){
        super();
        
        File plik = new File("cute_cat.jpg");
    }
}