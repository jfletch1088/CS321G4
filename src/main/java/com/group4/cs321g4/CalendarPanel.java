package com.group4.cs321g4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarPanel extends JPanel {
    static int adjustMonth= 0;
    public CalendarPanel(){
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        // Create a panel for the individual days in each month
        JPanel calDaysPanel = new JPanel();
        // The # of rows in each month is variable based on the layout of the month, so rows = 0.
        calDaysPanel.setLayout(new GridBagLayout());
       
        // Use built in java.time to get current date
        LocalDate date = LocalDate.now();
        // Set day of the month to 1 so each month calendar begins on correct columm (Sun->Sat)
        date = date.withDayOfMonth(1);
        // Add the adjustMonth modifier (default = 0, ++ or -- depending on Previous or Next buttons
        date = date.plusMonths(adjustMonth);
        // store the length of the month, used for building the calendar correctly.
        int daysInMonth = date.lengthOfMonth();
        // store the day of the week, used to know which day (Monday = 1 -> Sunday = 7) the first day of the month falls on
        DayOfWeek dow = date.getDayOfWeek();
        // firstDOM = first day of month set, false if first day of month button has been added, true if it has. 
        boolean firstDOMSet = false;
        // iterator variable for firstDOMSet conditional loop
        int j = 1;
        int calendarRow = 2;
        int calendarCol = 0;
        int buttonsMade = 0;

        Month month = date.getMonth();
        JLabel curMonth = new JLabel(month.toString());
        calDaysPanel.add(curMonth, c);
        // For-loop to create a panel for each day of the week header
        String[]daysOfWeek = {"Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat"};
        for (int i = 0; i<7;i++)
        {
            c.gridy = 1;
            c.gridx = i;
            String header = daysOfWeek[i];
            calDaysPanel.add(new JLabel(header), c);
        }
        
        // For-loop to iterate from 2nd day of month until last day of month, used to populate the calendar. 
        for (int i = 1; i <= daysInMonth; i++)
        {
            // While loop for formatting the top row of the calendar.  
            while (!firstDOMSet)
            {
                // If first day of the month = Sunday, create the "1" button and break the while loop
                if (dow.getValue() == 7 && !firstDOMSet)
                {
                    JButton calButton = new JButton("1");
                    c.gridx = calendarCol;
                    c.gridy = 2;
                    calButton.setSize(30, 30);
                    calDaysPanel.add(calButton, c);
                    firstDOMSet = true;
                    buttonsMade++;
                    calendarCol++;
                    break;
                // If it isn't add a blank button and then add "1"
                } else if (dow.getValue() == j && !firstDOMSet)
                {
                    JButton calButton = new JButton("1");
                    c.gridx = j;
                    c.gridy = calendarRow;
                    calDaysPanel.add(calButton, c);
                    firstDOMSet = true;
                    if (j != 6)
                    {
                        calendarCol = j+1;
                    }
                    calendarCol = j;
                    break;
                } 
                j++;
            }
            buttonsMade = calendarCol;
            // Populate additional buttons on the calendar if the first day of the month has been set
            if (firstDOMSet) 
            {
                JButton calButton = new JButton(Integer.toString(i));
                c.gridx = calendarCol;
                c.gridy = calendarRow;
                calDaysPanel.add(calButton, c);
                buttonsMade++;
                calendarCol++;
            }
            if (buttonsMade % 7 == 0)
            {
                calendarRow++;
                calendarCol = 0;
            }
        }

        // Create the previous/next buttons and add them to the panel
        JButton calPrev = new JButton("<<<<");
        JButton calNext = new JButton(">>>>");
        c.gridy = calendarRow+3;
        c.gridx = 0;
        calDaysPanel.add(calPrev, c);
        c.gridx = 2;
        calDaysPanel.add(calNext, c);
        
        add(calDaysPanel);
        // Functionality for the Previous/Next buttons
        // If Previous is pressed, currentMonth gets decremented
        calPrev.addActionListener(event -> {
            adjustMonth--;
            remove(calDaysPanel);
            add(new CalendarPanel(), BorderLayout.NORTH);
            revalidate();
                });
        // If Next is pressed, currentMonth gets incremented
        calNext.addActionListener(event -> {
            adjustMonth++;
            remove(calDaysPanel);
            add(new CalendarPanel(), BorderLayout.NORTH);
            revalidate();
                });
    }
}