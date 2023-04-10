package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getCowTreatmentWithDateGUI extends  JFrame{
    private JPanel panel1;
    private JTextField textFieldID;
    private JButton listTreatmentsButton;
    private JTextField textFieldDate;
    private SimpleDateFormat dateFormatter;

    public getCowTreatmentWithDateGUI()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(800,800);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setVisible(true);



        listTreatmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    String dateOfTr = textFieldDate.getText();
                    int checkAnimal = checkAnimalandDate();
                    Date date = dateFormatter.parse(dateOfTr);
                  if(checkAnimal != -1)     new   helperGUIforgetCowTreatmentWithDate(checkAnimal,date);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


    public int checkAnimalandDate()
    {
        int whereIs_Animal = -1;

        boolean flag = false, flagDate= false;

        for (int i = 0; i < FarmApp.animals.size(); i++)
        {
            if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(textFieldID.getText()))
            {
                flag = true;
                whereIs_Animal = i;

            }
        }

        if(!flag)
            JOptionPane.showMessageDialog(panel1,"There is no animal with this ID.");

        for(int i  = 0; i< FarmApp.animals.get(whereIs_Animal).getTreatments().size();i++)
        {
            try {
                if(FarmApp.animals.get(whereIs_Animal).getTreatments().get(i).getDateOfTreatment().equals(dateFormatter.parse(textFieldDate.getText())))
                {
                  flagDate = true;
                    System.out.println(dateFormatter.parse(textFieldDate.getText()));
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if(!flagDate) JOptionPane.showMessageDialog(panel1,"There is no treatment with this Date.");

      return  whereIs_Animal;
    }
}
