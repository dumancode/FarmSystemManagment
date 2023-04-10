package FarmApp;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteVetGUI extends  JFrame {
    private JPanel panel1;
    private JButton deleteVetButton;
    private JTextField textField1;
    public deleteVetGUI()
    {
        setContentPane(panel1);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);


        deleteVetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                deleteVet(Integer.parseInt(textField1.getText()));


            }
        });
    }

    public void deleteVet(int vetID) {
        boolean check = false;

        for (int i = 0; i< FarmApp.employees.size();i++)
        {
            if (FarmApp.employees.get(i) instanceof Veterinary && FarmApp.employees.get(i).getEmpID() == Integer.parseInt(textField1.getText()))
            {
                DataStorage.deleteEmployee(FarmApp.employees.get(i).getEmpID());
                FarmApp.employees.remove(i);

                JOptionPane.showMessageDialog(panel1,"Veterinary  is deleted.");
                check = true;
            }
        }
        if(!check)
            JOptionPane.showMessageDialog(panel1,"There is no Veterinary with this ID.");

    }
}
