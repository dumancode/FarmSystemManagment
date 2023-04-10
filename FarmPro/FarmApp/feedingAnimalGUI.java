package FarmApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class feedingAnimalGUI extends  JFrame{
    private JTextField textField1;
    private JButton showButton;
    private JPanel p1;


    public feedingAnimalGUI() {
        setContentPane(p1);
        setSize(700,700);
        setVisible(true);



        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = true;

                for (int i = 0; i< FarmApp.animals.size(); i++)
                {
                    if(FarmApp.animals.get(i).getTagNo() == Integer.parseInt(textField1.getText()))
                    {
                        check = false;

                        if(FarmApp.animals.get(i) instanceof Cow)
                        {

                            int getAge = FarmApp.animals.get(i).getAge();
                            int getWeight = (int) ((Cow) FarmApp.animals.get(i)).getWeight();
                            if(getAge <3)
                            {
                                JOptionPane.showMessageDialog(p1,"They are only fed with grass");

                            }

                            else if(getAge < 5 && getWeight < 500)
                            {
                                JOptionPane.showMessageDialog(p1,"it needs Total mixed ration (TMR) is a diet that\n" +
                                    "includes hay, fermented grass (silage), maize silage and\n" +
                                    "high energy grains like brewers grains, soy bean, cotton\n" +
                                    "seed and citrus pulp.");

                            }
                            else if(getAge > 10 )
                            {
                                JOptionPane.showMessageDialog(p1,"They need grains and oilseed meals.");

                            }
                            else
                            {
                                JOptionPane.showMessageDialog(p1,"They are only fed with grass and grains.");

                            }
                        }

                        if(FarmApp.animals.get(i) instanceof Sheep)
                        {
                            int getAge = FarmApp.animals.get(i).getAge();
                            String getGender = FarmApp.animals.get(i).getGender();

                            if(getAge <5)
                            {
                                JOptionPane.showMessageDialog(p1,"They are only fed with grass");
                            }

                            else if(getAge < 8 && getGender.equalsIgnoreCase("Female"))
                            {JOptionPane.showMessageDialog(p1,"They only fed with grass.");

                            }
                            else if(getAge > 5 && getGender.equalsIgnoreCase("Male") )
                            {
                                JOptionPane.showMessageDialog(p1,"Total mixed ration (TMR) diet is needed.");

                            }

                            else if(getGender.equalsIgnoreCase("Female") && getAge>8)
                            {
                                JOptionPane.showMessageDialog(p1,"Total mixed ration (TMR) diet is needed.");


                            }
                        }


                    }



            }
                if(check) JOptionPane.showMessageDialog(p1,"There is no Animal with this ID");
            }

        });
    }
}
