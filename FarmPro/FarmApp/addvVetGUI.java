package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addvVetGUI  extends  JFrame {
    private JTextField textFieldID;
    private JTextField textFieldGender;
    private JTextField textFieldBirthday;
    private JTextField textFieldGraduateDate;
    private JTextField textFieldExpertiseLevel;
    private JButton button1;
    private JLabel tID;
    private JLabel tGender;
    private JLabel tBirthday;
    private JLabel tGraduate;
    private JLabel tExpertise;
    private JLabel tBScDegree;
    private JComboBox comboBox1;
    private JPanel panel1;
    private SimpleDateFormat dateFormatter;

    public addvVetGUI()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(800,800);
        setTitle("ADD VET");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    addVet();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void addVet() throws ParseException {



        int id = Integer.parseInt(textFieldID.getText());
        boolean check = true;

        for (int i = 0; i<FarmApp.employees.size();i++) {


            if (FarmApp.employees.get(i).getEmpID() == id) {
                JOptionPane.showMessageDialog(panel1,"There is a employee with this ID");
                check = false;


            }
        }

      if(check)
      {

          String gender =textFieldGender.getText();


          String birth = textFieldBirthday.getText();
          Date date = dateFormatter.parse(birth);

           int bScDegreeInt =comboBox1.getSelectedIndex();
           boolean bscDegree ;
           if(bScDegreeInt == 0 )  bscDegree = true;
           else  bscDegree = false;
          String graduation = textFieldGraduateDate.getText();
          Date dateOfGraduation = dateFormatter.parse(graduation);
          int explevel = Integer.parseInt(textFieldExpertiseLevel.getText());
          Veterinary vetobject = new Veterinary();
          vetobject.setEmpID(id);
          vetobject.setGender(gender);
          vetobject.setDateOfBirth(date);
          vetobject.setBScDegree(bscDegree);
          vetobject.setDateOfGraduation(dateOfGraduation);
          vetobject.setExpertiseLevel(explevel);

          FarmApp.employees.add(vetobject);
          JOptionPane.showMessageDialog(panel1,"Vet is Added :) ");
          DataStorage.addEmployee(vetobject);

      }



    }
}
