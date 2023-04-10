package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class getCowDetailsGUI extends  JFrame{
    private JTextField textField1;
    private JButton resarchButton;
    private JPanel panel1;
    private SimpleDateFormat dateFormatter;

    public  getCowDetailsGUI()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(700,700);
        setVisible(true);
        resarchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCowDetails(Integer.parseInt(textField1.getText()));
            }
        });
    }


    public void getCowDetails(int tagNo) {
        boolean check = false;
        for (int i = 0; i< FarmApp.animals.size(); i++)
        {
            if (FarmApp.animals.get(i).getTagNo() == tagNo && FarmApp.animals.get(i) instanceof Cow) {
              String s = "";
                s+= ("\nTag number is: " + FarmApp.animals.get(i).getTagNo());
                s+=("\nGender is: " + FarmApp.animals.get(i).getGender());
                s+=("\nBirthday: " + dateFormatter.format(FarmApp.animals.get(i).getDateOfBirth()));
                s+=("\nIs it purchased ? " + FarmApp.animals.get(i).isPurchased());
                s+=("\nMilking Date and Amount:  ");
                s+=(FarmApp.animals.get(i).getMilking());

                s+=("\nWeight is: " + ((Cow) FarmApp.animals.get(i)).getWeight());

                s+=("\n************************************");
                JOptionPane.showMessageDialog(panel1,s);
                check = true;
            }
        }
       if(!check) JOptionPane.showMessageDialog(panel1,"There is no cow for " + tagNo + " number.");
    }
}
