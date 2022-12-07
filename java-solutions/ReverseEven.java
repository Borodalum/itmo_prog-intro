import java.util.*;

public class ReverseEven {
    public static void main( String[] args ) {
        Scanner mainScan = new Scanner(System.in);
        int[][] resultArray = new int[1][1];
        int height = 0; 
        while (mainScan.hasNextLine()) {
            Scanner lineScan = new Scanner(mainScan.nextLine());
            int[] lineArray = new int[2];
            int width = 0;
            while (lineScan.hasNextInt()) {
                lineArray[width] = lineScan.nextInt();
                width++;
                if (width >= lineArray.length) {
                    lineArray = Arrays.copyOf(lineArray, lineArray.length * 2);
                }
            }
            resultArray[height] = Arrays.copyOf(lineArray, width);
            height++;
            if (height >= resultArray.length) {
                resultArray = Arrays.copyOf(resultArray, resultArray.length * 2);
            }
        }
        resultArray = Arrays.copyOf(resultArray, height);
        for (int i = resultArray.length - 1; i >= 0; i--) {
            for (int j = resultArray[i].length - 1; j >= 0; j--) {
                if (resultArray[i][j] % 2 == 0) { 
                    System.out.print(resultArray[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}