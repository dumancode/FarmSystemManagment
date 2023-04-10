package FarmApp;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class ListVet extends  JFrame{
    private JTextArea textArea1;
    private JPanel panel1;
    private SimpleDateFormat dateFormatter;

    public ListVet()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(500,500);
        setTitle("ListVet");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
         boolean checkEmpty = true;


        for(int i = 0; i<FarmApp.employees.size();i++)
        {
            if(FarmApp.employees.get(i) instanceof Veterinary)
            {

                textArea1.append(("\n ************************************************************************\n"));
                textArea1.append(("\nThe Vet Id: " + FarmApp.employees.get(i).getEmpID()));
                textArea1.append("\nGender: " + FarmApp.employees.get(i).getGender());
                textArea1.append("\nBirthay: " + dateFormatter.format(FarmApp.employees.get(i).getDateOfBirth()));
                textArea1.append("\nGraduation Date: " + dateFormatter.format(((Veterinary) FarmApp.employees.get(i)).getDateOfGraduation()));
                textArea1.append("\nExpertise Level:" + ((Veterinary) FarmApp.employees.get(i)).getExpertiseLevel());
                textArea1.append("\nBScDegree:" + ((Veterinary) FarmApp.employees.get(i)).isBScDegree());
                checkEmpty = false;

            }
        }

        if(checkEmpty)
        {   JOptionPane.showMessageDialog(panel1, "There is no Vet");


        }


    }


}
