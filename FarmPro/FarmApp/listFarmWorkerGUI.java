package FarmApp;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class listFarmWorkerGUI  extends  JFrame {
    private JTextArea textArea1;
    private JPanel panel1;
    private SimpleDateFormat dateFormatter;
    public listFarmWorkerGUI()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(500,500);
        setTitle("List FarmWorker");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        String deneme ="";
        boolean check = true;

        for (Employee theFarmWorker : FarmApp.employees)
        {
            if (theFarmWorker instanceof FarmWorker)
            {
                deneme+=("\n*************** \n");
                deneme+=("\nId: " + theFarmWorker.getEmpID());
                deneme+=("\nGender: " + theFarmWorker.getGender());
                deneme+=("\nBirthay: " + dateFormatter.format(theFarmWorker.getDateOfBirth()));
                deneme+=("\nPrevious Farm Name: " + ((FarmWorker) theFarmWorker).getPreviousFarmName());
                deneme+=("\nWork experience:" + ((FarmWorker) theFarmWorker).getWorkexperience());
                check = false;


            }

        }
        if(check == true)    JOptionPane.showMessageDialog(panel1,"There is no farmworker.");
        else
        JOptionPane.showMessageDialog(panel1,deneme);
    }

}
