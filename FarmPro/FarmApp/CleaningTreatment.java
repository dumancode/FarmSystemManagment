package FarmApp;

import java.util.Date;

/**
 * In this class I keep FarmApp.FarmApp.CleaningTreatment attributes and methods. It is also  a subclass of FarmApp.Treatment, so inherits its attributes.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 */
public class CleaningTreatment extends Treatment {

    private String materialsused;
    FarmWorker farmWorker;

    /**It is a default constructor for Cleaning FarmApp.Treatment.
     *
     */
    public CleaningTreatment()
    {
        this.materialsused = "";
        farmWorker = new FarmWorker();
    }

    /**
     * In this constructor, I call super class constructor than other variables be initialized.
     * @param dateOfTreatment It will be initialized in parent class.
     * @param materialsused
     * @param farmWorker
     */
    public CleaningTreatment(Date dateOfTreatment, String materialsused, FarmWorker farmWorker) {
        super(dateOfTreatment);
        this.materialsused = materialsused;
        this.farmWorker = farmWorker;
    }



    /***
     *This method getter of which material used in FarmApp.FarmApp.CleaningTreatment.
     * @return String value of Material
     */
    public String getMaterialsused() {
        return materialsused;
    }

    /**
     *This method get the FarmApp.FarmWorker.
     * @return FarmApp.FarmWorker object.
     */
    public FarmWorker getFarmWorker() {
        return farmWorker;
    }

    /**
     * This method setter FarmApp.FarmWorker
     * @param farmWorker FarmApp.FarmWorker object.
     */
    public void setFarmWorker(FarmWorker farmWorker) {
        this.farmWorker = farmWorker;
    }

    /**
     * This method setter  Material.
     * @param materialsused
     */
    public void setMaterialsused(String materialsused) {
        this.materialsused = materialsused;
    }
}
