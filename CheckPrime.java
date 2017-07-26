import java.util.Scanner;

/**
 * Created by yizhiw on 7/26/2017.
 */
public class CheckPrime {
    public static boolean isPrime(int n) {
        if ((n == 0) || (n == 1)) {
            return false;
        }

        for (int i = 2; i <= (int)Math.sqrt(n);i++) {
            int tmp = n / i;

            if (i * tmp == n) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isPrime(n));
    }
}