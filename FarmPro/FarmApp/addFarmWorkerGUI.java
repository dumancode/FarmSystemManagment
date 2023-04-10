package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addFarmWorkerGUI extends  JFrame {
    private JPanel panel1;
    private JTextField textFieldID;
    private JTextField textFieldGender;
    private JTextField textFieldPreviousFarmName;
    private JTextField textFieldWorkE;
    private JTextField textFieldBirthday;
    private JLabel tID;
    private JLabel tGender;
    private JLabel tBirthday;
    private JLabel tGraduate;
    private JLabel tExpertise;
    private JButton ADDButton;
    private JPanel panel;

    private SimpleDateFormat dateFormatter;
    public addFarmWorkerGUI()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(800,800);
        setTitle("ADD VET");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addFarmWorker();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }

    public void addFarmWorker() throws ParseException {


        boolean check = true;
        int id = Integer.parseInt(textFieldID.getText());

        for (Employee theWorker : FarmApp.employees) {


            if (theWorker.getEmpID() == id)
            {
                JOptionPane.showMessageDialog(panel1,"There is a employee with this ID");
                check = false;

            }
        }


        if(check)
        {
            String gender = textFieldGender.getText();


            String birth = textFieldBirthday.getText();
            Date date = dateFormatter.parse(birth);



            String previousFarmName = textFieldPreviousFarmName.getText();


            int workexperience = Integer.parseInt(textFieldWorkE.getText());


            FarmWorker farmWorker = new FarmWorker();
            farmWorker.setEmpID(id);
            farmWorker.setDateOfBirth(date);
            farmWorker.setGender(gender);
            farmWorker.setPreviousFarmName(previousFarmName);
            farmWorker.setWorkexperience(workexperience);

            FarmApp.employees.add(farmWorker);
            JOptionPane.showMessageDialog(panel1,"FarmWorker be added !");
            DataStorage.addEmployee(farmWorker);

          /*  try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Furka\\IdeaProjects\\Assig3\\addFarmWorker.txt",true))
            {
                fos.write(String.valueOf(id).getBytes());
                fos.write(32);
                fos.write(gender.getBytes());  fos.write(32);
                fos.write(dateFormatter.format(date).getBytes());  fos.write(32);
                fos.write(previousFarmName.getBytes());  fos.write(32);
                fos.write(String.valueOf(workexperience).getBytes());  fos.write(32);
                fos.write(10);
            }
            catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
        }



    }
}
