/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npuzzle;

/**
 *
 * @author PRANTO
 */
public class conversionSearch {

    static int minimumSwaps(int[] arr) {
        int swap = 0;
        boolean visited[] = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int j = i, cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j] - 1;
                cycle++;
            }

            if (cycle != 0) {
                swap += cycle - 1;
            }
        }
        return swap;
    }

    public static int minswap(int[] arr) {
        int num = minimumSwaps(arr);
        return num;
    }
}
