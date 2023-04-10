package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MilkingADDGUI extends  JFrame {
    private JTextField textFieldID;
    private JTextField textFieldAmount;
    private JButton button1;
    private JPanel p1;


    public MilkingADDGUI() {
        setContentPane(p1);
        setSize(700,700);
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean check = true;

                for (int i = 0; i< FarmApp.animals.size(); i++)
                {
                    if(FarmApp.animals.get(i).getTagNo() == Integer.parseInt(textFieldID.getText()))
                    {
                        check = false;

                        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


                        if (FarmApp.animals.get(i).getMilking().containsKey(today)) {
                            System.out.println("There can be only one measurement per day");

                        } else {

                            FarmApp.animals.get(i).getMilking().put(today, Double.valueOf(textFieldAmount.getText()));

                        }
                    }

                }
                if(check) JOptionPane.showMessageDialog(p1,"There is no Animal with this ID");
                else JOptionPane.showMessageDialog(p1,"It is added !!");

            }
        });
    }
}
