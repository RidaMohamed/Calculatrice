/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author cirstea
 */

import controller.CalculetteController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class ExampleView implements Observer {

    public static final int PLUS = -100;
    public static final int MINUS = -200;
    public static final int EQUAL = -400;
    // ...
    private JFrame frame = new JFrame("Calculator");
    private JPanel[] panels = new JPanel[6];
    private JTextField textField = new JTextField();
    private JButton[] numberButtons = new JButton[10];
    private JButton subtractButton = new JButton("-");
    private JButton addButton = new JButton("+");
    private JButton equateButton = new JButton(" = ");
    private CalculetteController CalculetteController;
    private boolean operand = false ;

    public ExampleView() {
        // ...
        buildFrame();
    }

    public void AddListener( CalculetteController controller ) {
        this.CalculetteController = controller;
    }
        public void buildFrame() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();

        // initialize panels
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }

        // initialize button 0-9
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(" " + i + " ");
            numberButtons[i].addActionListener(new ExampleView.LocalListener(i));
        }

        // default layout = BorderLayout.CENTER
        textField.setColumns(20);
        textField.setText("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panels[0].add(textField);

        // layout = FlowLayout.LEFT
        panels[1].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[1].add(numberButtons[7]);
        panels[1].add(numberButtons[8]);
        panels[1].add(numberButtons[9]);
        panels[1].add(addButton);
        addButton.addActionListener(new ExampleView.LocalListener(PLUS));

        // layout = FlowLayout.LEFT
        panels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[2].add(numberButtons[4]);
        panels[2].add(numberButtons[5]);
        panels[2].add(numberButtons[6]);
        panels[2].add(subtractButton);
        subtractButton.addActionListener(new ExampleView.LocalListener(MINUS));

        // layout = FlowLayout.LEFT
        panels[3].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[3].add(numberButtons[1]);
        panels[3].add(numberButtons[2]);
        panels[3].add(numberButtons[3]);
        panels[3].add(equateButton);
        equateButton.addActionListener(new ExampleView.LocalListener(EQUAL));

        // layout = FlowLayout.LEFT
        panels[4].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[4].add(numberButtons[0]);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        for (JPanel jPanel : panels) {
            contentPane.add(jPanel);
        }

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
       textField.setText(String.valueOf( this.CalculetteController.CalculetteModele.getResultat()));
    }

    class LocalListener implements ActionListener {

        private int digit;

        public LocalListener(int digit) {
            this.digit = digit;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if((digit >= 0) && (digit <= 9)){
                System.out.println("a number is being typed");
                if (!textField.getText().equals("0"))
                    if (operand){
                        textField.setText(textField.getText() + String.valueOf(digit));
                    }
                    else{
                        textField.setText(String.valueOf(digit));
                        operand = true;
                    }
                else
                    textField.setText(String.valueOf(digit));
                    operand = true;
            }else {
                System.out.println("an operation symbole is being typed");
                /*int ReturnedValue =*/ CalculetteController.OnSymboleOperationClicked(digit , Integer.valueOf(textField.getText()));
                /*if (ReturnedValue != Integer.MIN_VALUE){
                    textField.setText(String.valueOf(ReturnedValue));
                }*/
                operand=false;
            }
        }


    }
}
