
package FarmApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The part where all the elements of the GUI are located and the GUI is started. Here, the data is received by the user and
 * the operations requested by the users are performed. In addition, at the end of the operations,
 * the necessary functions of the DataStorge function are called to connect to the database and the data is updated in the
 * database.
 * @author  Furkan Duman 2453173
 * @version JDK19
 */

public class FirstPage  extends  JFrame implements  Runnable {


    private JButton addingCowButton;
    private JButton addingSheepButton;
    private JButton deleteCowButton;
    private JButton deleteSheepButton;
    private JButton getCowDetailsButton;
    private JButton getSheepDetailsButton;
    private JButton addVetButton;
    private JButton addFarmWorkerButton;
    private JButton deleteVetButton;
    private JButton getVetDetailsButton;
    private JButton addTreatmentButton;
    private JButton getCowTreatmentsButton;
    private JButton getCowTreatmentWithDateButton;
    private JButton getSalaryForEmployeeButton;
    private JButton listCowButton;
    private JButton listVetButton;
    private JButton addMikingButton;
    private JButton feedingAnimalButton;
    private JPanel Furkan;
    private JButton listSheepButton;
    private JButton listFarmWorkerButton;
    private JButton deleteFarmWorkerButton;
    private SimpleDateFormat dateFormatter;



    FirstPage()
    {

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Handler h = new Handler();

        listCowButton.addActionListener(h);
        listVetButton.addActionListener(h);
        listSheepButton.addActionListener(h);
        listFarmWorkerButton.addActionListener(h);
        addingCowButton.addActionListener(h);
        addingSheepButton.addActionListener(h);
        deleteCowButton.addActionListener(h);
        deleteSheepButton.addActionListener(h);
        getCowDetailsButton.addActionListener(h);
        getSheepDetailsButton.addActionListener(h);
        addVetButton.addActionListener(h);
        addFarmWorkerButton.addActionListener(h);
        deleteVetButton.addActionListener(h);
        addTreatmentButton.addActionListener(h);
        getCowTreatmentsButton.addActionListener(h);
        getCowTreatmentWithDateButton.addActionListener(h);
        getSalaryForEmployeeButton.addActionListener(h);
        addMikingButton.addActionListener(h);
        feedingAnimalButton.addActionListener(h);
        getVetDetailsButton.addActionListener(h);
        deleteFarmWorkerButton.addActionListener(h);


        JMenuBar menuBar = new JMenuBar();
        JMenu item1 = new JMenu("File");
        JMenu item2 = new JMenu("Edit");


        JMenuItem openFile = new JMenuItem("Open");

        JMenuItem nightMod = new JMenuItem("Dark Mod");
        JMenuItem lightMod = new JMenuItem("Light Mod");

        item1.add(openFile);

        item2.add(nightMod);
        item2.add(lightMod);
        menuBar.add(item1);
        menuBar.add(item2);

        addWindowListener(new WindowAdapter() {  // for exit operation
            @Override
            public void windowClosing(WindowEvent e) {
                try {

                /*
                *I am writing my "Animal" objects to Animal.txt using "ObjectOutputStream".
                *
                * */
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("addAnimal.txt"));

                    for (int i = 0; i < FarmApp.animals.size(); i++)
                    {
                        objectOutputStream.writeObject(FarmApp.animals.get(i));

                    }
                    objectOutputStream.close();

                    FileInputStream fis = new FileInputStream("addAnimal.txt");
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int ch;
                    while ((ch = bis.read()) != -1) {
                        baos.write(ch);
                    }
                    byte buffer[] = baos.toByteArray();
                    // Get a MessageDigest for the appropriate algorithm.
                    MessageDigest algorithm = MessageDigest.getInstance("MD5");

                    // Ensure the digest's buffer is empty.
                    algorithm.reset();

                    // Fill the digest's buffer with data to compute a message digest from.
                    algorithm.update(buffer);

                    // Generate the digest. This does any necessary padding required by the
                    // algorithm.
                    byte digest[] = algorithm.digest();

                    // Save or print digest bytes.
                    StringBuffer hexString = new StringBuffer();
                    for (int i = 0; i < digest.length; i++) {
                        hexString.append(Integer.toHexString(0xFF & digest[i]));

                    }
                    // I got the above code from Odtuclass. This code generates MD5 for "Animal.txt".
                    fis.close();




                    /*When closing the program, I add MD5 to oldKey.txt.
                    * */
                    File   oldKeytxt = new File("oldKey.txt");
                    if(!(oldKeytxt.exists())) oldKeytxt.createNewFile();


                    FileOutputStream fisOldKey = new FileOutputStream(oldKeytxt);

                    String str =   hexString.toString();
                    fisOldKey.write(str.getBytes());
                     //and writes the resulting MD5 to "oldKey.txt".
                    fisOldKey.close();




                } catch (FileNotFoundException exception) {
                    throw new RuntimeException(exception);
                } catch (IOException exception) {
                    throw new RuntimeException(exception);
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(Furkan, "GoodBye :) ");

            }
        });

        this.setJMenuBar(menuBar);

         openFile.addActionListener(new ActionListener() {

             public void actionPerformed(ActionEvent e) {
                 JFileChooser fileChooser = new JFileChooser();
                 fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                 int result = fileChooser.showOpenDialog(null);
                 if (result == JFileChooser.APPROVE_OPTION) {
                     File selectedFile = fileChooser.getSelectedFile();



                 }
             }

         });
        lightMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.WHITE);
            }
        });

           nightMod.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   getContentPane().setBackground(Color.BLACK);
               }
           });



    }

   /**
   When the threat start in the main, the run function runs and I create the object of my "GUI" and run it.
   * */
    public void run()
    {
        FirstPage fp = new FirstPage();

        fp.setContentPane(fp.Furkan);
        fp.setSize(700, 700);
        fp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fp.setVisible(true);


    }






