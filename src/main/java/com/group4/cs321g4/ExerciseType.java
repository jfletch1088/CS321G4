package com.group4.cs321g4;

public enum ExerciseType {
	//More Exercises can be added. The int variable is the calories per minute burned.
	//TODO: Actually research what these values are. These are the METS.
	High_Intensity_Cardio(6), Low_Intensity_Cardio(6), Weight_Training(16);

	private final int perMinValue;

	ExerciseType(int perMinValue) {
		this.perMinValue = perMinValue;
	}

	public int getPerMinValue() {
		return this.perMinValue;
	}
}
