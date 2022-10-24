import java.util.Scanner;
// import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
// 		Making varriables for Size of integer, Array, and Target
		int N = scnr.nextInt() ;
// 		System.out.println(N);
		int intArray[];
		intArray = new int[N];
		for(int i = 0; i < N; i++) {
		   intArray[i] = scnr.nextInt() ;
		} 
// 		System.out.println(Arrays.toString(intArray));
      int target = scnr.nextInt() ; 
      // System.out.println(target) ; 
		scnr.close();
// 		storing the pair count 
		int PairsFound = 0 ;
		for(int outerIndex = 0; outerIndex < N; outerIndex++) {
		   for(int innerIndex = outerIndex; innerIndex < N; innerIndex++) {
		    //  case where the inner index is not equal to the outer index
		    if( innerIndex != outerIndex) {
		       // check if these two spots add up to the target
		       if( intArray[outerIndex] + intArray[innerIndex] == target) {
		        PairsFound++ ; 

		       }
		    }
		    
	      }
		   
		} 
		System.out.println(PairsFound) ; 
	}
}
