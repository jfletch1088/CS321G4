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

public class ProgressLog extends JPanel {
    static int entries = 0;
    ExerciseEntry exEntry, curEntry; 
    public ProgressLog()    {
        File logFile = new File("..\\logFileName.txt");
        try {
            Scanner readFile = new Scanner(logFile);
            curEntry = readExercise(readFile);
            //createPanel(exerEntry);
            
        } catch (FileNotFoundException error) {
            System.out.println("Cannot open log file for reading");
        }
        JPanel logPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < entries; i++)
        {
            JLabel entry = new JLabel("Exercise #" + entries + " date: " + curEntry.getMonth() + "/" + curEntry.getDay() + "/" + curEntry.getYear() + " Type: " + curEntry.getExerciseType() +
                    " Duration: " + curEntry.getDurationHrs() + " hours and " + curEntry.getDurationMins());
            logPanel.add(entry);
        }
        add(logPanel, c);
        
    }
    
    public ExerciseEntry readExercise(Scanner logFile) 
    {
        logFile.useDelimiter(",");
        int month = 0, day = 0, year = 0, hrs = 0, mins = 0;
        String exerType = "";
        //ArrayList<ExerciseEntry> progressEntries = new ArrayList<ExerciseEntry>();
        while (logFile.hasNext())
        {
            month = Integer.parseInt(logFile.next());
            day = Integer.parseInt(logFile.next());
            year = Integer.parseInt(logFile.next());
            exerType = logFile.next();
            hrs = Integer.parseInt(logFile.next());
            mins = Integer.parseInt(logFile.next());
            
            System.out.println(month + "," + day + "," + year + "," + exerType + "," + hrs + "," +mins);
            
            exEntry = new ExerciseEntry(month, day, year, exerType, hrs, mins);
            entries++;
        }
        logFile.close();
        
        return exEntry;
    }
    
    /*public void createPanel(ArrayList<ExerciseEntry> exEntry)
    {
        
    }*/
}
