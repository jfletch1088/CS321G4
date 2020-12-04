package com.group4.cs321g4;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * CS 321-02 Group 4
 * Implementation
 * 3 December 2020
 * This is the Calculator class
 * This class is intended to calculate total calories burned from the different kinds of exercises
 * This creates a calorie calculator 
 * @author John Fletcher, Kyle Nelson, Justin McBride, Dylan Wright
 *
 */
public class Calculator extends JPanel {
	private static JTextField inputLengthBox;
	private static JTextField inputWeightBox;
	private static JTextField outputBox;
	private static String selectedExercise;

	Calculator() {
		inputLengthBox = new JTextField(5);
		inputLengthBox.setEditable(true);
		outputBox = new JTextField(10);
		outputBox.setEditable(false);
		inputWeightBox = new JTextField(10);
		inputWeightBox.setEditable(true);

		add(new JLabel("Input minutes exercised:"));
		add(inputLengthBox);
		add(new JLabel("Input weight in kg used:"));
		add(inputWeightBox);

		// Used to select exercise type for calculations.
		JRadioButton t1 = new JRadioButton(ExerciseType.High_Intensity_Cardio.toString());
		t1.setActionCommand(ExerciseType.High_Intensity_Cardio.toString());
		t1.setSelected(true);
		selectedExercise = (ExerciseType.High_Intensity_Cardio.toString());
		JRadioButton t2 = new JRadioButton(ExerciseType.Low_Intensity_Cardio.toString());
		t2.setActionCommand(ExerciseType.Low_Intensity_Cardio.toString());
		JRadioButton t3 = new JRadioButton(ExerciseType.Weight_Training.toString());
		t3.setActionCommand(ExerciseType.Weight_Training.toString());

		// Used to group the radio buttons so as only one is active.
		ButtonGroup ExerciseGroup = new ButtonGroup();
		ExerciseGroup.add(t1);
		ExerciseGroup.add(t2);
		ExerciseGroup.add(t3);

		// The event for the radio buttons.
		ActionListener k1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedExercise = e.getActionCommand();
			}
		};
		t1.addActionListener(k1);
		t2.addActionListener(k1);
		t3.addActionListener(k1);

		// The button that calls the calculate.
		JButton button1 = new JButton("Calculate Calories Burned.");
		ActionListener k = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double exerciseLength = Double.parseDouble(inputLengthBox.getText());
					double weightUsed = Double.parseDouble(inputWeightBox.getText());
					outputBox.setText(String.valueOf(computeCalories(exerciseLength, weightUsed)) + " calories");
					
				} catch (NumberFormatException e1) {
					outputBox.setText("Invalid Entry");
				}
			}
		};
		button1.addActionListener(k);

		// Used for testing.
//		JButton button0 = new JButton("1");
//		ActionListener k2 = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				inputLengthBox.setText("1");
//			}
//		};
//		button0.addActionListener(k2);
//		add(button0);

		// Adding components.
		// TODO: Make pretty.
		add(button1);
		add(outputBox);
		add(t1);
		add(t2);
		add(t3);
	}

	/**
	 * This is used to calculate calories burned based on which radio button is
	 * selected and length of exercise.
	 * 
	 * @param exerciseLength Length of the exercise in minutes
	 * @param weight the weight of the person
	 * @return Calories burned based on the function
	 */
	private static double computeCalories(double exerciseLength, double weightUsed) {
		// Energy expenditure (calories/minute) = .0175 x MET (from table) x weight (in
		// kilograms)
		double caloriesBurned = 0.0;
		caloriesBurned = .0175 * exerciseLength * ExerciseType.valueOf(selectedExercise).getPerMinValue() * weightUsed;

		return caloriesBurned;
	}
}