package com.group4.cs321g4;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * CS 321-02 Group 4
 * Implementation
 * 3 December 2020
 * This is the ExerciseForm class
 * This class is intended to create a form to be filled out with exercise data
 * This creates an exercise form and displays it
 * @author John Fletcher, Kyle Nelson, Justin McBride, Dylan Wright
 *
 */

public class ExerciseForm extends JPanel implements ActionListener {
    protected JTextField exDateField;
    protected JTextField exTypeField;
    protected JTextField exLengthHrsField;
    protected JTextField exLengthMinsField;
    public ExerciseForm()
    {
        super(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel exDateLabel = new JLabel("Enter the date of workout (mm/dd/yyyy): ");
        exDateField = new JTextField(20);
        add(exDateLabel, c);
        add(exDateField, c);
        
        JLabel exTypeLabel = new JLabel("Enter your exercise type: ");
        exTypeField = new JTextField(20);
        add(exTypeLabel, c);
        add(exTypeField, c);
        
        JLabel exLengthLabel = new JLabel("Enter your exercise length: ");
        exLengthHrsField = new JTextField(5);
        exLengthMinsField = new JTextField(5);
        JLabel exLengthHrsLabel = new JLabel("Hours: ");
        JLabel exLengthMinsLabel = new JLabel("Minutes: ");
        add(exLengthLabel, c);
        add(exLengthHrsLabel, c);
        add(exLengthHrsField, c);
        add(exLengthMinsLabel, c);
        add(exLengthMinsField, c);
        
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton,c);
    }
   
    /**
     * This is the actionPerformed function
     * This is intended to listen for the form being submitted and store the exercise data
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String date = exDateField.getText();
        String[] formatDate = date.split("/");
        int exerMonth = Integer.parseInt(formatDate[0]);
        int exerDay = Integer.parseInt(formatDate[1]);
        int exerYear = Integer.parseInt(formatDate[2]);
        
        String exerType = exTypeField.getText();
        int exerLengthHrs = Integer.parseInt(exLengthHrsField.getText());
        int exerLengthMins = Integer.parseInt(exLengthMinsField.getText());
        
        
        ExerciseEntry exEntry = new ExerciseEntry(exerMonth, exerDay, exerYear, exerType, exerLengthHrs, exerLengthMins);
       
        try 
        {
            File logFile = new File("..\\logFileName.txt");
            FileWriter writeFile = new FileWriter(logFile);
            writeFile.write(exerMonth + "," + exerDay + "," + exerYear + "," + exerType + "," + exerLengthHrs + "," +exerLengthMins);
            writeFile.close();
            System.out.println("Exercise written to file");
        } catch (IOException error) {
            System.out.println("An error occurred writing to file.");
            error.printStackTrace();
        }
    }
}
