package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HealthTreatmentInternalGUI extends  JFrame {
    private JTextField textNotes;
    private JButton ADDButton;
    private JPanel panel1;
    private JLabel t1;
    private JLabel t2;
    private JLabel t3;
    private JLabel t4;
    private JLabel t5;
    private JLabel t6;
    private JLabel t7;
    private JLabel t8;
    private JLabel t9;
    private JTextField textID;
    private JTextField textVetID;
    private JTextField textDateTreatment;
    private JComboBox comboBox1;
    private JLabel T11;
    private JTextField textDetails;
    private JTextField textDuration;
    private JTextField textStartDate;
    private JTextField textDosage;
  private SimpleDateFormat dateFormatter;
    public  HealthTreatmentInternalGUI()
    {
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
            if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(textID.getText()))     //Check where is the animal in list
            {
                count_For_Animal = i;
                count_for_Tag = true;
            }


        }
        if (!count_for_Tag)
        {
            flag = 0;

            JOptionPane.showMessageDialog(panel1,"There is no tagNo for animals!!");

        }

        for (int i = 0; i < FarmApp.employees.size(); i++)  //check where is the Employee in employee list
        {
            if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(textVetID.getText())) {
                count_For_Emp = true;
                employenumber = i;

            }


        }
        if (!count_For_Emp) {

            flag = 0;
            JOptionPane.showMessageDialog(panel1,"There is no employee with this ID !!");


        }




        if (flag == 1) {

            {
                if (FarmApp.employees.get(employenumber) instanceof Veterinary)
                {


                    HealthTreatment Health_treatment_sample = new HealthTreatment();
                    Health_treatment_sample.setVeterinary((Veterinary) FarmApp.employees.get(employenumber));


                    String birthday = textDateTreatment.getText();
                    Date date = dateFormatter.parse(birthday);
                    Health_treatment_sample.setDateOfTreatment(date);




                    int emergency = comboBox1.getSelectedIndex();
                    boolean banswer;
                    if(emergency == 0) banswer = true;
                    else banswer = false;

                    Health_treatment_sample.setEmergency(banswer);


                    Medication medication_simple = new Medication();  //Temp. object

                    String detailsofmed = textDetails.getText();
                    medication_simple.setDetails(detailsofmed);



                    int duration = Integer.parseInt(textDuration.getText());
                    medication_simple.setDuration(duration);



                    String startdate = textStartDate.getText();
                    Date datestart = null;
                    try {
                        datestart = dateFormatter.parse(startdate);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    medication_simple.setStartDate(datestart);



                    double dosage = Double.parseDouble(textDosage.getText());
                    medication_simple.setDosage(dosage);



                    String notes = textNotes.getText();
                    medication_simple.setNotes(notes);
                    Health_treatment_sample.getMedications().add(medication_simple);
                    FarmApp.animals.get(count_For_Animal).getTreatments().add(Health_treatment_sample);
                    JOptionPane.showMessageDialog(panel1,"Health Treatment be added !");



                }
                else
                JOptionPane.showMessageDialog(panel1,"For HealthTreatment you should add Vet not FarmWorker!");


            }




        }


    }

}
