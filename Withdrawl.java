package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton b1, b2;

    Withdrawl(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460, 270, 400, 35);
        l3.add(label2);

        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 310, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));

        // Restrict input to numbers only
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit characters
                }
            }
        });

        l3.add(textField);

        b1 = new JButton("WITHDRAW");
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

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                String amount = textField.getText().trim();
                Date date = new Date();

                if (amount.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                    return;
                }

                int withdrawAmount = Integer.parseInt(amount);

                // Check if the amount is within the valid range
                if (withdrawAmount < 500 || withdrawAmount > 20000) {
                    JOptionPane.showMessageDialog(null, "Amount must be between Rs. 500 and Rs. 20,000");
                    return;
                }

                Connn c = new Connn();
                ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
                int balance = 0;

                // Calculate current balance
                while (resultSet.next()) {
                    if (resultSet.getString("type").equalsIgnoreCase("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else if (resultSet.getString("type").equalsIgnoreCase("Withdrawl")) {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                // Check if there is sufficient balance
                if (balance < withdrawAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance. Your current balance is Rs. " + balance);
                    return;
                }

                // Process the withdrawal
                c.statement.executeUpdate("INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully. Your remaining balance is Rs. " + (balance - withdrawAmount));
                setVisible(false);
                new main_Class(pin);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
