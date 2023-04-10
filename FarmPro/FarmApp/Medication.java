package FarmApp;

import java.util.Date;

/**
 * In this class I keep FarmApp.Medication attributes and methods.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 *
 *
 *
 */
public class Medication
{
    private String details;
    private int duration;
    private Date startDate;
    private double Dosage;
    private String notes;

    /**
     *
     * Default constructor, which I initial the following values as default.
     */
    public Medication() {
        String details = "";
        duration = 0;
        startDate = new Date() ;
        Dosage = 0.0;
        notes = " ";
    }

    /**
     * The constructor that sets all the fields of the FarmApp.FarmApp.Cow class.
     * @param details  The details of medication
     * @param duration  The duration of medication
     * @param startDate  The startDate of medication
     * @param dosage  The dosage of medication
     * @param notes    The notes of medication
     */
    public Medication(String details, int duration, Date startDate, double dosage, String notes) {
        this.details = details;
        this.duration = duration;
        this.startDate = startDate;
        Dosage = dosage;
        this.notes = notes;
    }

    /**
     * This method returns the details of medication.
     *
     * @return String of value.
     */
    public String getDetails() {
        return details;
    }

    /**
     * This method sets the details of medication.
     *
     * @param details The new details of medication.
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * This method returns the duration of medication.
     * @return Integer of value.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * This method sets the duration of medication.
     *
     * @param duration The new duration of medication.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * This method returns the start date of medication.
     * @return Date type    of start date.
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * This method sets the start date of medication.
     *
     * @param startDate The new start date of medication.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method returns the dosag of medication.
     * @return double type of dosage of FarmApp.Medication.
     */
    public double getDosage() {
        return Dosage;
    }
    /**
     * This method sets the dosage of medication.
     *
     * @param dosage The new dosage of medication.
     */

    public void setDosage(double dosage) {
        Dosage = dosage;
    }
    /**
     * This method returns the notes of medication.
     * @return String type of value.
     */
    public String getNotes() {
        return notes;
    }
    /**
     * This method sets the notes of medication.
     *
     * @param notes The new notes of medication.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
