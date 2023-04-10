package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCowGUI extends  JFrame {
    private JTextField textFieldID;
    private JTextField textFieldGender;
    private JTextField textFieldBirthday;
    private JTextField textFieldWeight;
    private JButton ADDButton;
    private JComboBox comboBox1;
    private JPanel panel1;
    private SimpleDateFormat dateFormatter;

    public  AddCowGUI()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(800,800);
        setTitle("Add Cow");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

         setVisible(true);

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    addCow();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void addCow() throws ParseException {

        boolean id_check = true;

        int id = Integer.parseInt(textFieldID.getText());

        for (Animal theCow : FarmApp.animals) {



            if (theCow.getTagNo() == id)
            {

                JOptionPane.showMessageDialog(panel1,"There is a Animal With this ID");
                id_check = false;

            }




        }


        if (id_check){
            String gender = textFieldGender.getText();


            String birth = textFieldBirthday.getText();
            Date date = dateFormatter.parse(birth);



            int purchase = comboBox1.getSelectedIndex();
            boolean banswer;
          if (purchase == 0)
              banswer = true;
          else
              banswer = false;




            double weight = Double.parseDouble(textFieldWeight.getText());


            Cow ocow = new Cow();
            ocow.setTagNo(id);
            ocow.setGender(gender);
            ocow.setDateOfBirth(date);
            ocow.setPurchased(banswer);
            ocow.setWeight(weight);


            FarmApp.animals.add(ocow);


            JOptionPane.showMessageDialog(panel1,"Cow is Added :) ");

            DataStorage.addAnimal(ocow);


        }








    }

}
