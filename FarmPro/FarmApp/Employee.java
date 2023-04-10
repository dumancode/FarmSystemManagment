package FarmApp;

import java.io.Serializable;
import java.util.Date;

/**
 * In this class I keep FarmApp.Employee attributes and methods.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 *
 *
 *
 */
    public abstract class Employee implements Payment,Comparable , Serializable {

        private int empID;
    private String gender;
    private Date dateOfBirth;

    /**
     * This is a constructor of FarmApp.Employee class.
     * @param empID  int value ofEmployeeId
     * @param gender  String value of gender
     * @param dateOfBirth  Date value of dateOfBirth
     */
        public Employee(int empID, String gender, Date dateOfBirth) {
            this.empID = empID;
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
        }

    /**
     * It is a default constructor.
     */
        public Employee() {
          empID = 0;
          gender = "unknown";
          dateOfBirth = new Date();
        }

    /**
     * This method get to EmpId
     * @return  int value of empID.
     */
    public int getEmpID() {
            return empID;
        }

    /**
     * This method set to EmpID.
     * @param empID int value of empID.
     */
    public void setEmpID(int empID) {
            this.empID = empID;
        }
    /**
     * This method get to gender
     * @return String value of gender.
     */
        public String getGender() {
            return gender;
        }
    /**
     * This method set to gender.
     * @param gender String value of gender.
     */
        public void setGender(String gender) {
            this.gender = gender;
        }
    /**
     * This method get to DateOfBirth
     * @return Date value of DateOfBirth
     */
        public Date getDateOfBirth() {
            return dateOfBirth;
        }
    /**
     * This method set to DateOfBirth.
     * @param dateOfBirth Date value of DateOfBirth.
     */
        public void setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
    /**
     * This method get to salary
     * @return double value of salary
     */

        public double getSalary() {
            return 0;
        }

    /**
     * It is a compareTo method.
     * @param o the object to be compared.
     * @return Integer default 0.
     */
        public int compareTo(Object o) {
            return 0;
        }
    }
