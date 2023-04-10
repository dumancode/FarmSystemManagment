package FarmApp;

import java.util.Date;

/**
 * In this class I keep FarmApp.FarmWorker attributes and methods. It also has a subclass of FarmApp.Employee, so inherits its attributes.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 *
 *
 *
 */
public class FarmWorker extends Employee {
    private  String previousFarmName;
    private int workexperience;

    /**
     * It is a default constructor.
     */
    public FarmWorker()
    {
         previousFarmName = "";
         workexperience = 0;
    }

    /**
     * The constructor that sets all the fields of the FarmApp.Veterinary class.
     *empId,gender,dateOfBirth come to superclass which is FarmApp.Employee.
     * @param empID     the empId of FarmApp.FarmWorker
     * @param gender     the gender of FarmApp.FarmWorker
     * @param dateOfBirth  the birthday of FarmApp.FarmWorker
     * @param  previousFarmName the name of previousFarm of the FarmApp.FarmWorker.
     * @param workexperience  work experience of  FarmApp.FarmWorker.
     */
    public FarmWorker(int empID, String gender, Date dateOfBirth, String previousFarmName, int workexperience) {
        super(empID, gender, dateOfBirth);
        this.previousFarmName = previousFarmName;
        this.workexperience = workexperience;
    }


    /**This method returns the previousFarmName of FarmApp.FarmWorker.
     *
     * @return String value of previousFarmName of the FarmApp.FarmWorker.
     */
    public String getPreviousFarmName() {
        return previousFarmName;
    }
    /**
     * This method setter of PreviousFarmName
     * @param previousFarmName PreviousFarmName of FarmApp.FarmWorker.
     */
    public void setPreviousFarmName(String previousFarmName) {
        this.previousFarmName = previousFarmName;
    }

    /**This method returns the worke xperience of FarmApp.FarmWorker.
     *
     * @return int value of work experience of the FarmApp.FarmWorker.
     */
    public int getWorkexperience() {
        return workexperience;
    }
    /**
     * This method set Work experience
     * @param workexperience work experience of FarmApp.FarmWorker.
     */
    public void setWorkexperience(int workexperience) {
        this.workexperience = workexperience;
    }


    /**This method returns the Salary of FarmApp.FarmWorker.
     *
     * @return double value of Salary of the FarmApp.FarmWorker.
     */
    public double getSalary()
    {
       return (grossSalary +((grossSalary*0.02*workexperience)))  ;
    }


    /**
     * This method compare two objects' salary. If FarmApp.FarmWorker's salary is bigger then return 1 else 0.
     * @param o the object to be compared.
     * @return integer value indicating which object's salary is greater.
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
