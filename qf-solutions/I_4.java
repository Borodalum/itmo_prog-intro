import java.util.Scanner;
public class I {
    private static int[] min = new int[2];
    private static int[] max = new int[2];

    public static void findMin(int x, int y, int h) {
        min[0] = min(x - h, min[0]);
        min[1] = min(y - h, min[1]);
    }
    public static void findMax(int x, int y, int h) {
        max[0] = max(x + h, max[0]);
        max[1] = max(y + h, max[1]);
    }
    public static int max(int x, int y) {
        int maxValue;
        if (x > y) {
            maxValue = x;
        } else {
            maxValue = y;
        }
        return maxValue;
    }
    public static int min(int x, int y) {
        int minValue;
        if (x < y) {
            minValue = x;
        } else {
            minValue = y;
        }
        return minValue;        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int h = sc.nextInt();
            findMin(x, y, h);
            findMax(x, y, h);
        }
        int h;
        int x = (min[0] + max[0]) / 2;
        int y = (min[1] + max[1]) / 2;
        int maxValue = max(max[0] - min[0], max[1] - min[1]);
        if (maxValue % 2 == 0) {
            h = maxValue / 2;
        } else {
            h = maxValue / 2 + 1;
        }
        System.out.println(x + " " + y + " " + h);
    }
}