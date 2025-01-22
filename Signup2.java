package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox<String> comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textCnic;
    JRadioButton r1, r2, e1, e2;
    JButton next;
    String formno;

    Signup2(String formno) {
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 5, 100, 100);
        add(image);

        this.formno = formno;

        JLabel l1 = new JLabel("Page 2 :-");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(300, 30, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(300, 60, 600, 40);
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 120, 100, 30);
        add(l3);

        String religion[] = {"Muslim", "Sikh", "Christian", "Hindu", "Other"};
        comboBox = new JComboBox<>(religion);
        comboBox.setBackground(new Color(137, 168, 178));
        comboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox.setBounds(350, 120, 320, 30);
        add(comboBox);

        JLabel l4 = new JLabel("Category : ");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 170, 100, 30);
        add(l4);

        String Category[] = {"General", "Sunni", "Shia", "Other"};
        comboBox2 = new JComboBox<>(Category);
        comboBox2.setBackground(new Color(137, 168, 178));
        comboBox2.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox2.setBounds(350, 170, 320, 30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income : ");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100, 220, 100, 30);
        add(l5);

        String income[] = {"Null", "<1,50,000", "<2,50,000", "5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        comboBox3 = new JComboBox<>(income);
        comboBox3.setBackground(new Color(137, 168, 178));
        comboBox3.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox3.setBounds(350, 220, 320, 30);
        add(comboBox3);

        JLabel l6 = new JLabel("Educational : ");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(100, 270, 150, 30);
        add(l6);

        String educational[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        comboBox4 = new JComboBox<>(educational);
        comboBox4.setBackground(new Color(137, 168, 178));
        comboBox4.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox4.setBounds(350, 270, 320, 30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation : ");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 340, 150, 30);
        add(l7);

        String Occupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        comboBox5 = new JComboBox<>(Occupation);
        comboBox5.setBackground(new Color(137, 168, 178));
        comboBox5.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox5.setBounds(350, 340, 320, 30);
        add(comboBox5);

        JLabel l8 = new JLabel("CNIC Number : ");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 390, 180, 30);
        add(l8);

        textCnic = new JTextField();
        textCnic.setFont(new Font("Raleway", Font.BOLD, 18));
        textCnic.setBounds(350, 390, 320, 30);
        add(textCnic);

        JLabel l9 = new JLabel("Senior Citizen : ");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(100, 440, 180, 30);
        add(l9);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(137, 168, 178));
        r1.setBounds(350, 440, 100, 30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(137, 168, 178));
        r2.setBounds(460, 440, 100, 30);
        add(r2);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(r1);
        group1.add(r2);

        JLabel l10 = new JLabel("Existing Account : ");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 490, 180, 30);
        add(l10);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD, 14));
        e1.setBackground(new Color(137, 168, 178));
        e1.setBounds(350, 490, 100, 30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD, 14));
        e2.setBackground(new Color(137, 168, 178));
        e2.setBounds(460, 490, 100, 30);
        add(e2);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(e1);
        group2.add(e2);

        JLabel l11 = new JLabel("Form No : ");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(700, 10, 100, 30);
        add(l11);

        JLabel l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(760, 10, 60, 30);
        add(l12);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(570, 640, 100, 30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850, 750);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(137, 168, 178)); // Custom Color

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();
        String cnic = textCnic.getText();

        String scitizen = r1.isSelected() ? "Yes" : "No";
        String eAccount = e1.isSelected() ? "Yes" : "No";

        // Validation
        if (cnic.isEmpty()) {
            JOptionPane.showMessageDialog(null, "CNIC is required!");
        } else if (!cnic.matches("\\d{5}-\\d{7}-\\d{1}")) {
            JOptionPane.showMessageDialog(null, "Invalid CNIC format. Use XXXXX-XXXXXXX-X");
        } else {
            try {
                Connn c = new Connn();
                String query = "INSERT INTO Signuptwo (formno, religion, category, income, education, occupation, cnic, seniorCitizen, existingAccount) VALUES('"
                        + formno + "', '" + rel + "', '" + cate + "', '" + inc + "', '" + edu + "', '" + occ + "', '" + cnic + "', '" + scitizen + "', '" + eAccount + "')";
                c.statement.executeUpdate(query);

                // Move to next page
                new Signup3(formno);
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
