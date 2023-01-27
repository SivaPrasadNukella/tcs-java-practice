package com.test.arrays;

import com.test.common.QuickSort;

public class MergeSortTwoArrays {

	// Merge, Remove Duplicates & Sort Two Integer Arrays
	// https://codebunk.com/b/4971100563795/
	
	public static void main(String[] args) {
		
		int[] numArray1 = {5,7,3,1,7,4};
        int[] numArray2 = {4,2,1,6,8,2};
        
        /* Shortest Way
        SortedSet<Integer> numberSet = new TreeSet<Integer>();
        for(int number:numArray1){numberSet.add(number);}
        for(int number:numArray2){numberSet.add(number);}
        numberSet.forEach(System.out::println);
        */
        
        int resultArraySize = numArray1.length + numArray2.length;
        int[] resultArray = new int[resultArraySize];
        
        int resultArrayIndex = -1;
        for(int i=0; i<numArray1.length; i++) {
            if(i == 0 || 
               !isDuplicate(resultArray, numArray1[i], resultArrayIndex)){
                resultArrayIndex++;
                resultArray[resultArrayIndex] = numArray1[i];
            }
        }
  
        for(int k=0; k<numArray2.length; k++){
            if(!isDuplicate(resultArray, numArray2[k], resultArrayIndex)){
                resultArrayIndex++;
                resultArray[resultArrayIndex] = numArray2[k];
            }
        }
        
        resultArray = getClonedSortedArray(resultArray, resultArrayIndex);
        for(int num : resultArray){
            System.out.println(num);
        }
        
    }
    
    private static boolean isDuplicate(int[] resultArray, int insertNumber, int lastInsertIndex) {
        int[] sortedResultArray = getClonedSortedArray(resultArray, lastInsertIndex);
        
        boolean foundDuplicate = false;
        for(int i=0; i<sortedResultArray.length; i++){
            if(sortedResultArray[i] == insertNumber){
                foundDuplicate = true;
                break;
            } else if(sortedResultArray[i] > insertNumber){
                // To reduce no of loops
                break;
            }
        }
        
        return foundDuplicate;
    }
    
    private static int[] getClonedSortedArray(int[] resultArray, int lastInsertIndex) {
        int[] clonedSortedArray = new int[lastInsertIndex + 1];
        // Deep Copy
        for(int i=0; i<clonedSortedArray.length; i++) {
            clonedSortedArray[i] = resultArray[i];
        }
        //Arrays.sort(clonedSortedArray); //Default Arrays Sorting
        QuickSort.sortArray(clonedSortedArray, 0, clonedSortedArray.length - 1);
        
        return clonedSortedArray;
    }
    
}
