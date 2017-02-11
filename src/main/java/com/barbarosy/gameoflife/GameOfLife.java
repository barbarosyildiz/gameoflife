package com.barbarosy.gameoflife;

import com.barbarosy.gameoflife.models.BornOrLive;
import com.barbarosy.gameoflife.models.Kill;
import com.barbarosy.gameoflife.models.Live;
import com.barbarosy.gameoflife.models.LiveOrDie;

import java.util.HashMap;

/**
 * Created by barbarosy on 09.02.2017.
 */
public class GameOfLife {
    private static boolean[][] board;
    HashMap<Integer, LiveOrDie> hashtable = new HashMap();
    private int dimension;
    private long generation;


    public GameOfLife(int dimension) {
        this.dimension = dimension;
        createBoard();
        createRules();
        this.generation = 0;
    }

    private void createRules() {
        hashtable.put(0, new Kill());
        hashtable.put(1, new Kill());
        hashtable.put(2, new Live());
        hashtable.put(3, new BornOrLive());
        hashtable.put(4, new Kill());
        hashtable.put(5, new Kill());
        hashtable.put(6, new Kill());
        hashtable.put(7, new Kill());
        hashtable.put(8, new Kill());
    }

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

        //try to use hashmap istead of conditional statements
        LiveOrDie liveOrDie = hashtable.get(liveNeighbours);
        return liveOrDie.getLiveOrDieStatus(isCellAlive);

    }


}
