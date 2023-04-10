package FarmApp;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class ListSheepGUI extends JFrame {
    private JTextArea textArea1;
    private JPanel panel1;
    private SimpleDateFormat dateFormatter;

    public ListSheepGUI()
    {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        setContentPane(panel1);
        setSize(500,500);
        setTitle("List Sheep");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        String deneme ="";
        boolean check = false;

        for(int i= 0; i<FarmApp.animals.size();i++)
        {
            if(FarmApp.animals.get(i) instanceof  Sheep)
            {


              deneme +=("**************************************************************************\n");
                deneme+=("\n ID: "+ FarmApp.animals.get(i).getTagNo());
                deneme+=("\n Gender: "+ FarmApp.animals.get(i).getGender());
                deneme+=("\n Milking Values: "+ ((Sheep) FarmApp.animals.get(i)).getMilking());
                deneme+=("\n Purchased ? : : "+ ((Sheep) FarmApp.animals.get(i)).isPurchased());
                deneme+=("\n Age : "+ ((Sheep) FarmApp.animals.get(i)).getAge());
                deneme+=("\n Date Of Birth : "+ dateFormatter.format(((Sheep) FarmApp.animals.get(i)).getDateOfBirth()));
                deneme+=("\n**************************************************************************");
                check = true;


            }

        }

        if(!check)    JOptionPane.showMessageDialog(panel1,"There is no Sheep");
        else  JOptionPane.showMessageDialog(panel1,deneme);

    }

}
