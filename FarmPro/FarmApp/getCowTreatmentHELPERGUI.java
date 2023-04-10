package FarmApp;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class getCowTreatmentHELPERGUI extends  JFrame{
    private JPanel panel1;
    private JTextArea textArea1;
    private int whereAnimal;
    private SimpleDateFormat dateFormatter;

    getCowTreatmentHELPERGUI(int whereisAnimal)
    {
        whereAnimal = whereisAnimal;
        setContentPane(panel1);
        setSize(800,800);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        getCowTreatment((whereAnimal));

    }

    public void getCowTreatment(int whereIs_Animal) {
       dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String d = "";
        for (int i = 0; i < FarmApp.animals.get(whereIs_Animal).getTreatments().size(); i++) {
            d+=("\n*******************************");


            if (FarmApp.animals.get(whereIs_Animal).getTreatments().get(i) instanceof HealthTreatment) {
                try {


                    d+=("\nHealth Treatments: ");
                    d+=("\n>>>>>>>>>>>>>>>>>>>>>>");

                    d+=("\nDate Of Treatments:" + dateFormatter.format(FarmApp.animals.get(whereIs_Animal).getTreatments().get(i).getDateOfTreatment()));

                    HealthTreatment sample_HealthTreatment = (HealthTreatment) FarmApp.animals.get(whereIs_Animal).getTreatments().get(i);

                    d+=("\nEmergency: " + sample_HealthTreatment.isEmergency());

                    d+=("\n\nVet Information: ");
                    Veterinary tempVet = (sample_HealthTreatment.getVeterinary());
                    d+= "\nVet ID: " + tempVet.getEmpID();
                    d+= "\nGender: " + tempVet.getGender();
                    d+= " \nDateOfBirth: " + dateFormatter.format(tempVet.getDateOfBirth());
                    d+= "\nDateOfGraduation: : " + dateFormatter.format(tempVet.getDateOfGraduation());
                    d+= "\nExpertise Level: " +tempVet.getExpertiseLevel();
                    d+= "\nSalary:  " + tempVet.getSalary();


                    for (int j = 0; j < (sample_HealthTreatment).getMedications().size(); j++) {
                        d+=("\nDetails of Medication: ");
                        d+=(sample_HealthTreatment.getMedications().get(j).getDetails());
                        d+=("\nDuration of Medication: ");
                        d+=(sample_HealthTreatment.getMedications().get(j).getDuration());
                        d+=("\nThe start date of Medication: " + dateFormatter.format(sample_HealthTreatment.getMedications().get(j).getStartDate()));
                        d+=("\nDosage of Medication: " + sample_HealthTreatment.getMedications().get(j).getDosage());

                        d+=("\n****************");
                    }

                } catch (Exception Furkan) {
                    if (Furkan instanceof ClassCastException)
                        System.out.println("There is a problem with casting process");

                }

            } else if (FarmApp.animals.get(whereIs_Animal).getTreatments().get(i) instanceof CleaningTreatment) {
                try {
                    d+=("\n\nCleaning Treatment: ");
                    d+=("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>");

                    CleaningTreatment sample_CleaningTr = (CleaningTreatment) FarmApp.animals.get(whereIs_Animal).getTreatments().get(i);
                    d+=("\nDate Of Treatments:" + dateFormatter.format(FarmApp.animals.get(whereIs_Animal).getTreatments().get(i).getDateOfTreatment()));
                    d+=("\nWhich material is used ? " + sample_CleaningTr.getMaterialsused());
                    d+=("\n\nFarm Worker Information: ");
                    d+=("\nID: " + sample_CleaningTr.getFarmWorker().getEmpID());
                    d+=("\nGender: " + sample_CleaningTr.getFarmWorker().getGender());
                    d+=("\nPrevious Farm: " + sample_CleaningTr.getFarmWorker().getPreviousFarmName());
                    d+=("\nWork Experience: " + sample_CleaningTr.getFarmWorker().getWorkexperience());
                    d+=("\nDate Of Birth: : " + dateFormatter.format(sample_CleaningTr.getFarmWorker().getDateOfBirth()));

                } catch (Exception Furkan) {
                    if (Furkan instanceof ClassCastException)
                        System.out.println("There is a problem with casting process");
                }
            }


        }

      textArea1.append(d);
    }

}
