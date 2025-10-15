package AdvanceJava.Exam;

import javax.swing.*;
import java.awt.*;

public class Employee extends JFrame {

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1;

    public Employee() {
        setTitle("Employee Form");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Use GridLayout for a clean form design
        setLayout(new GridLayout(4, 2, 5, 15));

        l1 = new JLabel("EmpId:");
        t1 = new JTextField(20);

        l2 = new JLabel("EmpName:");
        t2 = new JTextField(20);

        l3 = new JLabel("Salary:");
        t3 = new JTextField(20);

        b1 = new JButton("OK");

        // Add components in pairs (label -> text field)
        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(l3);
        add(t3);

        // Empty label for spacing before button
        add(new JLabel(""));
        add(b1);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee();
    }
}
