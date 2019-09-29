package view;

import controller.CalculetteController;
import controller.CalculetteHistoriqueController;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class View2_Historique implements Observer {


    private JFrame frame = new JFrame("Calculator Historique");
    private JPanel[] panels = new JPanel[6];
    private JTextField textField = new JTextField();
    private CalculetteHistoriqueController calculetteController;

    public View2_Historique(){
        buildFrame();
    }

    public void AddListener( CalculetteHistoriqueController controller ) {
        this.calculetteController = controller;
    }

    public void buildFrame() {

       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();


        // initialize panels
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }

        //Ajout d'un text field
        textField.setColumns(20);
        textField.setText("");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panels[0].add(textField);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        for (JPanel jPanel : panels) {
            contentPane.add(jPanel);
        }

        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {
        this.textField.setText(this.textField.getText() + " " + calculetteController.CalculetteModele.getExpression());
    }
}
