import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int divided;
        if ((n - b) % (b - a) != 0) { 
            divided = (n-b)/(b-a) + 1;
        } else {
            divided = (n-b)/(b-a);
        }

        int ans = 2 * divided + 1;

        System.out.println(ans);
    }
}