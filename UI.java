import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* Documentation:
 * JFrame <name> = new Jframe(<name>)     -- Initializes a window
    * .setSize(<width>, <height>);
    * .setLayout(<read documentation>);
    * .add(<Items>);      -- add items such as labels, textfields, buttons...
 * JLabel <name> = new JLabel(<Text as String>);    -- Initializes a label
    * .setBounds(<x>, <y>, <width>, <height>);

 * JButton <name> = new JButton(<button label>);
    * .setBounds(<x>, <y>, <width>, <height>);
    * addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                <Action performed when button pressed>
            }
 */

public class UI {
    JFrame frame = new JFrame("K-Map");
    Font titleF = new Font("serif", Font.BOLD, 36);
    Font normalT = new Font("serif", Font.BOLD, 20);

	public void run() {
        // setting up     
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu();

	}

    public void menu() {
        // Title
        JLabel title = new JLabel("Karnaugh Map for COMP0003");
        title.setBounds(250, 0, 600, 50);
        title.setFont(titleF);

        // Exit
        JButton exit = new JButton ("EXIT");
        exit.setFont(normalT);
        exit.setBounds(350, 500, 300, 100);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        // K-map
        JButton kmap = new JButton ("KARNAUGH MAP");
        kmap.setFont(normalT);
        kmap.setBounds(350, 300, 300, 100);
        kmap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(title); frame.remove(exit); frame.remove(kmap);
                kMap();
            }
        });
        frame.add(exit); frame.add(kmap); frame.add(title);    
        frame.setVisible(true);
    }

    public void kMap() {
        // Title
        JLabel title = new JLabel("Karnaugh Map");
        title.setBounds(380, 0, 600, 50);
        title.setFont(titleF);

        // 2D
        JButton d2 = new JButton("2D");
        d2.setFont(normalT);
        d2.setBounds(200, 70, 200, 30);
        d2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                twoDimension();
            }
        });

        // 3D
        JButton d3 = new JButton("3D");
        d3.setFont(normalT);
        d3.setBounds(400, 70, 200, 30);
        d3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                threeDimension();
            }
        });

        // 4D
        JButton d4 = new JButton("4D");
        d4.setFont(normalT);
        d4.setBounds(600, 70, 200, 30);
        d4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                fourDimension();
            }
        });

        // Back
        JButton back = new JButton ("BACK");
        back.setFont(normalT);
        back.setBounds(350, 800, 300, 50);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(title); frame.remove(back); frame.remove(d2); frame.remove(d3); frame.remove(d4); 
                menu();
            }
        });

        frame.add(title); frame.add(back); frame.add(d2); frame.add(d3); frame.add(d4);
        frame.setVisible(true);
    }

    public void twoDimension() {
        frame.setVisible(true);
    }

    public void threeDimension() {
        frame.setVisible(true);
    }

    public void fourDimension() {
        frame.setVisible(true);
    }


}