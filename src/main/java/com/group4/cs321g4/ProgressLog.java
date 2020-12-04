package com.group4.cs321g4;

import java.awt.GridBagConstraints;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CS 321-02 Group 4
 * Implementation
 * 3 December 2020
 * This is the ProgressLog class
 * This class is intended to read the exercise log file and display the data
 * This creates a display of logged exercises
 * @author John Fletcher, Kyle Nelson, Justin McBride, Dylan Wright
 *
 */

public class ProgressLog extends JPanel {
    static int entries;
    ExerciseEntry exEntry, curEntry; 
    public ProgressLog()    {
        entries = 0;
        File logFile = new File("..\\logFileName.txt");
        try {
            Scanner readFile = new Scanner(logFile);
            curEntry = readExercise(readFile);
            //createPanel(exerEntry);
            
        } catch (FileNotFoundException error) {
            System.out.println("Cannot open log file for reading");
        }
        /*JPanel logPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        for (int i = 0; i < entries; i++)
        {
            JLabel entry = new JLabel("Exercise #" + i + " date: " + curEntry.getMonth() + "/" + curEntry.getDay() + "/" + curEntry.getYear() + " Type: " + curEntry.getExerciseType() +
                    " Duration: " + curEntry.getDurationHrs() + " hours and " + curEntry.getDurationMins());
            c.gridy = i;
            logPanel.add(entry, c);
            add(logPanel, c);
        }*/
        //add(logPanel, c);
        
    }
    
    public ExerciseEntry readExercise(Scanner logFile) 
    {
        logFile.useDelimiter(",");
        int month = 0, day = 0, year = 0, hrs = 0, mins = 0;
        String exerType = "";
        //ArrayList<ExerciseEntry> progressEntries = new ArrayList<ExerciseEntry>();
        while (logFile.hasNext())
        {
            String[] temp = logFile.nextLine().split(",");
            month = Integer.parseInt(temp[0]);
            day = Integer.parseInt(temp[1]);
            year = Integer.parseInt(temp[2]);
            exerType = temp[3];
            hrs = Integer.parseInt(temp[4]);
            mins = Integer.parseInt(temp[5]);
            System.out.println(month + "," + day + "," + year + "," + exerType + "," + hrs + "," +mins);
            
            exEntry = new ExerciseEntry(month, day, year, exerType, hrs, mins);
            JPanel logPanel = new JPanel();
            GridBagConstraints c = new GridBagConstraints();
            c.gridwidth = GridBagConstraints.REMAINDER;
            c.fill = GridBagConstraints.HORIZONTAL;
            JLabel entry = new JLabel("Exercise #" + (entries+1) + " date: " + exEntry.getMonth() + "/" + exEntry.getDay() + "/" + exEntry.getYear() + " Type: " + exEntry.getExerciseType() +
                    " Duration: " + exEntry.getDurationHrs() + " hours and " + exEntry.getDurationMins());
            c.gridy = entries;
            logPanel.add(entry, c);
            add(logPanel, c);
            entries++;
        }
        logFile.close();
        
        return exEntry;
    }
    
    /*public void createPanel(ArrayList<ExerciseEntry> exEntry)
    {
        
    }*/
}
