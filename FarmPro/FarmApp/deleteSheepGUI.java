package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteSheepGUI extends  JFrame {
    private JTextField textField1;
    private JButton button1;
    private JPanel panel1;

 public deleteSheepGUI()
 {
     setContentPane(panel1);
     setSize(500,500);
     setVisible(true);


     button1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             deleteSheep(Integer.parseInt(textField1.getText()));
         }
     });
 }


    public void deleteSheep(int tagNo)
    {
     boolean check = false;
        for (int i = 0; i< FarmApp.animals.size();i++) {
            if (FarmApp.animals.get(i) instanceof Sheep && FarmApp.animals.get(i).getTagNo() == tagNo) {
                DataStorage.deleteAnimal(FarmApp.animals.get(i).getTagNo());
                FarmApp.animals.remove(i);
               JOptionPane.showMessageDialog(panel1," with the " + tagNo + " number is deleted.");
                check = true;

            }
        }

       if(!check) JOptionPane.showMessageDialog(panel1,("There is no sheep for " + tagNo + " number."));

    }

}
