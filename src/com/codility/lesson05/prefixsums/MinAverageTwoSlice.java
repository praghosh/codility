package com.codility.lesson05.prefixsums;

public class MinAverageTwoSlice {
	
	
	public static int solutionPrabir(int[] A) {
		// Minimum Average will be from two or three continuous number only
		// In case there is minimum average is among five  then that can be split in 
		// two and three
		
		int minIndex=0;
		double minAverage = Double.MAX_VALUE;
		int N=A.length;
		if (N==2) {
			return 0;
		}
		
		for (int i = 0; i < N-1; i++) {
			
			double firstNum = A[i];
			double secondNum  = A[i+1];
			double thirdNum = (i==N-2)?Integer.MAX_VALUE: A[i+2];		
			double averageOfTwo= (firstNum + secondNum  )/2.0;
			double averageOfThree= (firstNum + secondNum + thirdNum)/3.0;
			double minVal = Math.min( averageOfTwo, averageOfThree);
			if (minVal<minAverage) {
				minAverage=minVal;
				minIndex=i;
			}
			
		}
		
		return minIndex;
	}
	
  public static int solution(int[] A) {

    //main idea: will find min average by checking only 2 and 3 contiguous elements at a time
    int sum1, sum2 = 0;
    double minAverage = Double.MAX_VALUE;
    double currentAverage1 = Double.MAX_VALUE;
    double currentAverage2 = Double.MAX_VALUE;
    int minAverageSliceIndex = 0; //for size 2 arrays, this will always be true

    //if array is > 2 elements
    for(int i=0; i<A.length-2; i++) {
      sum1 = A[i] + A[i+1];
      currentAverage1 = sum1 / 2.0d;
      if(currentAverage1 < minAverage) {
        minAverage = currentAverage1;
        System.out.println("minAverage=" +minAverage);
        minAverageSliceIndex = i;
      }

      sum2 = sum1 + A[i+2];
      currentAverage2 = sum2 / 3.0d;
      if(currentAverage2 < minAverage) {
        minAverage = currentAverage2; 
        System.out.println("minAverage NOW=" +minAverage);
        minAverageSliceIndex = i;
      }
    }

    System.out.println("minAverageSliceIndex=" + minAverageSliceIndex);
    //check last 2 contiguous elements from the end - they won't otherwise be checked because
    //when checking 2 and 3 contiguous elements at a time, will stop checking 3 elements from the end
    currentAverage1 = (A[A.length-2] + A[A.length-1]) / 2.0d;
    if(currentAverage1 < minAverage) {
      minAverage = currentAverage1;
      minAverageSliceIndex = A.length-2;
    }
    System.out.println("minAverageSliceIndex Now=" + minAverageSliceIndex);
   
    return minAverageSliceIndex;
  }
  
  public static void main(String[] args) {
	int [] A= {1,2,3,-100,1,-200,1,-203,4,5,-10,1,1,-12};
	System.out.println(solution (A));
	System.out.println(solutionPrabir (A));
	
}
  
}