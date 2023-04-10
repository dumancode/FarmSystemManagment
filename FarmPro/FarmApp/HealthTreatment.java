package FarmApp;

import java.util.ArrayList;
import java.util.Date;


/**
 * In this class I keep FarmApp.HealthTreatment attributes and methods. It is also  a subclass of FarmApp.Treatment, so inherits its attributes.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 */
public class HealthTreatment extends Treatment {
    private boolean emergency;
    Veterinary veterinary;
    private ArrayList<Medication> medications;


    /**It is a default constructor for Health FarmApp.Treatment.
     *
     */
    public  HealthTreatment()
    {
        emergency = false;
        veterinary = new Veterinary();
        medications = new ArrayList<>();
    }

    /** Constructor of FarmApp.HealthTreatment
     *
     * @param dateOfTreatment  It will  come  to superclass' constructor which is FarmApp.Treatment.
     * @param emergency emergency information of FarmApp.HealthTreatment
     * @param veterinary veterinary information of FarmApp.HealthTreatment
     * @param medications medications information of FarmApp.HealthTreatment
     */

    public HealthTreatment(Date dateOfTreatment, boolean emergency, Veterinary veterinary, ArrayList<Medication> medications) {
        super(dateOfTreatment);
        this.emergency = emergency;
        this.veterinary = veterinary;
        this.medications = medications;
    }

    /**
     * This method get the Emergency information of FarmApp.Treatment.
     * @return emergency information of FarmApp.HealthTreatment
     */
    public boolean isEmergency() {
        return emergency;
    }

    /**This method set the Emergency information of FarmApp.Treatment.
     *
     * @param emergency emergency information of FarmApp.HealthTreatment
     */
    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
    /**
     *This method get the FarmApp.Veterinary.
     * @return veterinary object.
     */
    public Veterinary getVeterinary() {
        return veterinary;
    }

    /**
     * This method set the FarmApp.Veterinary.
     * @param veterinary veterinary object.
     */
    public void setVeterinary(Veterinary veterinary) {
        this.veterinary = veterinary;
    }

    /**
     * This method get the Medications of FarmApp.HealthTreatment.
     *
     * @return veterinary veterinary object.
     */
    public ArrayList<Medication> getMedications() {
        return medications;
    }
    /**
     * This method set the Medications of FarmApp.HealthTreatment.
     * @param medications medications object.
     */
    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }
}
