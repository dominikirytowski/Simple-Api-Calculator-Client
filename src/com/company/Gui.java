package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Gui extends JFrame {

    JButton button = new JButton("Calculate");
    JTextField a = new JTextField();
    JTextField b = new JTextField();
    JLabel label = new JLabel("Insert values:");
    JLabel labelA = new JLabel("A: ");
    JLabel labelB = new JLabel("B: ");
    JLabel labelResult = new JLabel();
    String[] options = {"add", "subtract", "multiply", "divide", "sqrt", "pow"};
    JComboBox combo = new JComboBox(options);
    Operation operation = new Operation();


    Gui(){
        label.setVisible(true);
        label.setSize(new Dimension(100,30));
        label.setLocation(new Point(100, 10));

        labelA.setVisible(true);
        labelA.setSize(new Dimension(30,30));
        labelA.setLocation(new Point(70, 40));

        labelB.setVisible(true);
        labelB.setSize(new Dimension(30,30));
        labelB.setLocation(new Point(70, 80));

        labelResult.setSize(new Dimension(100, 30));
        labelResult.setLocation(100, 120);

        a.setSize(new Dimension(100, 30));
        a.setLocation(new Point(90, 40));

        b.setSize(new Dimension(100, 30));
        b.setLocation(new Point(90, 80));

        button.setSize(100, 50);
        button.setLocation(new Point(90, 180));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a.getText().equals("") && b.getText().equals("")){
                    labelResult.setText("No arguments!");
                    labelResult.setVisible(true);
                }else{
                    try {
                        if(combo.getSelectedItem().toString() == "sqrt"){
                        labelResult.setText(operation.executeOperation(Double.parseDouble(a.getText()),
                                0,
                                combo.getSelectedItem().toString()));
                        }else{
                            labelResult.setText(operation.executeOperation(Double.parseDouble(a.getText()),
                                    Double.parseDouble(b.getText()),
                                    combo.getSelectedItem().toString()));
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            }
        });

        combo.setSize(new Dimension(80, 30));
        combo.setLocation(new Point(200, 60));
        combo.addActionListener(e -> {
            if(combo.getSelectedIndex() == 4){
                b.setText("");
                b.setEditable(false);
            }else{
                b.setEditable(true);
            }
        });

        this.add(button);
        this.add(labelResult);
        this.add(label);
        this.add(labelA);
        this.add(labelB);
        this.add(a);
        this.add(b);
        this.add(combo);


        this.setTitle("Calculator");
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 300) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 300) / 2);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(new Dimension(300,300));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
