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
    Font big = new Font("serif", Font.BOLD, 30);
     
    // Buttons for the k-map
    /*
     * Table Combinations (Depending on the variables their size and position will vary)
     *  1 2  |   1 2  |   1 2 3
     *  3 4  |   3 4  |   4 5 6
     *       |   5    |   7 8 9
     *       |   6 
     * 
     */
    JButton r1 = new JButton("0");
    JButton r2 = new JButton("0");
    JButton r3 = new JButton("0");
    JButton r4 = new JButton("0");
    JButton r5 = new JButton("0");
    JButton r6 = new JButton("0");
    JButton r7 = new JButton("0");
    JButton r8 = new JButton("0");
    JButton r9 = new JButton("0");

    // Sets all table values
    public void initializeTable() {
        // Text
        r1.setFont(big);
        r2.setFont(big);
        r3.setFont(big);
        r4.setFont(big);
        r5.setFont(big);
        r6.setFont(big);
        r7.setFont(big);
        r8.setFont(big);
        r9.setFont(big);

        r1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r1.getText().equals("0")) {
                    r1.setText("1");
                } else {
                    r1.setText("0");
                } 
            }
        });

        r2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r2.getText().equals("0")) {
                    r2.setText("1");
                } else {
                    r2.setText("0");
                } 
            }
        });

        r3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r3.getText().equals("0")) {
                    r3.setText("1");
                } else {
                    r3.setText("0");
                } 
            }
        });

        r4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r4.getText().equals("0")) {
                    r4.setText("1");
                } else {
                    r4.setText("0");
                } 
            }
        });

        r5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r5.getText().equals("0")) {
                    r5.setText("1");
                } else {
                    r5.setText("0");
                } 
            }
        });

        r6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r6.getText().equals("0")) {
                    r6.setText("1");
                } else {
                    r6.setText("0");
                } 
            }
        });

        r7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r7.getText().equals("0")) {
                    r7.setText("1");
                } else {
                    r7.setText("0");
                } 
            }
        });

        r8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r8.getText().equals("0")) {
                    r8.setText("1");
                } else {
                    r8.setText("0");
                } 
            }
        });

        r9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r9.getText().equals("0")) {
                    r9.setText("1");
                } else {
                    r9.setText("0");
                } 
            }
        });
    }


    public void removeTable() {
        // resets all texts
        r1.setText("0"); r2.setText("0"); r3.setText("0");
        r4.setText("0"); r5.setText("0"); r6.setText("0");
        r7.setText("0"); r8.setText("0"); r9.setText("0");

        frame.remove(r1); frame.remove(r2); frame.remove(r3); frame.remove(r4); frame.remove(r5);
        frame.remove(r6); frame.remove(r7); frame.remove(r8); frame.remove(r9);
    }

	public void run() {
        // setting up     
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initializeTable();
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

        // 2 Variable
        JButton v2 = new JButton("2 Variable");
        v2.setFont(normalT);
        v2.setBounds(200, 70, 200, 30);
        v2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                removeTable();
                twoVariable();
            }
        });

        // 3 Variable
        JButton v3 = new JButton("3 Variable");
        v3.setFont(normalT);
        v3.setBounds(400, 70, 200, 30);
        v3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                removeTable();
                threeVariable();
            }
        });

        // 4 Variable
        JButton v4 = new JButton("4 Variable");
        v4.setFont(normalT);
        v4.setBounds(600, 70, 200, 30);
        v4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                removeTable();
                fourVariable();
            }
        });

        // Back
        JButton back = new JButton ("BACK");
        back.setFont(normalT);
        back.setBounds(350, 800, 300, 50);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(title); frame.remove(back); frame.remove(v2); frame.remove(v3); frame.remove(v4); 
                removeTable();
                menu();
            }
        });

        frame.add(title); frame.add(back); frame.add(v2); frame.add(v3); frame.add(v4);
        frame.setVisible(true);
    }

    public void twoVariable() {
        // Bounds
        r1.setBounds(300, 200, 200, 200);
        r2.setBounds(500, 200, 200, 200);
        r3.setBounds(300, 400, 200, 200);
        r4.setBounds(500, 400, 200, 200);

        frame.add(r1); frame.add(r2); frame.add(r3); frame.add(r4);
        frame.setVisible(true);
    }

    public void threeVariable() {
        r1.setBounds(400, 200, 100, 100);
        r2.setBounds(500, 200, 100, 100);
        r3.setBounds(400, 300, 100, 100);
        r4.setBounds(500, 300, 100, 100);
        r5.setBounds(400, 400, 100, 100);
        r6.setBounds(400, 500, 100, 100);

        frame.add(r1); frame.add(r2); frame.add(r3); frame.add(r4); frame.add(r5); frame.add(r6);
        frame.setVisible(true);
    }

    public void fourVariable() {
        r1.setBounds(300, 200, 133, 133);
        r2.setBounds(433, 200, 133, 133);
        r3.setBounds(566, 200, 133, 133);
        r4.setBounds(300, 333, 133, 133);
        r5.setBounds(433, 333, 133, 133);
        r6.setBounds(566, 333, 133, 133);
        r7.setBounds(300, 466, 133, 133);
        r8.setBounds(433, 466, 133, 133);
        r9.setBounds(566, 466, 133, 133);

        frame.add(r1); frame.add(r2); frame.add(r3); frame.add(r4); frame.add(r5); 
        frame.add(r6); frame.add(r7); frame.add(r8); frame.add(r9);
        frame.setVisible(true);
    }
}