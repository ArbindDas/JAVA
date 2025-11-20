package AdvanceJava.phase2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame implements ActionListener {


    JLabel l1 ,  l2, l3;
    JTextField t1,t2 , t3;
    JButton b1;


    public Example (){
        setSize(300, 300);
        setVisible(true);
        setLayout(new FlowLayout());


        l1 = new JLabel("Number1");
        l2 = new JLabel("Number2");
        l3 = new JLabel("Result");


        t1 = new JTextField(100);
        t2 = new JTextField(100);
        t3 = new JTextField(100);

        b1 = new JButton("OK");


        b1.addActionListener(this);

        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(t3);
        add(b1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1){

            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());

            int ans = a + b;
            t3.setText(String.valueOf(ans));
        }
    }
}
