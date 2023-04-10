package FarmApp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
/**In this class, there is an arraylist holding Animals and an arraylist holding Employees. It also creates a SimpleDataFormat object.
 * The purpose of the class is to create a kind of local database. Since the assignment says to create 2 FarmApp.FarmApp.Cow, 2 sheep,2 Vet and 2 FarmApp.FarmWorker objects,
 * I created these objects inside the constructor.
 *
 * @author  Furkan Duman 2453173
 * @version JDK19
 *
 *
 *
 *
 */
public class PopulateData
{   private SimpleDateFormat dateFormatter;
    private ArrayList<Animal> animals;
    private   ArrayList<Employee> employees;


    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    /**
     *
     * @throws ParseException  Constructs a ParseException with the specified detail message and offset.
     */
    public PopulateData() throws ParseException
    {

        animals = new ArrayList<>();
        dateFormatter = new SimpleDateFormat();
        employees = new ArrayList<>();


        String date_String; Date simple_date;

        Cow cow1 = new Cow();
        cow1.setGender("Male");
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        cow1.setTagNo(1);
        cow1.setPurchased(false);
        cow1.setWeight(50);

        HashMap<String,Double> milking = new HashMap<>();
        date_String = "20/11/2022";


        milking.put(date_String,8.2);

        cow1.setMilking(milking);
        date_String = "12/06/2021";  simple_date = dateFormatter.parse(date_String);
        cow1.setDateOfBirth(simple_date);

        FarmWorker farmWorker = new FarmWorker();
        farmWorker.setWorkexperience(5);
        farmWorker.setPreviousFarmName("BizimCiftlik");
        farmWorker.setGender("Male");
        farmWorker.setEmpID(1);
        date_String = "6/06/2006";  simple_date = dateFormatter.parse(date_String);
        farmWorker.setDateOfBirth(simple_date);

        employees.add(farmWorker);

        CleaningTreatment cleaningTreatment = new CleaningTreatment();
        cleaningTreatment.setMaterialsused("Knife");
        date_String = "7/07/2007";  simple_date = dateFormatter.parse(date_String);
        cleaningTreatment.setDateOfTreatment(simple_date);

        cleaningTreatment.setFarmWorker(farmWorker);

          cow1.getTreatments().add(cleaningTreatment);



          Veterinary veterinary = new Veterinary();
          veterinary.setExpertiseLevel(2);
          veterinary.setGender("Female");
          veterinary.setBScDegree(true);
          veterinary.setEmpID(2);
        date_String = "8/08/1999";  simple_date = dateFormatter.parse(date_String);
          veterinary.setDateOfBirth(simple_date);
        date_String = "9/09/2020";  simple_date = dateFormatter.parse(date_String);
          veterinary.setDateOfGraduation(simple_date);
          employees.add(veterinary);



        Medication tempMedication = new Medication();
        tempMedication.setDetails("foot rash wound");
        tempMedication.setDosage(8);
        date_String = "3/11/2019"; simple_date = dateFormatter.parse(date_String);
        tempMedication.setDuration(3);
        tempMedication.setNotes("Death");

        HealthTreatment healthTreatment = new HealthTreatment();
        healthTreatment.setEmergency(true);
        healthTreatment.setVeterinary(veterinary);
        date_String = "5/12/2013";  simple_date = dateFormatter.parse(date_String);
        healthTreatment.setDateOfTreatment(simple_date);


          healthTreatment.getMedications().add(tempMedication);
          cow1.getTreatments().add(healthTreatment);

             animals.add(cow1);

        Cow cow2 = new Cow();
        cow2.setGender("Female");
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        cow2.setTagNo(2);
        cow2.setPurchased(true);
        cow2.setWeight(550);

        HashMap<String,Double> milking2 = new HashMap<>();
        date_String = "20/11/2022";
        milking2.put(date_String,1.0);
        cow2.setMilking(milking2);


        date_String = "12/06/2022";  simple_date = dateFormatter.parse(date_String);
        cow2.setDateOfBirth(simple_date);

        FarmWorker farmWorker2 = new FarmWorker();
        farmWorker2.setWorkexperience(15);
        farmWorker2.setPreviousFarmName("KOOP");
        farmWorker2.setGender("Female");
        farmWorker2.setEmpID(3);
        date_String = "6/06/2006";  simple_date = dateFormatter.parse(date_String);
        farmWorker2.setDateOfBirth(simple_date);

        employees.add(farmWorker2);

        CleaningTreatment cleaningTreatment2 = new CleaningTreatment();
        cleaningTreatment2.setMaterialsused("Nail scissors");
        date_String = "7/07/2007";  simple_date = dateFormatter.parse(date_String);
        cleaningTreatment2.setDateOfTreatment(simple_date);

        cleaningTreatment2.setFarmWorker(farmWorker);

        cow2.getTreatments().add(cleaningTreatment2);



        Veterinary veterinary2 = new Veterinary();
        veterinary2.setExpertiseLevel(7);
        veterinary2.setGender("Male");
        veterinary2.setBScDegree(true);
        veterinary2.setEmpID(4);
        date_String = "8/08/1996";  simple_date = dateFormatter.parse(date_String);
        veterinary2.setDateOfBirth(simple_date);
        date_String = "9/09/2015";  simple_date = dateFormatter.parse(date_String);
        veterinary2.setDateOfGraduation(simple_date);
        employees.add(veterinary2);


        Medication tempMedication2 = new Medication();
        tempMedication2.setDetails("foot rash wound");
        tempMedication2.setDosage(8);
        date_String = "3/11/2019"; simple_date = dateFormatter.parse(date_String);
        tempMedication2.setDuration(3);
        tempMedication2.setNotes("Death");

        HealthTreatment healthTreatment2 = new HealthTreatment();
        healthTreatment2.setEmergency(true);
        healthTreatment2.setVeterinary(veterinary);
        date_String = "5/12/2013";  simple_date = dateFormatter.parse(date_String);
        healthTreatment2.setDateOfTreatment(simple_date);


        healthTreatment2.getMedications().add(tempMedication2);
        cow2.getTreatments().add(healthTreatment2);

        animals.add(cow2);


          Sheep sheep1 = new Sheep();
        HashMap<String,Double> milking3 = new HashMap<>();
        milking3.put("21/11/2022",2.0);
          sheep1.setMilking(milking3);

         sheep1.setGender("Female");
        sheep1.setPurchased(true);
        sheep1.setTagNo(3);
        date_String = "7/12/2001";  simple_date = dateFormatter.parse(date_String);
        sheep1.setDateOfBirth(simple_date);

        CleaningTreatment cleaningTreatment3 = new CleaningTreatment();
        cleaningTreatment3.setMaterialsused("Brush");
        date_String = "12/06/1959";  simple_date = dateFormatter.parse(date_String);
        cleaningTreatment3.setDateOfTreatment(simple_date);
        cleaningTreatment3.setFarmWorker(farmWorker);
        sheep1.getTreatments().add(cleaningTreatment3);


        Medication tempMedication3 = new Medication();
        tempMedication3.setDetails("painkiller");
        tempMedication3.setDosage(8);
        date_String = "3/11/2019"; simple_date = dateFormatter.parse(date_String);
        tempMedication3.setDuration(3);
        tempMedication3.setNotes("Death");


        HealthTreatment healthTreatment3 = new HealthTreatment();
        healthTreatment3.setEmergency(true);
        healthTreatment3.setVeterinary(veterinary);
        date_String = "12/06/1999";  simple_date = dateFormatter.parse(date_String);
        healthTreatment3.setDateOfTreatment(simple_date);

        healthTreatment3.getMedications().add(tempMedication3);
        sheep1.getTreatments().add(healthTreatment3);

        animals.add(sheep1);


        Sheep sheep2 = new Sheep();
        HashMap<String,Double> milking4 = new HashMap<>();
        milking4.put("22/11/2022",4.0);
        sheep2.setMilking(milking4);

        sheep2.setGender("Male");
        sheep2.setPurchased(true);
        sheep2.setTagNo(4);
        date_String = "8/12/2011";  simple_date = dateFormatter.parse(date_String);
        sheep2.setDateOfBirth(simple_date);


        CleaningTreatment cleaningTreatment4 = new CleaningTreatment();
        cleaningTreatment4.setMaterialsused("Brush");
        date_String = "12/06/1959";  simple_date = dateFormatter.parse(date_String);
        cleaningTreatment4.setDateOfTreatment(simple_date);
        cleaningTreatment4.setFarmWorker(farmWorker2);
        sheep2.getTreatments().add(cleaningTreatment4);




        Medication tempMedication4 = new Medication();
        tempMedication4.setDetails("painkiller");
        tempMedication4.setDosage(8);
        date_String = "3/11/2019"; simple_date = dateFormatter.parse(date_String);
        tempMedication4.setDuration(3);
        tempMedication4.setNotes("Death");
        HealthTreatment healthTreatment4 = new HealthTreatment();
        healthTreatment4.setEmergency(true);
        healthTreatment4.setVeterinary(veterinary);
        date_String = "12/06/2015";  simple_date = dateFormatter.parse(date_String);
        healthTreatment4.setDateOfTreatment(simple_date);

        healthTreatment3.getMedications().add(tempMedication4);
        sheep2.getTreatments().add(healthTreatment4);

        animals.add(sheep2);




    }


    /**
     * This method returns ArrayList with Animals.
     * @return ArrayList with Animals.
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    /**
     * This method returns ArrayList with Vets.
     * @return ArrayList with Vets.
     */
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
}
