import java.util.Scanner;
import java.util.HashMap;

public class M {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int fillIter = 0; fillIter < n; fillIter++) {
                a[fillIter] = sc.nextInt();
            }
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int j = n - 1; j > i; j--) {
                    int k = 2 * a[j] - a[i];
                    if (map.containsKey(k)) {
                        ans += map.get(k);
                    }
                    map.put(a[j], map.getOrDefault(a[j], 0) + 1);
                }
            }
            
            System.out.println(ans);

            t--;
        }
    }
}
