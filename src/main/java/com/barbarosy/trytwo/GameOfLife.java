package com.barbarosy.trytwo;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by barbarosy on 09.02.2017.
 */
public class GameOfLife {
    private int dimension;
    public static boolean[][] board;
    private long generation;
    HashMap<Integer, Object> hashtable = new HashMap();



    public GameOfLife(int dimension) {
        this.dimension = dimension;
        createBoard();
        createHashTable();
        this.generation = 0;
    }

    private void createHashTable() {
        hashtable.put(0, Kill.kill());
        hashtable.put(1, Kill.kill());
        hashtable.put(2, Live.live());
        hashtable.put(3, BornOrLive.BornOrLive());
        hashtable.put(4, Kill.kill());
        hashtable.put(5, Kill.kill());
        hashtable.put(6, Kill.kill());
        hashtable.put(7, Kill.kill());
        hashtable.put(8, Kill.kill());
    }


    /*
    private Object live() {
        return isAlive;
    }

    private Object bornOrLive() {
        return true;
    }

    private Object new Kill() {
        return false;
    }*/

    private void createBoard() {
        boolean[][] newBoard = new boolean[dimension][dimension];
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                newBoard[i][j] = (Math.random() < 0.4);
            }
        }
        board = newBoard;
    }

    public void drawBoard() {
        System.out.println("\033[H\033[2J");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] ? "#" : ".");
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("generation: " + generation);
    }

    public void nextGeneration() {
        boolean[][] newBoard = new boolean[dimension][dimension];
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                newBoard[i][j] = applyRules(i, j);
            }
        }
        board = newBoard;
        generation++;
    }

    public boolean isBordEmpty() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == true) {
                    return false;
                }
            }
        }

        return true;
    }





    private boolean applyRules(int row, int column) {
        int liveNeighbours = 0;
        boolean isCellAlive = board[row][column];

        for (int i = -1; i <= 1; i++) {
            int currRow = row + i;
            currRow = (currRow < 0) ? dimension - 1 : currRow;
            currRow = (currRow >= dimension) ? 0 : currRow;
            for (int j = -1; j <= 1; j++) {
                int currCol = column + j;
                currCol = (currCol < 0) ? dimension - 1 : currCol;
                currCol = (currCol >= dimension) ? 0 : currCol;
                if (board[currRow][currCol]) {
                    liveNeighbours++;
                }
            }
        }
        if (isCellAlive) {
            liveNeighbours--;
        }

        /* try to use hashmap for if else
        Global.isAlive = isCellAlive;
        hashtable.get(liveNeighbours);
        return Global.status;*/


        if (!isCellAlive){
            if (liveNeighbours==3)
                return true;
            else
                return false;
        }else
        {
            if (liveNeighbours==2||liveNeighbours==3)
                return true;
            else
                return false;

        }


        /*
        if(liveNeighbours == 2 && isCellAlive){
            return true;
        } else if(liveNeighbours == 3){
            return true;
        } else {
            return false;
        }*/

    }


}
