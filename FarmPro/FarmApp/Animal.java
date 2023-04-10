package FarmApp;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/**
 * In this class I keep FarmApp.FarmApp.Animal attributes and methods. We inherits those values where FarmApp.FarmApp.Cow and FarmApp.Sheep classes.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 *
 */
public abstract  class Animal implements Serializable {


    private int tagNo;
    private String gender;
    private Date dateOfBirth;
    private boolean purchased;
    private HashMap milking;
    private ArrayList<Treatment> treatments;

    /**
     *
     * @param tagNo  The tagNo of FarmApp.FarmApp.Animal
     * @param gender  The gender of FarmApp.FarmApp.Animal
     * @param dateOfBirth The birthday of FarmApp.FarmApp.Animal
     * @param purchased   Showing whether the FarmApp.FarmApp.Animal has been sold or not
     * @param milking        HashMap value for FarmApp.FarmApp.Animal for milking measurement
     * @param treatments   Treatments of FarmApp.FarmApp.Animal
     */

    public Animal(int tagNo, String gender, Date dateOfBirth, boolean purchased, HashMap milking, ArrayList<Treatment> treatments) {
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
        this.milking = milking;
        treatments = new ArrayList<>();
        this.treatments.addAll(treatments);
    }

    /**
     * Default constructor, which I initial the following values as default.
     */
    public Animal() {
        tagNo = 0;
        gender = "unknowable";
        dateOfBirth =  new Date();
        purchased = false;
        treatments = new ArrayList<>();
        milking =new HashMap<String,Double>();
    }


    /**
     *This mehe tag number.
     * @return The integer of valuthod returns te.
     *
     */
    public int getTagNo() {
        return tagNo;
    }
    /**
     * Setter of tagNo of FarmApp.FarmApp.Animal.
     * @param tagNo The new  tagNo of FarmApp.FarmApp.Animal.
     */

    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }
    /**
     * This method returns gender of FarmApp.FarmApp.Animal.
     * @return The gender of FarmApp.FarmApp.Animal.
     */

    public String getGender() {
        return gender;
    }
    /**
     * Setter of gender of FarmApp.FarmApp.Animal.
     * @param gender The gender of FarmApp.FarmApp.Animal.
     *
     *
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**This method returns birthday of FarmApp.FarmApp.Animal.
     *
     * @return The birthday of FarmApp.FarmApp.Animal.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * Setter of birthday of FarmApp.FarmApp.Animal.
     * @param dateOfBirth The new birthday of FarmApp.FarmApp.Animal.
     */

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**This method returns FarmApp.FarmApp.Animal's purchased information.
     *
     * @return The purchased information of FarmApp.FarmApp.Animal.
     */
    public boolean isPurchased() {
        return purchased;
    }
    /**
     * Setter of FarmApp.FarmApp.Animal's purchased information.
     * @param purchased The FarmApp.FarmApp.Animal's purchased information.
     */
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    /**This method returns FarmApp.FarmApp.Animal's purchased information.
     * @return
     */
    public HashMap getMilking() {
        return milking;
    }
    /**
     * Setter of FarmApp.FarmApp.Animal's milking information.
     * @param milking The cow's purchased information.
     */
    public void setMilking(HashMap milking) {
        this.milking = milking;
    }

    /**
     * This is a abstract function of abstract FarmApp.FarmApp.Animal class.
     */

    public abstract void feeding();
    /**
     * This method returns the treatments of FarmApp.FarmApp.Animal.
     *
     * @return The arraylist of treatments.
     */
    public ArrayList<Treatment> getTreatments() {
        return treatments;
    }

    /**
     * This method sets the treatments of FarmApp.FarmApp.Animal.
     *
     * @param treatments The new treatments of FarmApp.FarmApp.Animal.
     */

    public void setTreatments(ArrayList<Treatment> treatments) {
        this.treatments = treatments;
    }



    /**This method calculate FarmApp.FarmApp.Animal's age.
     *
     * @return Int value of FarmApp.FarmApp.Animal's age.
     */
    public int getAge()
    {
        SimpleDateFormat dateFormatter =   new SimpleDateFormat("dd/MM/yyyy");
        int current_Year = 2022;
        String[] array ;

        String birthyear =  dateFormatter.format(getDateOfBirth());
        array= birthyear.split("/");

        return (2022- Integer.parseInt(array[2]));
    }


}
