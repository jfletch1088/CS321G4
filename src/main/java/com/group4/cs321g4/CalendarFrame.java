/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.cs321g4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author John
 */
public class CalendarFrame extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalendarFrame frame = new CalendarFrame();
            frame.setSize(350, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
            // Create a panel for the days of the week column headers (Sun thru Sat)
            JPanel calDayHeaderPanel = new JPanel();
            calDayHeaderPanel.setLayout(new GridLayout(1, 7));
            
            // For-loop to create a panel for each day of the week header
            String[]daysOfWeek = {"Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat"};
            for (int i = 0; i<7;i++)
            {
                String header = daysOfWeek[i];
                calDayHeaderPanel.add(new JLabel(header));
            }
            frame.add(calDayHeaderPanel, BorderLayout.NORTH);
            frame.getContentPane().add(new CalendarPanel(frame), BorderLayout.CENTER);
        });
    }
}
