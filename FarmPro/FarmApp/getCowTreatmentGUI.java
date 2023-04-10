package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class getCowTreatmentGUI extends  JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton listTreatmentsButton;
    private SimpleDateFormat dateFormatter;

    public  getCowTreatmentGUI()
    {
        dateFormatter = new SimpleDateFormat();
        setContentPane(panel1);
        setSize(800,800);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        listTreatmentsButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                int whereAnimal = checkAnimal();
               if(whereAnimal != -1) new getCowTreatmentHELPERGUI(whereAnimal);

                /*JFrame internalFrame = new JFrame();
                internalFrame.setSize(1000,1000);

                internalFrame.setLayout(new FlowLayout());
                JTextArea t1 = new JTextArea(400,400);
                JScrollPane sp1 = new JScrollPane(t1);
                internalFrame.add(t1);
                internalFrame.add(sp1);
                 String den = getCowTreatment(whereAnimal);
                t1.append(den);

                internalFrame.setVisible(true);*/

            }
        });
    }

      public int checkAnimal()
      {
          int whereIs_Animal = -1;

          boolean flag = false;

          for (int i = 0; i < FarmApp.animals.size(); i++)
          {
              if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(textField1.getText())) {
                  flag = true;
                  whereIs_Animal = i;

              }
          }

          if(!flag) JOptionPane.showMessageDialog(panel1,"There is no animal with this ID.");
          return whereIs_Animal;

      }


}
