package FarmApp;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class ListCow extends JFrame
{
    private JPanel ListCowPanel;
    private JTextArea textArea1;
    private JScrollPane scrollpane;

    private SimpleDateFormat dateFormatter;
    public ListCow()
    {

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        //setContentPane(ListCowPanel);
       // super("ListCow Panel"); //setContentPane(ListCowPanel);
        add(ListCowPanel);
        setSize(700,700);
        setTitle("ListCow");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);




          boolean check = true;
        for(int i= 0; i<FarmApp.animals.size();i++)
        {
           if(FarmApp.animals.get(i) instanceof  Cow)
           {
               textArea1.append("**************************************************************************\n");
               textArea1.append("\n ID: "+ FarmApp.animals.get(i).getTagNo());
               textArea1.append("\n Gender: "+ FarmApp.animals.get(i).getGender());
               textArea1.append("\n Weight: "+ ((Cow) FarmApp.animals.get(i)).getWeight());
               textArea1.append("\n Milking Values: "+ ((Cow) FarmApp.animals.get(i)).getMilking());
               textArea1.append("\n Date Of Birth : "+ dateFormatter.format(((Cow) FarmApp.animals.get(i)).getDateOfBirth()));
               textArea1.append("\n**************************************************************************");
               check = false;
           }






        }
        if(check)
        {
            JOptionPane.showMessageDialog(ListCowPanel,"THERE IS NO COW ");

        }
    }

}
