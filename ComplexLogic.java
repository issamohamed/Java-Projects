import java.util.Scanner;
public class ComplexLogic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // writing variables for each condition
        while (sc.hasNext()){
            int n = sc.nextInt();
            boolean IsOdd = n % 2 != 0 ;
            boolean IsBetweenZeroToHundred = n > 0 && n < 100; 
            boolean IsDivisbleby3 = n % 3 == 0 ;
            // solving for the "yes" condition
            if (IsOdd == true && IsBetweenZeroToHundred == false) { 
                System.out.println("yes");
            } 
            // Solving For "maybe" condition
            else if(IsDivisbleby3 == true || IsBetweenZeroToHundred == true) {
                System.out.println("maybe") ;
            }
            // solving for the "no" condition 
            else
            {
                System.out.println("no");
            }   
        }
        sc.close();
    }

}
