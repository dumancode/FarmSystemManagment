package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class getSheepDetailsGUI extends  JFrame {
    private JTextField textField1;
    private JButton searchButton;
    private JPanel panel1;
    private SimpleDateFormat dateFormatter;

    public  getSheepDetailsGUI()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(700,700);
        setVisible(true);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSheepDetails(Integer.parseInt(textField1.getText()));
            }
        });
    }

    public void getSheepDetails(int tagNo) {
        boolean check = false;
        for (int i = 0; i< FarmApp.animals.size(); i++)
        {
            if (FarmApp.animals.get(i).getTagNo() == tagNo && FarmApp.animals.get(i) instanceof Sheep) {
                String s = "";
                s+= ("\nTag number is: " + FarmApp.animals.get(i).getTagNo());
                s+=("\nGender is: " + FarmApp.animals.get(i).getGender());
                s+=("\nBirthday: " + dateFormatter.format(FarmApp.animals.get(i).getDateOfBirth()));
                s+=("\nIs it purchased ? " + FarmApp.animals.get(i).isPurchased());
                s+=("\nMilking Date and Amount:  ");
                s+=(FarmApp.animals.get(i).getMilking());



                s+=("\n************************************");
                JOptionPane.showMessageDialog(panel1,s);
                check = true;
            }
        }
        if(!check) JOptionPane.showMessageDialog(panel1,"There is no Sheep for " + tagNo + " number.");
    }
}


