package FarmApp;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.ZoneId;

/**
 * The part where I connect to the database and get the data.
 *
 *
 *  @author  Furkan Duman 2453173
 *   @version JDK19
 *
 *

 */
public class DataStorage {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/FarmAppDB";
    static final String USER = "cng443user";
    static final String PASS = "1234";

/**
* In this class, I connect to the database of the above information.
* I'm reading the Animal and Employee rows, respectively.
* And I add these objects to the animals and employee arraylists in FarmApp.
* */
    public static void readingDataBase()
    {
        Connection connection = null;
        Statement statement = null;

        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // STEP 2 -- Establish a connection
            System.out.println("Establishing a connection");
            connection =(Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database connected");

            // STEP 3 -- Create a statement
            statement = (Statement)connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);


                // STEP 4 -- Execute a statement      for READING
            ResultSet resultSet = statement.executeQuery("select * from Animal");



            // Iterate through the result and print the student names
            while (resultSet.next())
            {
                if(resultSet.getString(5).equalsIgnoreCase("c"))
                {
                    Cow tempCow = new Cow();
                    tempCow.setTagNo(resultSet.getInt(1));
                    if(resultSet.getString(2).equalsIgnoreCase("m"))
                        tempCow.setGender("Male");
                    else
                        tempCow.setGender("Female");
                    tempCow.setGender(resultSet.getString(2));
                    tempCow.setDateOfBirth(resultSet.getDate(3));
                    if(resultSet.getInt(4) == 1)
                    tempCow.setPurchased(true);
                   else
                        tempCow.setPurchased(false);

                   tempCow.setWeight(resultSet.getDouble(6));

                   FarmApp.animals.add(tempCow);
                }

                if(resultSet.getString(5).equalsIgnoreCase("s"))
                {
                    Sheep tempSheep = new Sheep();
                    tempSheep.setTagNo(resultSet.getInt(1));
                    if(resultSet.getString(2).equalsIgnoreCase("m"))
                        tempSheep.setGender("Male");
                    else
                        tempSheep.setGender("Female");


                     tempSheep.setDateOfBirth(resultSet.getDate(3));

                    if(resultSet.getInt(4) == 1)
                        tempSheep.setPurchased(true);
                    else

                        tempSheep.setPurchased(false);

                    FarmApp.animals.add(tempSheep);


                }

            }


            ResultSet resultSetForEmp = statement.executeQuery("select * from Employee");

            while(resultSetForEmp.next())
            {
                if(resultSetForEmp.getString(4).equalsIgnoreCase("f"))
                {
                    FarmWorker tempFW = new FarmWorker();
                    tempFW.setEmpID(resultSetForEmp.getInt(1));


                    if(resultSetForEmp.getString(2).equalsIgnoreCase("m"))
                        tempFW.setGender("Male");
                    else
                        tempFW.setGender("Female");


                    tempFW.setDateOfBirth(resultSetForEmp.getDate(3));
                    tempFW.setPreviousFarmName(resultSetForEmp.getString(8));
                    tempFW.setWorkexperience(resultSetForEmp.getInt(9));

                    FarmApp.employees.add(tempFW);

                }

                if(resultSetForEmp.getString(4).equalsIgnoreCase("v"))
                {
                    Veterinary tempVet = new Veterinary();
                    tempVet.setEmpID(resultSetForEmp.getInt(1));

                    if(resultSetForEmp.getString(2).equalsIgnoreCase("m"))
                        tempVet.setGender("Male");
                    else
                        tempVet.setGender("Female");

                    tempVet.setDateOfBirth(resultSetForEmp.getDate(3));
                    if(resultSetForEmp.getInt(5) == 1)
                    tempVet.setBScDegree(true);
                    else
                        tempVet.setBScDegree(false);
                    tempVet.setDateOfGraduation(resultSetForEmp.getDate(6));



                    FarmApp.employees.add(tempVet);

                }
            }





        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }


    /**In this function, I first connect to my database. Using the "INSERT INTO" query,
I am adding the data of the animal object from the GUI to my database.
The data were added to the database in the format requested in the assignment.
     @param theAnimal  the Animal object which entered into the GUI to be added by the user
    * */
    public static void addAnimal(Animal theAnimal ){

        Connection connection = null;
        Statement statement = null;

        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // STEP 2 -- Establish a connection
            System.out.println("Establishing a connection");
            connection =(Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database connected");

            // STEP 3 -- Create a statement
            statement = (Statement)connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);




          PreparedStatement adding = connection.prepareStatement(
                    "INSERT INTO animal (tagNo, gender, dateOfBirth,purchased,type,Weight) VALUES (?, ?, ?,?,?,?)");
            adding.setInt(1, theAnimal.getTagNo());


            String forGender="";
            if(theAnimal.getGender().equalsIgnoreCase("Male"))
                forGender="m";
            else
                forGender="f";

            adding.setString(2, forGender);


            java.util.Date date=theAnimal.getDateOfBirth();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            adding.setDate(3, sqlDate);


            int forPurchased;
            if(theAnimal.isPurchased())
                forPurchased=1;
            else forPurchased= 0;

            adding.setInt(4,forPurchased);

            String checkAnimalType="";

            if(theAnimal instanceof  Cow)
                checkAnimalType="C";
            else
                checkAnimalType ="S";

           adding.setString(5,checkAnimalType);


           if(checkAnimalType.equals("C"))
           {
               Cow tempCow = (Cow) theAnimal;
               adding.setInt(6,(int)tempCow.getWeight());
           }
           else
               adding.setInt(6,-1);

            adding.executeUpdate();



        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }

