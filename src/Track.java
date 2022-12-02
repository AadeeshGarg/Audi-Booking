import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Track extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1;
    JTextField t1;
    JButton b1, b2;
    Track(){
        f = new JFrame("Track Event");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Name of Event -");
        l1.setBounds(40, 20, 1000, 30);
        f.add(l1);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        f.add(t1);

        b1 = new JButton("Back");
        b1.setBounds(40, 190, 120, 30);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Track");
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
            int b = 0;

            try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Select an Event");
                } else {
                    ConnectionClass c1 = new ConnectionClass();
                    ResultSet rs1 = c1.stm.executeQuery( "SELECT TotalSeats FROM Event where EventName  = '" + name + "';" );
                    ResultSet rs2 = c1.stm.executeQuery( "SELECT BookedSeats FROM Event where EventName  = '" + name + "';" );
                    ResultSet rs3 = c1.stm.executeQuery( "SELECT Price FROM Event where EventName  = '" + name + "';" );
                    System.out.println(rs1.getString("TotalSeats"));
                    // JOptionPane.showMessageDialog(null, "Price is " + );

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
