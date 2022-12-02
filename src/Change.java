import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Change extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1;
    JTextField t1;
    JButton b1,b2;
    
    Change(){
        f = new JFrame("Change Details");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        l1 = new JLabel("Name of Event -");
        l1.setBounds(40, 20, 1000, 30);
        f.add(l1);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        f.add(t1);

        b1 = new JButton("Back");
        b1.setBounds(40, 90, 120, 30);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Change");
        b2.setBounds(200, 90, 120, 30);
        b2.addActionListener(this);
        f.add(b2);

        f.getContentPane();
        f.setVisible(true);
        f.setSize(380, 170);
    }
}