    /**In this function, I first connect to my database. Using the "DELETE FROM query,
    According to the tagNo data which entered in the GUI, I find this animal from my database and delete it.
       @param AnimalTag the integer value of tagNo value of the animal to be deleted by the user.
    * */
   public static void deleteAnimal(int AnimalTag)
   {
       Connection connection = null;
       Statement statement = null;

       try {
           // STEP1 -- Load the JDBC driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("Driver loaded");

           // STEP 2 -- Establish a connection
           System.out.println("Establishing a connection");
           connection =(Connection) DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("Database connected");

           // STEP 3 -- Create a statement
           statement = (Statement)connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);



           statement.executeUpdate ("DELETE FROM Animal WHERE tagNo = " +AnimalTag );

      // int rowsAffected = stmt.executeUpdate(sql);

       } catch (SQLException se) {
           // Handle errors for JDBC
           se.printStackTrace();
       } catch (Exception e) {
           // Handle errors for Class.forName
           e.printStackTrace();
       } finally {
           // finally block used to close resources
           try {
               if (statement != null)
                   statement.close();
           } catch (SQLException se2) {
           } // nothing we can do
           try {
               if (connection != null)
                   connection.close();
           } catch (SQLException se) {
               se.printStackTrace();
           } // end finally try
       } // end try
   }

    /**In this function, I first connect to my database. Using the "INSERT INTO" query,
I am adding the data of the employee object from the GUI to my database.
The data were added to the database in the format requested in the assignment.

     @param theEmp  the Employee object which entered into the GUI to be added by the user
  * */
    public static void addEmployee(Employee theEmp )
    {
        Connection connection = null;
        Statement statement = null;

        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // STEP 2 -- Establish a connection
            System.out.println("Establishing a connection");
            connection =(Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database connected");

            // STEP 3 -- Create a statement
            statement = (Statement)connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);




            PreparedStatement addingEmp = connection.prepareStatement(
                    "INSERT INTO employee (empID, gender, dateOfBirth,type,BScDegree,dateOfGraduation,expertiseLevel,previousFarmName,workExperience)" +
                            " VALUES (?, ?, ?,?,?,?,?,?,?)");

            addingEmp.setInt(1, theEmp.getEmpID());


            String forGender="";
            if(theEmp.getGender().equalsIgnoreCase("Male"))
                forGender="m";
            else
                forGender="f";

            addingEmp.setString(2, forGender);





            java.util.Date date=theEmp.getDateOfBirth();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            addingEmp.setDate(3, sqlDate);



            String checkEmpType="";

            if(theEmp instanceof  Veterinary)
                checkEmpType="v";
            else
                checkEmpType ="f";

            addingEmp.setString(4,checkEmpType);

            int intBscDegree = 0;

            if(checkEmpType.equals("v"))
            {
                Veterinary tempVet = (Veterinary) theEmp;


                if(tempVet.isBScDegree())
                    intBscDegree=1;

                addingEmp.setInt(5,intBscDegree);

                java.util.Date dateofGraduate=tempVet.getDateOfGraduation();
                sqlDate=new java.sql.Date(date.getTime());
                addingEmp.setDate(6, sqlDate);

                addingEmp.setInt(7, tempVet.getExpertiseLevel());
                addingEmp.setString(8,"");
                addingEmp.setInt(9, -1);

            }

            if(checkEmpType.equals("f"))
            {
                FarmWorker tempFW = (FarmWorker)theEmp;

                addingEmp.setInt(5, -1); // default

                java.util.Date dateofGraduate= new java.util.Date();
                sqlDate=new java.sql.Date(date.getTime());

                addingEmp.setDate(6, sqlDate);
                addingEmp.setInt(7, -1);
                addingEmp.setString(8,tempFW.getPreviousFarmName());
                addingEmp.setInt(9, tempFW.getWorkexperience());

            }







            addingEmp.executeUpdate();

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }

    /**In this function, I first connect to my database. Using the "DELETE FROM query,
     According to the empID data which entered in the GUI, I find this employee from my database and delete it.

    @param employeeTag   the integer value of empID value of the Employee to be deleted by the user.
     * */

    public static void deleteEmployee(int employeeTag)
    {
        Connection connection = null;
        Statement statement = null;

        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // STEP 2 -- Establish a connection
            System.out.println("Establishing a connection");
            connection =(Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database connected");

            // STEP 3 -- Create a statement
            statement = (Statement)connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);



            statement.executeUpdate ("DELETE FROM employee WHERE empID = " +employeeTag );

            // int rowsAffected = stmt.executeUpdate(sql);

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
}
