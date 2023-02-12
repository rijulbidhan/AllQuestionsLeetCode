
import java.util.Scanner;

public class Q1137_nth_Tribonacci_Number {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the position ");
        int pos = in.nextInt();
        System.out.println("The element at position " + pos + " is " + tribonacci(pos));
    }

    static int tribonacci(int n) {
        if(n < 2) {
            return n;
        }
        if(n == 2) {
            return 1;
        }
        int t0=0, t1=1, t2=1, t3=0;
        for(int i=3; i<=n; i++) {
            t3 = t0 + t1 + t2;
            t0=t1;
            t1=t2;
            t2=t3;
        }
        return t3;
    }
}
