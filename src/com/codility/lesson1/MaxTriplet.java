package com.codility.lesson1;

import java.util.Arrays;

public class MaxTriplet {

	public static void main(String[] args) {
		int [] A = { -5, 1, 2, -3, 0, 2 ,4};
		int [] A1 = { -5, -1, 2, -3, 0, 6 ,4, 8};
		int [] A3 = {   2, 5, 0, 2 ,4};

		System.out.println(solution (A));
		System.out.println(solution (A1));
		System.out.println(solution (A3));
	}

	public static int solution(int[] A) {

		Arrays.parallelSort(A);

		int product1 =0;
		int N=A.length;
		int product2 =A[N-3]*A[N-2]*A[N-1];

		if (A[1] <0) {
			if (A[N-1] >=0) {
				product1 = A[0]*A[1]*A[N-1];
			}
			else {
				product1 = A[N-3]*A[N-2]*A[N-1];
			}		 
		}



		if (product1>product2) {
			return product1;
		}
		else return product2;
	}
}
