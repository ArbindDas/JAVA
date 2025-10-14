package AdvanceJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Test2 extends JFrame implements ActionListener {

    JLabel l1 , l2, l3;
    JTextField t1 , t2 , t3;
    JButton b1;

    public Test2(){

        setSize(500 , 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        l1 = new JLabel("Length");
        l2 = new JLabel("breadth");
        l3 = new JLabel("Area");

        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(30);
        t3.setEditable(false);

        b1 = new JButton("OK");
        b1.addActionListener((ActionListener) this);


        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(t3);
        add(l3);

        add(b1);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int length = Integer.parseInt(t1.getText());
            int breadth = Integer.parseInt(t2.getText());
            int area = length * breadth;

            t3.setText(String.valueOf(area));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }
}
