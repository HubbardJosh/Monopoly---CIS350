package Monopoly;

import java.awt.*;
import javax.swing.JFrame;

public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Monopoly");
        Board panel = new Board();
        frame.getContentPane().add(panel);


        frame.setPreferredSize(new Dimension(1250, 875));

        frame.setDefaultCloseOperation(3);

        frame.setResizable(true);

        frame.pack();
        frame.setVisible(true);
    }
}
