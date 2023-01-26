package com.test.arrays;

import java.util.Arrays;

public class TwoSumArray {

	/*
	 Given an array of integers nums and an integer target,
	 return indices of the two numbers such that they add up to target. 
	*/
	
	public static void main(String[] args) {
		int target; 
		
		int[] intArray1 = {2,7,11,15};
		target = 9;
		System.out.println("Indices returned "+  Arrays.toString(twoSum(intArray1, target)) + "for target "+ target);
		
		int[] intArray2 = {3,2,4};
		target = 6;
		System.out.println("Indices returned "+  Arrays.toString(twoSum(intArray2, target)) + "for target "+ target);
		
		int[] intArray3 = {3,3};
		target = 6;
		System.out.println("Indices returned "+  Arrays.toString(twoSum(intArray3, target)) + "for target "+ target);
	}
	
	private static int[] twoSum(int[] nums, int target) {
        int[] positionMatchArry = new int[1];
        boolean foundTarget;
        for(int i=0;i<nums.length;i++){
            foundTarget = false;
            if(nums[i] == target){
                //positionMatchArry = new int[1];
                positionMatchArry[0] = i;
                foundTarget = true;
            }
            for(int j=i+1;j<nums.length;j++){
                if((nums[i] + nums[j]) == target){
                    positionMatchArry = new int[2];
                    positionMatchArry[0] = i;
                    positionMatchArry[1] = j;
                    foundTarget = true;
                    break;
                }
            }

            if(foundTarget){
                break;
            }
        }

        return positionMatchArry;
    }

}
