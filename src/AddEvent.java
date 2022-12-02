import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class AddEvent extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;

    AddEvent(){
        f = new JFrame("Add New Event");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Name of Event -");
        l1.setBounds(40, 20, 1000, 30);
        f.add(l1);

        l2 = new JLabel("Total Seats -");
        l2.setBounds(40, 70, 1000, 30);
        f.add(l2);

        l3 = new JLabel("Price -");
        l3.setBounds(40, 120, 1000, 30);
        f.add(l3);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        f.add(t1);

        t2 = new JTextField();
        t2.setBounds(150, 70, 150, 30);
        f.add(t2);

        t3 = new JTextField();
        t3.setBounds(150, 120, 150, 30);
        f.add(t3);

        b1 = new JButton("Back");
        b1.setBounds(40, 190, 120, 30);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Add");
        b2.setBounds(200, 190, 120, 30);
        b2.addActionListener(this);
        f.add(b2);

        f.getContentPane();
        f.setVisible(true);
        f.setSize(400, 340);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            String name = t1.getText();
            int seats = Integer.parseInt(t2.getText());
            Double cost = Double.parseDouble(t3.getText());
            int b = 0;

            try {
                if (name.equals("") || seats <= 0 || cost <= 0.0) {
                    JOptionPane.showMessageDialog(null, "Invalid Entries");
                } else {
                    ConnectionClass c1 = new ConnectionClass();
                    String q1 = "insert into event values('" + name + "','" + seats + "','" + cost + "','"+ b +"')";
                    int aa = c1.stm.executeUpdate(q1);

                    if (aa == 1) {
                        JOptionPane.showMessageDialog(null, "Event Added Successfully");
                        f.setVisible(false);
                        new AdminHome();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter valid details");
                        this.f.setVisible(false);
                        this.f.setVisible(true);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b1) {
            f.setVisible(false);
            new AdminHome();
        }
    }
}

