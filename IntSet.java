import java.util.Scanner;

public class IntSet {
   public static boolean contains(int[] set, int n, int value) {
      boolean IsContains = false ;
      for( int index = 0; index < n; index++) {
         if( set[index] == value) {
            IsContains = true ;
            return IsContains ;
         }    
      }
      return IsContains ; 
   } 
   
   public static int add(int[] set, int n, int value) {
       boolean ContainValue = contains( set, n, value) ;
       if( ContainValue == false) {
          set[n] = value ;
           return n + 1 ;

       }  
       return n ;
   }

    public static int countRange(int[] set, int n, int lo, int hi) {
       int count = 0 ;
       for( int index = 0; index < n; index++ ) {
           if( set[index] < hi && (set[index] > lo || set[index] == lo) ) {
               count++ ;
           }
       }
       return count ;

    }
}