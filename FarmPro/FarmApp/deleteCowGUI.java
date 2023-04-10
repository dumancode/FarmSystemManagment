package FarmApp;

import javax.swing.*;
import java.awt.event.*;

public class deleteCowGUI extends  JFrame{
    private JTextField textField1;
    private JButton button1;
    private JPanel panel1;

    public deleteCowGUI()
    {
        setContentPane(panel1);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setTitle("DELETE COW");




        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                deleteCow(Integer.parseInt(textField1.getText()));


            }
        });
    }


    public void deleteCow(int tagNo) {
          boolean check = false;

        for (int i = 0; i< FarmApp.animals.size();i++)
        {
            if (FarmApp.animals.get(i) instanceof Cow && FarmApp.animals.get(i).getTagNo() == tagNo)
            {



                JOptionPane.showMessageDialog(panel1,"Cow  is deleted.");
                DataStorage.deleteAnimal(FarmApp.animals.get(i).getTagNo());
               FarmApp.animals.remove(i);
                check = true;
            }
        }
        if(!check)
        JOptionPane.showMessageDialog(panel1,"There is no cow with this ID.");




    }


}
