package FarmApp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this class I keep Vet attributes and methods. It also has a subclass of FarmApp.Employee, so inherits its attributes.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 *
 *
 *
 */
public class Veterinary extends Employee {
    private boolean BScDegree;
    private Date dateOfGraduation;
    private int expertiseLevel;
    /**
     * The constructor that sets all the fields of the FarmApp.Veterinary class.
     * empId,gender,dateOfBirth come to superclass which is FarmApp.Employee.
     *
     * @param empID     the empId of FarmApp.Veterinary
     * @param gender     the gender of FarmApp.Veterinary
     * @param dateOfBirth  the birthday of FarmApp.Veterinary
     * @param BScDegree       the salary of FarmApp.Veterinary
     * @param dateOfGraduation       the date of graduation of FarmApp.Veterinary
     * @param expertiseLevel       the expertise level of FarmApp.Veterinary
     */
    public Veterinary(int empID, String gender, Date dateOfBirth, boolean BScDegree, Date dateOfGraduation, int expertiseLevel) {
        super(empID, gender, dateOfBirth);
        this.BScDegree = BScDegree;
        this.dateOfGraduation = dateOfGraduation;
        this.expertiseLevel = expertiseLevel;
    }

    /**
     * The constructor that sets all the fields of the FarmApp.Veterinary class.
     * empId,gender,dateOfBirth come to superclass which is FarmApp.Employee.
     *
     * @param empID     the empId of FarmApp.Veterinary
     * @param gender     the gender of FarmApp.Veterinary
     * @param dateOfBirth  the birthday of FarmApp.Veterinary

     */
    public Veterinary(int empID, String gender, Date dateOfBirth) {
        super(empID, gender, dateOfBirth);
    }
    /**
     * Default constructor, which I initial the following values as default.
     */
public Veterinary(){
    setEmpID(-1);
    setGender("Unknown");
    setBScDegree(false);
    setDateOfBirth(new Date());
    setExpertiseLevel(0);

}

    /**This method returns the BscDegree of Vet.
     *
     * @return boolean value of BscDegree of the Vet.
     */
    public boolean isBScDegree() {
        return BScDegree;
    }
    /**
     * This method sets the BscDegree of Vet.
     *
     * @param BScDegree The BscDegree of Vet.
     */
    public void setBScDegree(boolean BScDegree) {
        this.BScDegree = BScDegree;
    }

    /**
     *This method returns the date of Graduation of Vet.
     * @return The Date of Graduation of Vet.
     *
     */
    public Date getDateOfGraduation() {
        return dateOfGraduation;
    }
    /**
     * This method sets date of Graduation of Vet.
     *
     * @param dateOfGraduation The new Date of Graduation of Vet.
     */
    public void setDateOfGraduation(Date dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }
    /**
     *This method returns the date of expertise Level of Vet.
     * @return The integer of expertise Level of Vet.
     *
     */
    public int getExpertiseLevel() {
        return expertiseLevel;
    }
    /**
     * This method sets the expertise Level of Vet.
     *
     * @param expertiseLevel The new birthday of Vet.
     */
    public void setExpertiseLevel(int expertiseLevel) {
        this.expertiseLevel = expertiseLevel;
    }

    /**
     *This method returns the graduate year of Vet.
     * @return The integer of graduate year of  Vet.
     *
     */
    private int getYearOfGraduate()
    {
        SimpleDateFormat dateFormatter =   new SimpleDateFormat("dd/MM/yyyy");
        int current_Year = 2022;
        String[] array ;

        String birthyear =  dateFormatter.format(getDateOfGraduation());
        array= birthyear.split("/");

        return (2022- Integer.parseInt(array[2]));
    }
    /**
     *This method returns the salary year of Vet.
     * @return The double of salary  of  Vet.
     *
     */
    public double getSalary()
    {
        return grossSalary +(0.01*grossSalary*getYearOfGraduate())  ;
    }

    /**
     *
     * @param o the object to be compared.
     * @return The int value for which one salary's bigger or than.
     */

    public int compareTo(Object o)
    {
        Veterinary obje1 = (Veterinary) o;
        if( this.getSalary()> obje1.getSalary())
            return 1;
        else
            return 0;


    }
}
