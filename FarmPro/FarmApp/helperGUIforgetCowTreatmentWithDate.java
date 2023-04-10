package FarmApp;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class helperGUIforgetCowTreatmentWithDate extends  JFrame{
    private JTextArea textArea1;
    private JScrollPane j1;
    private JPanel panel1;
    private  int where_Is_Animal;
    Date dateOfTreatment;
    private SimpleDateFormat dateFormatter;

    public helperGUIforgetCowTreatmentWithDate(int whereAnimal,Date TreatmentDate)
    {    super("deneme");
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");


        setContentPane(panel1);
        setSize(800,800);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        where_Is_Animal = whereAnimal;
        dateOfTreatment = TreatmentDate;
        try {
          getCowTreatment(whereAnimal,dateOfTreatment);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }




    }


    public void getCowTreatment(int WhereIsAnimal, Date dateOfTreatment) throws ParseException {


           String d = "";

        for (int i = 0; i < FarmApp.animals.get(WhereIsAnimal).getTreatments().size(); i++)
        {

            if (FarmApp.animals.get(WhereIsAnimal).getTreatments().get(i).getDateOfTreatment().equals(dateOfTreatment)) {
                if ((FarmApp.animals.get(WhereIsAnimal).getTreatments().get(i) instanceof HealthTreatment))
                {


                    try {

                        HealthTreatment sample_HealthTreatment = (HealthTreatment) FarmApp.animals.get(WhereIsAnimal).getTreatments().get(i);
                        d+=("\nDate Of Treatments: " + dateFormatter.format(sample_HealthTreatment.getDateOfTreatment()));
                        d+=("\n\nVeterinary Information: ");
                        Veterinary tempVet = ((HealthTreatment) FarmApp.animals.get(WhereIsAnimal).getTreatments().get(i)).getVeterinary();
                        d+= "\nVet ID: " + tempVet.getEmpID();
                        d+= "\nGender: " + tempVet.getGender();
                        d+= " \nDateOfBirth: " + dateFormatter.format(tempVet.getDateOfBirth());
                        d+= "\nDateOfGraduation: : " + dateFormatter.format(tempVet.getDateOfGraduation());
                        d+= "\nExpertise Level: " +tempVet.getExpertiseLevel();
                        d+= "\nSalary:  " + tempVet.getSalary();

                        for (int j = 0; j < (sample_HealthTreatment).getMedications().size(); j++)
                        {
                           d+= ("\nDetails of Medication: ");
                            d+=(sample_HealthTreatment.getMedications().get(j).getDetails());
                            d+=("\nDuration of Medication: ");
                            d+=(sample_HealthTreatment.getMedications().get(j).getDuration());
                            d+=("\nThe start date of Medication: " + dateFormatter.format(sample_HealthTreatment.getMedications().get(j).getStartDate()));
                            d+=("\nDosage of Medication: " + sample_HealthTreatment.getMedications().get(j).getDosage());
                            d+=("\n\n****************\n\n");
                        }


                    } catch (Exception Furkan) {
                        if (Furkan instanceof ClassCastException)
                            System.out.println("There is a problem with casting process");
                    }
                }

                    if (FarmApp.animals.get(WhereIsAnimal).getTreatments().get(i) instanceof CleaningTreatment) {
                        CleaningTreatment sample_CleaningTr = (CleaningTreatment) FarmApp.animals.get(WhereIsAnimal).getTreatments().get(i);
                        try {
                            d+=("\nWhich material is used ?" + sample_CleaningTr.getMaterialsused());

                            d+=("\n\nFarm Worker Information: ");
                            System.out.println();
                            d+=("\nID: " + sample_CleaningTr.getFarmWorker().getEmpID());
                            d+="\nGender: " + sample_CleaningTr.getFarmWorker().getGender();
                            d+=("\nPrevious Farm: " + sample_CleaningTr.getFarmWorker().getPreviousFarmName());
                            d+=("\nWork Experience: " + sample_CleaningTr.getFarmWorker().getWorkexperience());
                            d+=("\nDate Of Birth: : " + dateFormatter.format(sample_CleaningTr.getFarmWorker().getDateOfBirth()));
                        } catch (Exception Furkan) {
                            if (Furkan instanceof ClassCastException)
                                System.out.println("There is a problem with casting process");
                        }
                    }


            }




        }
        textArea1.append(d);
    }
}
