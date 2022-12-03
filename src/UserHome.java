import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class UserHome extends JFrame implements ActionListener {
    JFrame f;
    JButton b1, b2, b3;
    String UserId;

    UserHome(String UserId) {
        this.UserId = UserId;

        f = new JFrame("User Home");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        b1 = new JButton("View Shows/Events");
        b1.setBounds(50, 50, 140, 120);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Book Seats");
        b2.setBounds(200, 50, 140, 120);
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Log Out");
        b3.setBounds(125, 180, 140, 120);
        b3.addActionListener(this);
        f.add(b3);

        f.getContentPane();
        f.setVisible(true);
        f.setSize(390, 350);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                new ViewEvents();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            f.setVisible(false);
            new BookSeats(UserId);
        } else if (ae.getSource() == b3) {
            f.setVisible(false);
            new UserLogin();
        }
    }
}