/**
* The Handler class is an ActionListener and I can manage my buttons thanks to this class.
* */

    class Handler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // JOptionPane.showMessageDialog(new Frame(),"Title");
            if (e.getSource() == listCowButton) {
                // Furkan.setVisible(false);
                ListCow a = new ListCow();
                a.setVisible(true);
                Furkan.setEnabled(false);
            } else if (e.getSource() == listVetButton) {
                ListVet a = new ListVet();
                a.setVisible(true);
            } else if (e.getSource() == listSheepButton) {
                ListSheepGUI a = new ListSheepGUI();

            } else if (e.getSource() == listFarmWorkerButton) {
                listFarmWorkerGUI a = new listFarmWorkerGUI();
            } else if (e.getSource() == addingCowButton) {
                AddCowGUI a = new AddCowGUI();

            } else if (e.getSource() == addingSheepButton) {
                addSheepGUI a = new addSheepGUI();
            } else if (e.getSource() == deleteCowButton) {
                deleteCowGUI a = new deleteCowGUI();
            } else if (e.getSource() == deleteSheepButton) {
                deleteSheepGUI a = new deleteSheepGUI();
            } else if (e.getSource() == getCowDetailsButton) {
                getCowDetailsGUI a = new getCowDetailsGUI();
            } else if (e.getSource() == getSheepDetailsButton) {
                getSheepDetailsGUI a = new getSheepDetailsGUI();
            } else if (e.getSource() == addVetButton) {
                addvVetGUI a = new addvVetGUI();
            } else if (e.getSource() == addFarmWorkerButton) {
                addFarmWorkerGUI a = new addFarmWorkerGUI();
            } else if (e.getSource() == deleteVetButton) {
                deleteVetGUI a = new deleteVetGUI();
            } else if (e.getSource() == addTreatmentButton) {
                addTreatmentGUI a = new addTreatmentGUI();
            } else if (e.getSource() == getCowTreatmentsButton) {
                getCowTreatmentGUI a = new getCowTreatmentGUI();
            } else if (e.getSource() == getCowTreatmentWithDateButton) {
                getCowTreatmentWithDateGUI a = new getCowTreatmentWithDateGUI();
            }
            else if(e.getSource() == getSalaryForEmployeeButton)
            {
                getSalaryForEmployee a = new getSalaryForEmployee();
            }
            else if(e.getSource() == addMikingButton)
            {
                MilkingADDGUI a = new MilkingADDGUI();
            }
            else if(e.getSource() == feedingAnimalButton)
            {
                feedingAnimalGUI a = new feedingAnimalGUI();
            }
            else if(e.getSource() == getVetDetailsButton)
            {
                getVetDetailsGUI a = new getVetDetailsGUI();
            }
            else if(e.getSource() == deleteFarmWorkerButton)
            {
                deleteFarmWorker a = new deleteFarmWorker();
            }

        }
    }

    public static void main(String[] args) throws  Exception   {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        FarmApp.animals = new ArrayList<>();
        FarmApp.employees = new ArrayList<>();

        File addAnimal = new File("addAnimal.txt");
        if(!addAnimal.exists()) addAnimal.createNewFile();
        /*
        I am getting dates from database.
        * */
       DataStorage.readingDataBase();


           keyGenerator outerTh = new keyGenerator();
           outerTh.start();


           // I am calling the thread (GUI).
        Thread threadForGUI = new Thread(new FirstPage());
        threadForGUI.start();




    }



}

/**
In this thread, I am checking whether the "AddAnimal" txt has been changed while my program is closed.
 First of all, an MD5 is produced by reading "AddAnimal.txt", then I check the MD5 produced from the txt, where the "Animal"
objects before the program is opened, with the first MD5. If the two are the same,
it means that the txt file was not modified while the program was closed, if they are different, the txt file was changed.
* */
class keyGenerator extends Thread {

    public static StringBuffer hexString;



    public void run()
    {
        try {
            FileInputStream fis = new FileInputStream("addAnimal.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ch;
            while ((ch = bis.read()) != -1) {
                baos.write(ch);
            }
            byte buffer[] = baos.toByteArray();
            // Get a MessageDigest for the appropriate algorithm.
            MessageDigest algorithm = MessageDigest.getInstance("MD5");

            // Ensure the digest's buffer is empty.
            algorithm.reset();

            // Fill the digest's buffer with data to compute a message digest from.
            algorithm.update(buffer);

            // Generate the digest. This does any necessary padding required by the
            // algorithm.
            byte digest[] = algorithm.digest();

            // Save or print digest bytes.
             hexString = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


        int checkingHacker;

        BufferedReader fs1 = null;
        String x = null;
        try {
            fs1 = new BufferedReader(new FileReader("oldKey.txt"));
            x = fs1.readLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(x.equals(keyGenerator.returnNewKey()))
            checkingHacker = 1;
        else
            checkingHacker =  0;

        try {
            x = fs1.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(checkingHacker == 0)
            JOptionPane.showMessageDialog(null,"The data has been changed.");
        if(checkingHacker == 1)
            JOptionPane.showMessageDialog(null,"Your data is safe.");
    }


    public  static String returnNewKey()
    {
        return  hexString.toString();
    }


}


