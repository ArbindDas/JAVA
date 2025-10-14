package AdvanceJava;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

    JLabel l1, l2, l3;
    JTextField t1, t2 , t3;
    JButton b1;

    public Test(){
        setSize(200, 200);
        setVisible(true);
        setLayout(new GridLayout(4,2));

        l1 = new JLabel("EmpId");
        l2 = new JLabel("EmpPhone");
        l3 = new JLabel("Salary");

        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);

        b1 = new JButton("Ok");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
    }

}
