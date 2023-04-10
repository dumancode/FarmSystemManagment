package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteFarmWorker extends  JFrame{
    private JPanel panel1;
    private JButton deleteFarmWorkerButton;
    private JTextField textField1;

    public deleteFarmWorker() {

        setContentPane(panel1);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

        deleteFarmWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFWorker(Integer.parseInt(textField1.getText()));
            }
        });
    }


    public void deleteFWorker(int vetID) {
        boolean check = false;

        for (int i = 0; i< FarmApp.employees.size();i++)
        {
            if (FarmApp.employees.get(i) instanceof FarmWorker && FarmApp.employees.get(i).getEmpID() == Integer.parseInt(textField1.getText()))
            {
                DataStorage.deleteEmployee(FarmApp.employees.get(i).getEmpID());

                FarmApp.employees.remove(i);

                JOptionPane.showMessageDialog(panel1,"FarmWorker  is deleted.");
                check = true;
            }
        }
        if(!check)
            JOptionPane.showMessageDialog(panel1,"There is no FarmWorker with this ID.");

    }
}
