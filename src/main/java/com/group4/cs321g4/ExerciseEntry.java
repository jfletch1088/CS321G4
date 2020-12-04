package com.group4.cs321g4;
/**
 * CS 321-02 Group 4
 * Implementation
 * 3 December 2020
 * This is the ExerciseEntry class
 * This class is intended to store data for exercise entries
 * @author John Fletcher, Kyle Nelson, Justin McBride, Dylan Wright
 *
 */
public class ExerciseEntry {
    
    private final int month;
    private final int year;
    private final int day;
    private final String exerciseType;
    private final int durationHrs;
    private final int durationMins;
    
    public ExerciseEntry(int month, int day, int year, String exerciseType, int durationHrs, int durationMins)
    {
        this.month = month;
        this.year = year;
        this.day = day;
        this.exerciseType = exerciseType;
        this.durationHrs = durationHrs;
        this.durationMins = durationMins;
    }
            
    public int getMonth()
    {
        return this.month;
    }
    public int getYear()
    {
        return this.year;
    }
    public int getDay()
    {
        return this.day;
    }
    public String getExerciseType()
    {
        return this.exerciseType;
    }
    public int getDurationHrs()
    {
        return this.durationHrs;
    }
    public int getDurationMins()
    {
        return this.durationMins;
    }
}
