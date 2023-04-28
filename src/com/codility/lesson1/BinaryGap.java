package com.codility.lesson1;

public class BinaryGap {
	
	public static void main(String[] args) {
		
		BinaryGap b = new BinaryGap ();
		
		System.out.println(b.solution(74901729));
	}
	
	 public int solution(int N) {
	        
		 int gap =0;
		 int MaxGap=0;
		 
		 String byteString = Integer.toBinaryString(N);
	//	 System.out.println(byteString);
		 boolean gapStarted=false;
		 
		 for (int i = 0; i < byteString.length(); i++) {
			 
			 char charAtThisIndex = byteString.charAt(i);
			 
			 if (charAtThisIndex =='1') {
				 // Binary gap of '0' occurs between two one.
				 // Whenever there is a one we know there can be zero or
				 // more gap after this 
				 if (gapStarted) {
					 if (gap>MaxGap) {
						 MaxGap=gap;
						 gap=0;
					 }
					 gap=0;
				 }
				 else {
					 gapStarted=true;
					 gap=0;
				 }
				 
			 }
			 else {
				 if (gapStarted) {
					 gap++;
				 }
			 }
			
		}
		 
		 return MaxGap;
		 
	    }

}
