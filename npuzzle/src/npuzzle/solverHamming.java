/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npuzzle;


import java.util.Comparator;
import java.util.PriorityQueue;
import static npuzzle.Npuzzle.d;

/**
 *
 * @author PRANTO
 */

class priorityHelp implements Comparator<searchNode>{

    @Override
    public int compare(searchNode node1, searchNode node2) {
       
        int result=0;
        int compare1=node1.getBoard().hamming()+node1.getMoves();
        int compare2=node2.getBoard().hamming()+node2.getMoves();
        if(compare1>compare2) result=1;
        else if(compare1<compare2) result=-1;
        else result=0;
        return result;
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

    
    
}

public class solverHamming {

    //private int dimension;
    
   public static  void printSolution(searchNode snode){
       Board b=snode.getBoard();
       //System.out.println(b);
        //System.out.println(b.board);
        System.out.println("print");
        for(int i=0;i<b.board.length;i++)
            System.out.println(b.board[i]);
    }
   
   public static boolean checkGoal(searchNode snode){
       Board b=snode.getBoard();
       for (int i=0;i<d*d-1;i++)
             if (b.board[i] != i + 1) 
                 return false;
       return true;
   }
    
    
    public static void doSolver(Board board){
        
        int exploredNode=0;
        int expandedNode=0;
        System.out.println("Enter hamming solver");
        searchNode node1=new searchNode(board);
        priorityHelp orderedList=new priorityHelp();
      //  MinPQ<searchNode>priorityQueue=new MinPQ<searchNode>(orderedList);
        PriorityQueue<searchNode>pQueue=new PriorityQueue<searchNode>(orderedList);  //openList
        PriorityQueue<searchNode>pDeQueue=new PriorityQueue<searchNode>(orderedList);  //close list
        pQueue.add(node1);
        exploredNode++;
        System.out.println("now");
       // printSolution(node1);
        searchNode snode=pQueue.remove();
        System.out.println(snode.getPrev());
        while(!checkGoal(snode)){
            
            for (Board b : snode.getBoard().childConfig()) {      
                if (snode.getPrev()==null || !b.checkEqual(snode.getPrev().getBoard())) {   // check if move back this previous state
                    searchNode n = new searchNode(b);
                    n.setMoves(snode.getMoves() + 1);
                    n.setPrev(snode);
                    pQueue.add(n);
                    expandedNode++;
                }
            }
            
            
            
            
            snode=pQueue.peek();
            exploredNode++;
            pDeQueue.add(snode);
           // System.out.println(exploredNode);
         //   printSolution(snode);
            
        }
        System.out.println("Found");
        System.out.println("Explored nodes : "+exploredNode);
        System.out.println("Expanded Nodes : "+expandedNode);
    }
}
