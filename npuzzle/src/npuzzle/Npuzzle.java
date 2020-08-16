/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npuzzle;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author PRANTO
 */
public class Npuzzle {

    /**
     * @param args the command line arguments
     */
    /* public static int[] createBoard(int [][]block,int numberCount){
        
        int[] board = new int[numberCount*numberCount];
        //to check
        for(int i=0;i<numberCount;i++)
            for(int j=0;j<numberCount;j++)
                board[i*numberCount+j]=block[i][j];
        return board;
    } */
    public static int d;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int containRowForZero=0;
        boolean solvable = false;
        int k;
        k = in.nextInt() + 1;
        k = (int) sqrt(k);
        d=k;
        int[][] block = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                block[i][j] = in.nextInt();
                if(block[i][j]==0) containRowForZero=i;
            }
        }

        Board begining = new Board(block, k);
      //  System.out.println("Hamming check :"+begining.hamming());
      

        if ((k) % 2 == 1) {
            int n = begining.numOfConversion(begining.board);
            System.out.println("Number of conversion " + n);
            if (n % 2 == 1) {
                solvable = false;
            }
            else solvable=true;
        } else {
            int n = begining.numOfConversion(begining.board);
            n=n+containRowForZero;
            if (n % 2 == 1) {
                solvable = true;
            }
            else
                solvable=false;
                       
        }

        if(!solvable) System.out.println("No solution");
        else{
         //  solverHamming.doSolver(begining);
            //System.out.println(begining.hamming());
        }

        //  for(int i=0;i<board.length;i++)
        //      System.out.println("value :"+board[i]);
    }

}
