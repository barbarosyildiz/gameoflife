package com.barbarosy.gameoflife;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by barbarosyildiz on 11/02/2017.
 */
public class GameOfLifeTest extends TestCase {
    GameOfLife gameOfLife;

    @Before
    public void setUp() throws Exception {
        gameOfLife = new GameOfLife(6);
        gameOfLife.createRules();
        super.setUp();

    }


    @Test
    public void testBlinker() throws Exception {
        boolean[][] blinker = {
                {false, false, false, false, false, false}
                , {false, false, false, false, false, false}
                , {false, false, true, false, false, false}
                , {false, false, true, false, false, false}
                , {false, false, true, false, false, false}
                , {false, false, false, false, false, false}};
        gameOfLife.setBoard(blinker);
        gameOfLife.nextGeneration();
        assertEquals("Something went wrong with blinker patern",gameOfLife.getBoard()[3][1]&&gameOfLife.getBoard()[3][2]&&gameOfLife.getBoard()[3][3],true);


    }


    @Test
    public void testBoat() throws Exception {
        boolean[][] boat     = {
                {false, false, false, false, false, false}
                , {false, true, true, false, false, false}
                , {false, true, false, true, false, false}
                , {false, false, true, false, false, false}
                , {false, false, false, false, false, false}
                , {false, false, false, false, false, false}};
        gameOfLife.setBoard(boat);
        gameOfLife.nextGeneration();
        assertEquals("Something went wrong with boat patern",gameOfLife.getBoard()[1][1]&&gameOfLife.getBoard()[1][2]&&gameOfLife.getBoard()[2][1]&&gameOfLife.getBoard()[3][2],true);

    }

}