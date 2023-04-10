package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class getVetDetailsGUI extends  JFrame{
    private JButton SEARCHButton;
    private JTextField textField1;
    private JPanel p1;
    private SimpleDateFormat dateFormatter;

    public getVetDetailsGUI() {
        setContentPane(p1);
        setSize(500,500);
        setVisible(true);
        setTitle("Vet Details");

           dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = "";
                boolean check = true;

                for (Employee theVet : FarmApp.employees) {
                    if (theVet.getEmpID() == Integer.parseInt(textField1.getText()) )
                    {
                        if(theVet instanceof Veterinary)
                        {
                            txt+=(("\n ************************************************************************\n"));
                            txt+=(("\nThe Vet Id: " + theVet.getEmpID()));
                            txt+=("\nGender: " +theVet.getGender());
                            txt+=("\nBirthay: " + dateFormatter.format(theVet.getDateOfBirth()));
                            txt+=("\nGraduation Date: " + dateFormatter.format(((Veterinary) theVet).getDateOfGraduation()));
                            txt+=("\nExpertise Level:" + ((Veterinary)theVet).getExpertiseLevel());
                            txt+=("\nBScDegree:" + ((Veterinary) theVet).isBScDegree());
                            check = false;
                        }

                    }
                }
                if(check) JOptionPane.showMessageDialog(p1,"There is Vet cow for");
               else
                    JOptionPane.showMessageDialog(p1,txt);
            }
        });
    }
}
