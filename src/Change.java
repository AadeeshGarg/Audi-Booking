import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Change extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1;
    JComboBox c1;
    JButton b1,b2;
    
    Change(){
        f = new JFrame("Change Details");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        l1 = new JLabel("Name of Event -");
        l1.setBounds(40, 20, 1000, 30);
        f.add(l1);
        
        ConnectionClass obj = new ConnectionClass();
        try{
            String query = "SELECT * FROM event;";
            ResultSet rs = obj.stm.executeQuery(query);
            Array eve = rs.getArray("EventName");
            String []ev = (String[]) eve.getArray();
            c1 = new JComboBox(ev);
            c1.setBounds(240, 20, 50, 30);
            c1.addActionListener(this);
            f.add(c1);
        } catch (Exception e) {
            System.out.println(e);
        }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }


}
