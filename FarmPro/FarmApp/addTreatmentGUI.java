package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addTreatmentGUI  extends  JFrame{
    private JComboBox comboBox1;
    private JPanel panel1;
    private JButton ADDButton;

    public addTreatmentGUI()
    {
        super("ADD TREATMENT");
        setContentPane(panel1);
        setSize(800,800);
        setVisible(true);


        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedIndex() == 0)
                {
                      HealthTreatmentInternalGUI a = new HealthTreatmentInternalGUI();
                }
                else
                {
                   cleaningTreatmentInternalGUI a = new cleaningTreatmentInternalGUI();
                }
            }
        });
    }
}
