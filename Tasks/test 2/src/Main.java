import util.ArrayUtils;

public class Main {

    public static int[][] solve(int rowCount, int colCount) {
        int[][] arr = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                arr[i][j] = Math.abs(i - j);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = solve(4, 6);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.print("\n");
        }
    }
}