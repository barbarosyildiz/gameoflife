package com.barbarosy.trytwo;

/**
 * Created by barbarosy on 09.02.2017.
 */
public class GameOfLifeSimulation {
    public static void main(String[] args) throws InterruptedException {
        GameOfLife earth = new GameOfLife(10);
        earth.drawBoard();
        while(true){
            Thread.sleep(200);
            earth.nextGeneration();
            earth.drawBoard();
            if (earth.isBordEmpty()){
                System.exit(0);
            }
        }
    }
}
