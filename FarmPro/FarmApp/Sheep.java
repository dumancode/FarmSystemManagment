package FarmApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * In this class I keep FarmApp.Sheep attributes and methods.FarmApp.Sheep class also have  attributes and method which is come to FarmApp.FarmApp.Animal class.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 *
 */
public class Sheep extends Animal
{

    /**The constructor that sets all the fields of the FarmApp.FarmApp.Cow class.
     *
     * @param tagNo  The tagNo of FarmApp.Sheep
     * @param gender  The gender of FarmApp.Sheep
     * @param dateOfBirth The birthday of FarmApp.Sheep
     * @param purchased   Showing whether the FarmApp.Sheep has been sold or not
     * @param milking        HashMap value for FarmApp.Sheep for milking measurement
     * @param treatments   Treatments of FarmApp.Sheep
     */

    public Sheep(int tagNo, String gender, Date dateOfBirth, boolean purchased, HashMap milking, ArrayList<Treatment> treatments) {
        super(tagNo, gender, dateOfBirth, purchased, milking, treatments);
    }

    /**
     * Default constructor for FarmApp.Sheep. It is empty because all attributes of FarmApp.Sheep are come to superclass which is FarmApp.FarmApp.Animal.
     */
    public Sheep() {


    }




    /**
     * This method  shows what the FarmApp.Sheep will eat under what conditions.
     */
    public void feeding()
    {
        SimpleDateFormat dateFormatter =   new SimpleDateFormat("dd/MM/yyyy");
        if(getAge() <5)
        {
            System.out.println("They are only fed with grass");
        }

        else if(getAge() < 8 && getGender().equalsIgnoreCase("Female"))
        {
            System.out.println("They only fed with grass.");
        }
        else if(getAge() > 5 && getGender().equalsIgnoreCase("Male") )
        {
            System.out.println("Total mixed ration (TMR) diet is needed.");
        }

        else if(getGender().equalsIgnoreCase("Female") && getAge()>8)
        {
            System.out.println("Total mixed ration (TMR) diet is needed.");

        }

    }


}
