package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class getSalaryForEmployee extends  JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton SEARCHButton;



    public getSalaryForEmployee()  {

        setContentPane(panel1);
        setSize(700,700);
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flagID = true;
                for(int i = 0; i<FarmApp.employees.size();i++)
                {
                    if(FarmApp.employees.get(i).getEmpID() == Integer.parseInt(textField1.getText()))
                    {

                        JOptionPane.showMessageDialog(panel1,"SALARY IS: "+FarmApp.employees.get(i).getSalary());
                        flagID = false;
                    }
                }

                if(flagID) JOptionPane.showMessageDialog(panel1,"There is no Employee with this ID");
            }
        });
    }
}
