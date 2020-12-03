package com.group4.cs321g4;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame implements ActionListener {
	
	int count = 0;
	// Frames
	private final JFrame menuFrame;
        
	// Panels
	private final JPanel mainPanel;
	private JPanel progressLogPanel;
	private JPanel calendarPanel;
	private JPanel exerciseEntryPanel;
	private JPanel calorieCalcPanel;
        
	// Label
	private final JLabel mainLabel;
        
	// Buttons
	private final JButton calendarButton;
	private final JButton calorieCalcButton;
	private final JButton progressLogButton;
	private final JButton exerciseEntryButton;
	
	
	
	

	public MainMenu()
	{
		// Frames----------------------------------------------------------
		menuFrame = new JFrame(); 											// Frame for the main menu
                removeAll();
		// Panels----------------------------------------------------------	
		progressLogPanel = new JPanel();									// Panel for progress log frame
		mainPanel = new JPanel();											// Panel for main menu frame
		calendarPanel = new JPanel();										// Panel for calendar frame
		exerciseEntryPanel = new JPanel();
		calorieCalcPanel = new JPanel();
		
		// Labels----------------------------------------------------------
		mainLabel = new JLabel("Please select an option.");	
		
		// Buttons---------------------------------------------------------
		progressLogButton = new JButton("Progress Log");					// Button that takes user to progress log frame
		calendarButton = new JButton("Calendar");							// Button that takes user to calendar frame
		calorieCalcButton = new JButton("Calorie Calculator");				// Button that takes user to calorie calculator
		exerciseEntryButton = new JButton("Exercise Log");					// Button that takes user to exercise log
		
		//-----------------------------------------------------------------
		
		
		
		
		// This section controls the main menu
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.setPreferredSize(new Dimension(1000, 500));
	
		mainPanel.add(progressLogButton);
		mainPanel.add(calendarButton);
		mainPanel.add(exerciseEntryButton);
		mainPanel.add(calorieCalcButton);
		mainPanel.add(mainLabel);
		
		menuFrame.add(mainPanel, BorderLayout.CENTER);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setTitle("Exercise Tracking System");
		menuFrame.pack();
		menuFrame.setSize(800, 300);
		menuFrame.setVisible(true);

		progressLogButton.addActionListener(this);
		calendarButton.addActionListener(this);
		exerciseEntryButton.addActionListener(this);
		calorieCalcButton.addActionListener(this);
		
		
		
	}
	
	public static void main(String[] args) {
		
		new MainMenu();

	}

	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == progressLogButton)
		{
			menuFrame.remove(mainPanel);
                        progressLogPanel = new JPanel();
                        menuFrame.add(progressLogPanel, BorderLayout.CENTER);
                        JButton mainMenuBtn = new JButton("Back");
                        menuFrame.add(mainMenuBtn, BorderLayout.SOUTH);
                        mainMenuBtn.addActionListener(e -> {
                            menuFrame.remove(progressLogPanel);
                            menuFrame.add(mainPanel);
                            menuFrame.remove(mainMenuBtn);
                            menuFrame.pack();
                            menuFrame.setSize(800, 300);
                        });

                        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menuFrame.setTitle("Exercise Tracking System");
                        menuFrame.pack();    
                        menuFrame.setSize(800, 300);
		}
		else if(event.getSource() == calendarButton)
		{
			menuFrame.remove(mainPanel);
                        calendarPanel = new CalendarPanel(menuFrame);
                        menuFrame.add(calendarPanel, BorderLayout.CENTER);
                        JButton mainMenuBtn = new JButton("Back");
                        menuFrame.add(mainMenuBtn, BorderLayout.SOUTH);
                        mainMenuBtn.addActionListener(e -> {
                            menuFrame.remove(calendarPanel);
                            menuFrame.add(mainPanel);
                            menuFrame.remove(mainMenuBtn);
                            menuFrame.pack();
                            menuFrame.setSize(800, 300);
                        });

                        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menuFrame.setTitle("Exercise Tracking System");
                        menuFrame.pack();    
                        menuFrame.setSize(800, 300);
		}
		else if(event.getSource() == exerciseEntryButton)
		{
                        menuFrame.remove(mainPanel);
                        exerciseEntryPanel = new ExerciseForm();
                        menuFrame.add(exerciseEntryPanel, BorderLayout.CENTER);
                        JButton mainMenuBtn = new JButton("Back");
                        menuFrame.add(mainMenuBtn, BorderLayout.SOUTH);
                        mainMenuBtn.addActionListener(e -> {
                            menuFrame.remove(exerciseEntryPanel);
                            menuFrame.add(mainPanel);
                            menuFrame.remove(mainMenuBtn);
                            menuFrame.pack();
                            menuFrame.setSize(800, 300);
                        });

                        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menuFrame.setTitle("Exercise Tracking System");
                        menuFrame.pack();    
                        menuFrame.setSize(800, 300);
		}
		else if(event.getSource() == calorieCalcButton)
		{
			menuFrame.remove(mainPanel);
                        calorieCalcPanel = new Calculator();
                        menuFrame.add(calorieCalcPanel, BorderLayout.CENTER);
                        JButton mainMenuBtn = new JButton("Back");
                        menuFrame.add(mainMenuBtn, BorderLayout.SOUTH);
                        mainMenuBtn.addActionListener(e -> {
                            menuFrame.remove(calorieCalcPanel);
                            menuFrame.add(mainPanel);
                            menuFrame.remove(mainMenuBtn);
                            menuFrame.pack();
                            menuFrame.setSize(800, 300);
                        });

                        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menuFrame.setTitle("Exercise Tracking System");
                        menuFrame.pack();    
                        menuFrame.setSize(800, 300);                 
		}
		
		
	}
}

