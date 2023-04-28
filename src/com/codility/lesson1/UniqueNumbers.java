package com.codility.lesson1;

import java.util.Arrays;

public class UniqueNumbers {
	
	public static void main(String[] args) {
		
	}

	
	  public int solution(int[] A) {
		     int N =A.length;
		     if (N==1) {
		    	 return 1;
		     }
	         int unique=N;
	         
	         Arrays.parallelSort( A);
	         
	         for (int i = 1; i < N; i++) {
				if (A[i]==A[i-1]) {
					unique--;
				}
			}
	         
	         return unique;
	    }
	  
}
