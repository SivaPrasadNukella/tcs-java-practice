package com.test.designpatterns;

public class GradesSingletonCls {

	// Aggressive Initialization
	//private static GradesSingletonCls empObj = new GradesSingletonCls();
	
	// Lazy Initialization
	private static volatile GradesSingletonCls gradesObj;
	
	private GradesSingletonCls() {
		// private default constructor
	}
	
	public static GradesSingletonCls getInstance() {
		
		// Single Checked
		if(null == gradesObj) {
				
			synchronized(GradesSingletonCls.class) {
				// Double Checked
				if(null == gradesObj) {
					gradesObj = new GradesSingletonCls();
				}
			}
		}
		
		return gradesObj;
		
	}
	
	public void printGrade(int marksScored, int maximumMarks) {
		
		float scoredPercentage = (marksScored / (float) maximumMarks) * 100;
		String grade = null;
		
		if(scoredPercentage >= 35 && scoredPercentage <= 40) {
				grade = "D";
		} else if(scoredPercentage > 40 && scoredPercentage <= 50) {
			grade = "C";
		} else if(scoredPercentage > 50 && scoredPercentage < 60) {
			grade = "B";
		} else if(scoredPercentage == 60 || scoredPercentage > 60) {
			grade = "A";
		}
		
		System.out.println("Your Grade: "+ grade +", with Marks Scored Percentage: "+scoredPercentage);
	}
	
}
