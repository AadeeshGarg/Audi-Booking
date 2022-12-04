import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class BookTickets extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3;
    JButton b1, b2, b3;
    JTextField t2, t1;
    String UserId, eve;

    BookTickets(String UserId, String eve) {
        this.UserId = UserId;
        this.eve = eve;
        f = new JFrame("Book Seats");
        f.setBackground(Color.white);
        f.setLayout(null);
        l1 = new JLabel("Number of seats -");
        l1.setBounds(40, 70, 1000, 30);
        f.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 70, 150, 30);
        f.add(t1);

        l2 = new JLabel("Seat numbers -");
        l2.setBounds(40, 120, 1000, 30);
        f.add(l2);

        l3 = new JLabel("(format - 1 4 18)");
        l3.setBounds(35, 138, 1000, 25);
        f.add(l3);
        t2 = new JTextField();
        t2.setBounds(200, 120, 150, 30);
        f.add(t2);

        b1 = new JButton("Back");
        b1.setBounds(40, 180, 140, 30);
        b1.addActionListener(this);

        b2 = new JButton("Book");
        b2.setBounds(200, 180, 140, 30);
        b2.addActionListener(this);

        b3 = new JButton("View Available Seats");
        b3.setBounds(110, 210, 160, 30);
        b3.addActionListener(this);

        f.add(b3);
        f.add(b2);
        f.add(b1);

        f.getContentPane();
        f.setVisible(true);
        f.setSize(400, 330);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b1) {
            f.setVisible(false);
            new BookSeats(UserId);
        } else if (ae.getSource() == b3) {
            try {
                new Table(eve, UserId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
