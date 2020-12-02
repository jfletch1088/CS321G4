package com.group4.cs321g4;

public enum ExerciseType {
	HighIntensityCardio(5), LowIntensityCardio(8), WeightTraining(10);

	private final int perMinValue;

	ExerciseType(int perMinValue) {
		this.perMinValue = perMinValue;
	}

	public int getPerMinValue() {
		return this.perMinValue;
	}
}
