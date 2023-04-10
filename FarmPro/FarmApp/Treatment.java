package FarmApp;

import java.util.Date;

/**
 * In this class I keep FarmApp.Treatment attributes and methods.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 */
public class Treatment {

    private Date dateOfTreatment;

    /**
     * This is a constructor
     * @param dateOfTreatment FarmApp.Treatment Date.
     */

    public Treatment(Date dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

    /**
     * This method gets the date of treatment.
     * @return Date of treatment.
     */
    public Date getDateOfTreatment() {
        return dateOfTreatment;
    }

    /**This is setter of date of treatment.
     *
     * @param dateOfTreatment  Date of treatment.
     */
    public void setDateOfTreatment(Date dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

    /**
     * This is a default constructor.
     */
    public Treatment()
    {
          dateOfTreatment = new Date();
    }
}
