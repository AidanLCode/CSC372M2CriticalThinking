import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class Main extends JFrame  {
    public static void main(String[] args) {
        //Add a JFrame to create the window and configure it.
        JFrame myFrame = new JFrame("Age Calculator");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500,500);


        //Add JPanel and set up the layout manager
        JPanel myPanel = new JPanel(new GridBagLayout());
        GridBagConstraints myConstraints = new GridBagConstraints();
        myConstraints.insets = new Insets(10,10,10,10);

        //Add components to the JPanel
        //JLabel
        myConstraints.gridx = 0;
        myConstraints.gridy = 0;
        myPanel.add(new JLabel("Enter your birthday (yyyy-mm-dd): "), myConstraints);

        //Add text field
        myConstraints.gridx = 1;
        myConstraints.gridy = 0;
        JTextField birthDateField = new JTextField(10);
        myPanel.add(birthDateField, myConstraints);

        //Add button
        myConstraints.gridx = 0;
        myConstraints.gridy = 1;
        JButton calculateButton = new JButton("Calculate Age");
        myPanel.add(calculateButton, myConstraints);

        //Add label
        JLabel ageLabel = new JLabel("Your age is: ");
        myConstraints.gridx = 1;
        myConstraints.gridy = 1;
        myPanel.add(ageLabel, myConstraints);

        //Add the panel to the frame and set it to visible
        myFrame.add(myPanel);
        myFrame.setVisible(true);

        //Adding an action listener and how to handle the event.
        calculateButton.addActionListener(e -> {
            String birthDateStr = birthDateField.getText();

            //Catches any errors due to invalid format.
            try {
                LocalDate birthDate = LocalDate.parse(birthDateStr);
                LocalDate currentDate = LocalDate.now();
                int age = Period.between(birthDate, currentDate).getYears();
                ageLabel.setText("Your age is: " + age);
            } catch (DateTimeParseException ex) {
                ageLabel.setText("Invalid format. Be sure to add the \"-\"");
            }

        });




    }

}
