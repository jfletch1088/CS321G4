/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.cs321g4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author John
 */
public class CalendarPanel extends JPanel {
    static int adjustMonth = 0;
    public CalendarPanel(final CalendarFrame frame){
        
        
        // Create a panel for the individual days in each month
            JPanel calDaysPanel = new JPanel();
            // The # of rows in each month is variable based on the layout of the month, so rows = 0.
            calDaysPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;
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
            int calendarRow = 0;
            int calendarCol = 0;
            int buttonsMade = 0;
           
            // For-loop to iterate from 2nd day of month until last day of month, used to populate the calendar. 
            for (int i = 2; i <= daysInMonth; i++)
            {
                // While loop for formatting the top row of the calendar.  
                while (!firstDOMSet)
                {
                    // If first day of the month = Sunday, create the "1" button and break the while loop
                    if (dow.getValue() == 7 && !firstDOMSet)
                    {
                        JButton calButton = new JButton("1");
                        c.gridx = calendarCol;
                        c.gridy = 0;
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
            
            // Create the Previous/Next panel
            JPanel calPrevNext = new JPanel();
            calPrevNext.setLayout(new GridLayout(1, 2));
            // Create the previous/next buttons and add them to the panel
            JButton calPrev = new JButton("<<<< Previous");
            JButton calNext = new JButton("Next >>>>");
            calPrevNext.add(calPrev);
            calPrevNext.add(calNext);
            
            Month month = date.getMonth();
            JLabel curMonth = new JLabel(month.toString());
            
            add(calDaysPanel, BorderLayout.CENTER);
            add(calPrevNext, BorderLayout.SOUTH);
            add(curMonth, BorderLayout.SOUTH);
            // Functionality for the Previous/Next buttons
            // If Previous is pressed, currentMonth gets decremented
            calPrev.addActionListener(event -> {
                Container pane = frame.getContentPane();
                pane.remove(CalendarPanel.this);
                adjustMonth--;
                CalendarPanel prevPanel = new CalendarPanel(frame);
                pane.add(prevPanel, BorderLayout.CENTER);
                pane.revalidate();
                    });
            // If Next is pressed, currentMonth gets incremented
            calNext.addActionListener(event -> {
                Container pane = frame.getContentPane();
                pane.remove(CalendarPanel.this);
                adjustMonth++;
                CalendarPanel prevPanel = new CalendarPanel(frame);
                pane.add(prevPanel, BorderLayout.CENTER);
                pane.revalidate();
                    });
    }
}
