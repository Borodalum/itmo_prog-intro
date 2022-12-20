import java.util.*;

public class ReverseOct {
    public static void main( String[] args ) {
        BetterScanner mainScan = new BetterScanner(System.in);
        int[][] resultArray = new int[4][4];
        int height = 0; 
        while (mainScan.hasNextLine()) {
            String mN = mainScan.nextLine();
            BetterScanner lineScan = new BetterScanner(mN);
            int[] lineArray = new int[4];
            int width = 0;
            while (lineScan.hasNext()) {
                lineArray[width] = Integer.parseUnsignedInt(lineScan.next(), 8);
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
                System.out.print(Integer.toOctalString(resultArray[i][j]) + " ");
            }
            System.out.println();
        }
    }
}