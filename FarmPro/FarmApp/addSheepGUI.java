package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addSheepGUI extends  JFrame{
    private JPanel panel1;
    private JTextField textFieldID;
    private JTextField textFieldDateOfBirth;
    private JTextField textFieldGender;
    private JComboBox comboBox1;
    private JButton button1;
    private SimpleDateFormat dateFormatter;

    public  addSheepGUI()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(1000,1000);
        setTitle("Add Sheep");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);


        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addSheep();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void addSheep() throws ParseException {

        boolean id_check = true;

        int id = Integer.parseInt(textFieldID.getText());

        for (Animal theSheep : FarmApp.animals) {



            if (theSheep.getTagNo() == id) {
                 JOptionPane.showMessageDialog(panel1,"There is a animal with this ID.");
                id_check = false;

            }

        }

        if (id_check)
        {

            String gender = textFieldGender.getText();
            String birth = textFieldDateOfBirth.getText();
            Date date = dateFormatter.parse(birth);
            int answer = comboBox1.getSelectedIndex();
            boolean banswer;
            if(answer == 0) banswer = true;
            else banswer =false;

            Sheep oSheep = new Sheep();
            oSheep.setTagNo(id);
            oSheep.setGender(gender);
            oSheep.setDateOfBirth(date);
            oSheep.setPurchased(banswer);
            FarmApp.animals.add(oSheep);
            JOptionPane.showMessageDialog(panel1,"Sheep is added");
            DataStorage.addAnimal(oSheep);
        }


    }
}
