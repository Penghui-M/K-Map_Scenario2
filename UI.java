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
        // Tab
        JTabbedPane tabs = new JTabbedPane();

        JPanel tab_2d = new JPanel();
        JPanel tab_3d = new JPanel();
        JPanel tab_4d = new JPanel();

        tabs.addTab("2D", tab_2d);
        tabs.addTab("3D", tab_3d);
        tabs.addTab("4D", tab_4d);

        // Title
        JLabel title = new JLabel("Karnaugh Map");
        title.setBounds(380, 0, 600, 50);
        title.setFont(titleF);

        // Back
        JButton back = new JButton ("BACK");
        back.setFont(normalT);
        back.setBounds(350, 700, 300, 100);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(title); frame.remove(back);
                menu();
            }
        });  
        frame.add(title); frame.add(back); 
        frame.setVisible(true);
    }


}