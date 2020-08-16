/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static npuzzle.Npuzzle.d;

/**
 *
 * @author PRANTO
 */
public class Board {
    
    public int[] board;
    public int dimension;
    
    public Board(int [][]block,int numberCount){
        this.dimension=numberCount;
        board = new int[numberCount*numberCount];
        for(int i=0;i<numberCount;i++)
            for(int j=0;j<numberCount;j++)
                board[i*numberCount+j]=block[i][j];
        //return board;
    }
    
    private Board(int[] board) {            // private constructor useful in twin()
      
        this.board=new int[board.length];
        for (int i=0;i<board.length;i++)
            this.board[i]=board[i];
    }
    
    public int numOfConversion(int[ ] arr){
       
        int[] convertArr=new int[dimension*dimension-1];
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0) continue;
            convertArr[count++]=arr[i];
        }
        
        int n=conversionSearch.minswap(convertArr);
        return n;
    }
    
     public int hamming() {                  // number of blocks out of place
        int count = 0;
        for (int i = 0; i < dimension * dimension; i++)      // compare board[1] through board[N^2-1] with goal
                if (board[i] != i + 1 && board[i] != 0)                  // count for blocks in wrong place
                    count++;
        return count;
    }
     
    public boolean checkEqual(Object obj){
        if(obj==this) return true;
        if(obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;
        Board checkmate=(Board)obj;
        return Arrays.equals(this.board,checkmate.board);
    }
    
    public Iterable<Board> childConfig(){
        
        int zeroNum = 0;
        Board childBoard;
        int temp;
        
        for(int i=0;i<board.length;i++){
            if(board[i]==0){
                zeroNum=i;
                break;
            }
        }
        
        Queue<Board>child=new LinkedList<Board>();
        
        //if the zero is not in leftmost coloumn
        if((zeroNum%d)!=0){
            
            childBoard=new Board(board);
            //exchange it with leftmove block
            temp = childBoard.board[zeroNum];
            childBoard.board[zeroNum-1] = childBoard.board[zeroNum];
            childBoard.board[zeroNum] = temp;
            child.add(childBoard);
        }
        
        //if the zero is not in rightmost coloumn
        if((zeroNum%d)!=(d-1)){
            
            childBoard=new Board(board);
            //exchange it with rightmove block
            temp = childBoard.board[zeroNum];
            childBoard.board[zeroNum+1] = childBoard.board[zeroNum];
            childBoard.board[zeroNum] = temp;
            child.add(childBoard);
        }
        //if the zero is not in first row
        if((zeroNum/d)!=0){
            
            childBoard=new Board(board);
            //exchange it with upper block
            temp = childBoard.board[zeroNum];
            childBoard.board[zeroNum-dimension] = childBoard.board[zeroNum];
            childBoard.board[zeroNum] = temp;
            child.add(childBoard);
        }
        
        //if the zero is not in last row
        if((zeroNum/d)!=(d-1)){
            
            childBoard=new Board(board);
            //exchange it with lower block
            temp = childBoard.board[zeroNum];
            childBoard.board[zeroNum+dimension] = childBoard.board[zeroNum];
            childBoard.board[zeroNum] = temp;
            child.add(childBoard);
        }
        
        
        
        return child;
    }
    
    public boolean isGoal() {              // is this board the goal board?
        for (int i=0;i<dimension*dimension-1;i++)
             if (board[i] != i + 1) 
                 return false;
        return true;
    }
}
