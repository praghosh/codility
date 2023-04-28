package com.codility.lesson1;

public class DivisibleNumber {
	
	public static void main(String[] args) {
		
	}
	
	  public int solution(int A, int B, int K) {
	        
		  int steps =0;
		  int start = A;
		  
		  if (A%K!=0) {
			  
			  start = A + K -(A%K);
		  }
		  
		  int end =B;
		  
          if (B%K!=0) {
			  
			  end = B -(B%K);
		  }
		  
          if (end<start) {
        	  steps =0;
          }
          else {
        	  steps = (end-start)/K +1;
          }
			  
		  
		  
		  return steps;
		  
		  
	    }

}
