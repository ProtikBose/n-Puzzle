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
public class searchNode {
   
    private Board board;
    private int moves;
    private searchNode prev;

    public searchNode(Board board) {
        this.board=board;
        this.moves=0;
        this.prev=null;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the moves
     */
    public int getMoves() {
        return moves;
    }

    /**
     * @param moves the moves to set
     */
    public void setMoves(int moves) {
        this.moves = moves;
    }

    /**
     * @return the prev
     */
    public searchNode getPrev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public void setPrev(searchNode prev) {
        this.prev = prev;
    }
    
    
            
}
