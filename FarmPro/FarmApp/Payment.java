package FarmApp;

/**
 * This is a Interface for FarmApp.Employee class.
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 *
 */
public  interface Payment {
    /**
     * It is a final value of grossSalary.
     */
    double grossSalary = 10000;

    /**
     * This is a abstract method which will be used FarmApp.Veterinary and FarmApp.FarmWorker classes.
     * @return
     */
    double getSalary();


}
