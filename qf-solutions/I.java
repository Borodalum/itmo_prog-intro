import java.util.Scanner;
import java.lang.Math;
public class I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] min = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] max = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int h = sc.nextInt();
            
            // формулы по входным данным

            max[0] = Math.max(x + h, max[0]);
            max[1] = Math.max(y + h, max[1]);
            min[0] = Math.min(x - h, min[0]);
            min[1] = Math.min(y - h, min[1]);
        }
        // формулы
        int maxValue = Math.max(max[0] - min[0], max[1] - min[1]);
        int h = (int)Math.ceil(maxValue / 2.0);
        int x = (min[0] + max[0]) / 2;
        int y = (min[1] + max[1]) / 2;
        System.out.println(x + " " + y + " " + h);
    }
}