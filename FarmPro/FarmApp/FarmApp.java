package FarmApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

public class FarmApp {

    public static ArrayList<Animal> animals;
    public static ArrayList<Employee> employees;

    private SimpleDateFormat dateFormatter;
    private Scanner sc;


    public FarmApp() {
        animals = new ArrayList<Animal>();
        employees = new ArrayList<Employee>();

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        sc = new Scanner(System.in);
    }






    public FarmApp(ArrayList<Animal> animals, ArrayList<Employee> employees) {
        this.animals = animals;
        this.employees = employees;
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        sc = new Scanner(System.in);

    }







}






















