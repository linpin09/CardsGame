/**
 * Created by Lindley on 1/1/2015.
 */
import javax.swing.*;
import java.awt.*;


public class CardTableGUI extends {
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

}
