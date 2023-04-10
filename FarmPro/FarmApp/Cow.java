package FarmApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * In this class I keep FarmApp.FarmApp.Cow attributes and methods.FarmApp.FarmApp.Cow class also have  attributes and method which is come to FarmApp.FarmApp.Animal class.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 *
 */
public class Cow extends Animal
{

    private double weight;



    /**The constructor that sets all the fields of the FarmApp.FarmApp.Cow class.
     *
     * @param tagNo  The tagNo of cow
     * @param gender  The gender of FarmApp.FarmApp.Cow
     * @param dateOfBirth The birthday of FarmApp.FarmApp.Cow
     * @param purchased   Showing whether the cow has been sold or not
     * @param milking        HashMap value for FarmApp.FarmApp.Cow for milking measurement
     * @param treatments   Treatments of FarmApp.FarmApp.Cow
     */

    public Cow(int tagNo, String gender, Date dateOfBirth, boolean purchased, HashMap milking, ArrayList<Treatment> treatments, double weight) {
        super(tagNo, gender, dateOfBirth, purchased, milking, treatments);
        this.weight = weight;
        treatments = new ArrayList<>();
        this.getTreatments().addAll(treatments);
    }




    /**
     * Default constructor, which I initial the following values as default.
     */
public Cow() {

    setWeight(0);

}



    /**
     * This method  shows what the cow will eat under what conditions.
     */
    public void feeding()
    {
        SimpleDateFormat dateFormatter =   new SimpleDateFormat("dd/MM/yyyy");
        if(getAge() <3)
        {
            System.out.println("They are only fed with grass");
        }

        else if(getAge() < 5 && getWeight() < 500)
        {
            System.out.println("it needs Total mixed ration (TMR) is a diet that\n" +
                    "includes hay, fermented grass (silage), maize silage and\n" +
                    "high energy grains like brewers grains, soy bean, cotton\n" +
                    "seed and citrus pulp.");
        }
        else if(getAge() > 10 )
        {
            System.out.println("They need grains and oilseed meals.");
        }
        else
        {
            System.out.println("They are only fed with grass and grains.");
        }

    }

    /**
     * This method return the weight of FarmApp.FarmApp.Cow
     * @return double value of weight of FarmApp.FarmApp.Cow.
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * This function set weight of FarmApp.FarmApp.Cow.
     * @param weight weight of FarmApp.FarmApp.Cow
     */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }



}
