package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Pin extends JFrame implements ActionListener {
    JButton b1, b2;
    JPasswordField p1, p2;
    String pin;

    Pin(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(470, 270, 150, 35);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65, 125, 128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(630, 270, 180, 25);
        p1.setFont(new Font("Raleway", Font.BOLD, 22));
        p1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || p1.getPassword().length >= 4) {
                    e.consume();
                }
            }
        });
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(470, 300, 400, 35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65, 125, 128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(630, 310, 180, 25);
        p2.setFont(new Font("Raleway", Font.BOLD, 22));
        p2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || p2.getPassword().length >= 4) {
                    e.consume();
                }
            }
        });
        l3.add(p2);

        b1 = new JButton("CHANGE");
        b1.setBounds(670, 362, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(670, 406, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setSize(1550, 1080);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the user clicked the BACK button
        if (e.getSource() == b2) {
            setVisible(false);
            new main_Class(pin); // Navigate back to the main class
            return;
        }

        // Proceed with PIN change logic only if the CHANGE button is clicked
        try {
            String pin1 = new String(p1.getPassword());
            String pin2 = new String(p2.getPassword());

            if (pin1.length() != 4) {
                JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits");
                return;
            }

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (e.getSource() == b1) {
                Connn c = new Connn();

                // Check if the new PIN already exists
                String checkQuery = "select * from bank where pin = '" + pin1 + "'";
                ResultSet rs = c.statement.executeQuery(checkQuery);

                if (rs.next()) { // If a record exists with the same PIN
                    JOptionPane.showMessageDialog(null, "This PIN is already assigned. Try another PIN.");
                    return;
                }

                // Update PIN in all relevant tables
                String q1 = "update bank set pin = '" + pin1 + "' where pin = '" + pin + "'";
                String q2 = "update login set pin = '" + pin1 + "' where pin = '" + pin + "'";
                String q3 = "update signupthree set pin = '" + pin1 + "' where pin = '" + pin + "'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new main_Class(pin1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
