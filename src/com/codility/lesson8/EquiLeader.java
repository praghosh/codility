package com.codility.lesson8;
import java.util.Stack;

/**
 * 
 * @author prabir
 * 
 * This class solves the codility problem in section Leader
 *
 */
public class EquiLeader {
	
	public static void main(String[] args) {
		int [] A = { 8, 8, 8, 9, 8, 8, 8, 9, 8 } ;
		System.out.println(solution (A));
	}

	public static int solution(int[] A) {
		int N= A.length;
		Stack <Integer> itemStack = new Stack <Integer> ();
		int leader =-1;
		for (int i =0; i<N; i++) {

			if (itemStack.empty()) {
				itemStack.push(A[i]);
				leader = A[i];
			}
			else {
				int item = itemStack.peek();
				if (item==A[i]) {
					itemStack.push(A[i]);
				}
				else {
					itemStack.pop();
				}
			}
		}
		// Just to check if any leader exists
		int count =0;
		for (int i =0; i<N; i++) {
			if (A[i] == leader) {
				count++; 
			}
		}
		int half = N/2;
		if(count <half) {
			return 0;  // If there is no leader then  no equi-leader
		}
        int leftCount=0;
        int equiLeaderCount=0;
		for (int i =0; i<N; i++) {
			if (A[i] == leader) {
				leftCount++; 
			}
			 // Left Side will be leader if leader element is more than half
			boolean isLeftLeader=(leftCount>((i+1)/2))?true:false;  
			boolean isRightLeader=(count-leftCount>((N-i-1)/2))?true:false; 
			if (isLeftLeader&isRightLeader) {
				equiLeaderCount++;
			}
		}
 		
		return equiLeaderCount;
	}

}
