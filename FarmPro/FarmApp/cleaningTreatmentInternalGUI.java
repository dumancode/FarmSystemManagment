package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class cleaningTreatmentInternalGUI  extends  JFrame{
    private JTextField textFieldAnimalID;
    private JTextField textFieldEmpID;
    private JTextField textFieldDateTr;
    private JTextField textFieldMat;
    private JButton ADDButton;
    private JPanel panel1;
    private SimpleDateFormat dateFormatter;

    public cleaningTreatmentInternalGUI()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(1000,1000);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addTreatment();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void addTreatment() throws ParseException {


        int count_For_Animal = 0, flag = 1, employenumber = 0;
        boolean count_for_Tag = false, count_For_Emp = false;

        for (int i = 0; i < FarmApp.animals.size(); i++) {
            if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(textFieldAnimalID.getText()))     //Check where is the animal in list
            {
                count_For_Animal = i;
                count_for_Tag = true;
            }


        }
        if (!count_for_Tag) {
            flag = 0;

            JOptionPane.showMessageDialog(panel1, "There is no tagNo for animals!!");

        }

        for (int i = 0; i < FarmApp.employees.size(); i++)  //check where is the FarmApp.Employee in employee list
        {
            if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(textFieldEmpID.getText())) {
                count_For_Emp = true;
                employenumber = i;

            }


        }
        if (!count_For_Emp) {

            flag = 0;
            JOptionPane.showMessageDialog(panel1, "There is no employee with this ID !!");


        }


        if (flag == 1) {


            if (FarmApp.employees.get(employenumber) instanceof FarmWorker)
            {


                CleaningTreatment sample_CleaningTreatment = new CleaningTreatment();


                String material = textFieldMat.getText();
                sample_CleaningTreatment.setMaterialsused(material);


                String datetreatment = textFieldDateTr.getText();


                Date datestart;
                try {
                    datestart = dateFormatter.parse(datetreatment);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                sample_CleaningTreatment.setDateOfTreatment(datestart);

                sample_CleaningTreatment.setFarmWorker((FarmWorker) FarmApp.employees.get(employenumber));
                FarmApp.animals.get(count_For_Animal).getTreatments().add(sample_CleaningTreatment);
                JOptionPane.showMessageDialog(panel1, "Cleaning Treatment be added !");

            }
            else
                JOptionPane.showMessageDialog(panel1, "For CleaningTreatment you should add FarmWorker not Vet! !");


        }


        }




}
