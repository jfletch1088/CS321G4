/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.cs321g4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.time.Month;
import java.time.YearMonth;
import javax.swing.JButton;
import javax.swing.JFrame;
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
            calDaysPanel.setLayout(new GridLayout(0, 7));
            // Use built in Calendar class to get
            YearMonth date = YearMonth.now();
            date = date.plusMonths(adjustMonth);
            int daysInMonth = date.lengthOfMonth();
            for (int i = 1; i <= daysInMonth; i++)
            {
                JButton calButton = new JButton(Integer.toString(i));
                calDaysPanel.add(calButton);
            }
            Month month = date.getMonth();
            JButton curMonth = new JButton(month.toString());
            calDaysPanel.add(curMonth);
            JPanel calPrevNext = new JPanel();
            calPrevNext.setLayout(new GridLayout(1, 2));
            JButton calPrev = new JButton("<<<< Previous");
            JButton calNext = new JButton("Next >>>>");
            calPrevNext.add(calPrev);
            calPrevNext.add(calNext);
            add(calDaysPanel, BorderLayout.CENTER);
            add(calPrevNext, BorderLayout.SOUTH);
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
