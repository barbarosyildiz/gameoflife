package com.barbarosy.gameoflife;

/**
 * Created by barbarosy on 09.02.2017.
 */
public class GameOfLifeSimulation {
    public static void main(String[] args) throws InterruptedException {

        int dimension = Integer.valueOf(args[0]);
        if (dimension > 0) {
            GameOfLife earth = new GameOfLife(dimension);
            earth.drawBoard();
            while (true) {
                Thread.sleep(200);
                earth.nextGeneration();
                earth.drawBoard();
                if (earth.isBordEmpty()) {
                    System.exit(0);
                }
            }
        }else
            System.err.println("Dimension of board can not be 0 or negative");


    }
}
