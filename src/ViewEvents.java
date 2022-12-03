
/*import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

public class ViewEvents extends JFrame implements ActionListener {
    JFrame f;
    JButton b;
    ConnectionClass c1 = new ConnectionClass();
    String q1 = "select * from event";
    ResultSet rs = c1.stm.executeQuery(q1);
    DefaultTableModel model = new DefaultTableModel(
            new String[] { "Event Name", "Total Seats", "Price", "Booked seats" }, 0);
    Container cnt = this.getContentPane();

    ViewEvents() throws SQLException {
        f = new JFrame("");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        cnt.setLayout(new FlowLayout(FlowLayout.CENTER));

        while (rs.next()) {
            String[] tbData = { rs.getString("EventName"), String.valueOf(rs.getInt("TotalSeats")),
                    String.valueOf(rs.getDouble("Price")), String.valueOf(rs.getInt("Bookedseats")) };
            model.addRow(tbData);
        }
        JTable t1 = new JTable(model);
        t1.setBounds(20, 20, 150, 40);
        JScrollPane pg = new JScrollPane(t1);
        pg.setRowHeaderView(t1);
        cnt.add(pg);
        this.pack();
        t1.setFont(new Font("Serif", Font.BOLD, 20));
        t1.setRowHeight(40);
        t1.setRowMargin(10);
        f.add(t1);

        b = new JButton("Back");
        b.setBounds(120, 200, 150, 40);
        f.add(b);

        b.addActionListener(this);

        f.setVisible(true);
        f.setSize(580, 350);
        f.setResizable(false);

    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b) {
            f.setVisible(false);
            new UserHome();
        }
    }
}*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.*;

public class ViewEvents extends JFrame implements ActionListener {
    JFrame f;
    JButton b1;

    DefaultTableModel model = new DefaultTableModel(
            new String[] { "Event Name", "Total Seats", "Price", "Booked seats" }, 0);
    Container cnt = this.getContentPane();

    ViewEvents() throws SQLException {
        ConnectionClass c1 = new ConnectionClass();
        String q1 = "select * from event";
        ResultSet rs = c1.stm.executeQuery(q1);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        Vector<String> columnNames = new Vector<String>(columnsNumber);

        for (int column = 1; column <= columnsNumber; column++) {
            columnNames.add(rsmd.getColumnName(column));
        }

        Vector data = new Vector();
        Vector row = new Vector();
        while (rs.next()) {
            row = new Vector(columnsNumber);
            for (int i = 1; i <= columnsNumber; i++) {
                row.add(rs.getObject(i));
            }
            data.add(row);
        }

        JFrame frame = new JFrame("Events");
        frame.setBounds(400, 0, 500, 400);
        JScrollPane jsp = new JScrollPane(new JTable(data, columnNames));
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(jsp, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b1) {
            f.setVisible(false);
            new UserHome();
        }
    }
}
