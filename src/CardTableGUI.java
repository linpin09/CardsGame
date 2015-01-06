/**
 * Created by Lindley on 1/1/2015.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.peer.MouseInfoPeer;
import java.io.IOException;
import java.net.URL;
import java.awt.Image;


public class CardTableGUI extends JApplet implements KeyListener, MouseListener {

    BufferedImage img;
    ImagePanel mainPanel;


    public void init() {

        img = getImage("table.png");
        mainPanel = new ImagePanel(img, this.getWidth() / 2
                - img.getWidth() / 2, this.getHeight() / 2 - img.getHeight() / 2);
        mainPanel.setBackground(new Color(0, 100, 0)); //Green

        this.setContentPane(mainPanel);
        this.setSize(800, 800);
        addMouseListener(this);
        addKeyListener(this);
        Graphics g = this.getGraphics();
        //g.drawImage(img, this.getWidth(), this.getHeight() , null);
        //repaint();

    }
    public BufferedImage getImage(String name){
        BufferedImage img = null;

        try {
            URL imgUrl = getClass().getClassLoader().getResource("resources/" + name);
            ImageIcon icon = new ImageIcon(imgUrl);
            img = ImageIO.read(imgUrl);//icon.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }



    public void keyReleased(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) {

    }
    public boolean isWindowUnderMouse(Window w) {
        return true;
    }
    public int fillPointWithCoords(Point p) {
        return 0;
    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {

    }

    /*
    private static final Dimension d = new Dimension(700, 700);

    public static void drawGUI() {

        //Graphics g = new Graphics2D();
        JFrame frame = new JFrame("Cards");
        Container c = new Container();

        frame.setDefaultCloseOperation(3);


        //
        c.setMinimumSize(d);
        c.setBackground(Color.GREEN);
        //
        frame.setSize(d);
        frame.setMinimumSize(d);
        frame.setForeground(Color.GREEN);
        frame.setContentPane(c);


        //draw
        frame.pack();
        frame.setVisible(true);
    }
    */
}
