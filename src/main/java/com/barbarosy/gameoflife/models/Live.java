package com.barbarosy.gameoflife.models;

/**
 * Created by barbarosy on 09.02.2017.
 */
public class Live extends LiveOrDie {

    public Live() {
    }

    /**
     * This method gives life status of cell that has two neighbours.<br>
     * One of the game of life rule is if you have two neighbours: <br>
     *
     *    <li>If cell is alive, cell will be alive in next generation.</li>
     *    <li>If cell is not alive, cell will be dead in next generation.</li>
     *
     * @param isAlive:  boolean value of cell current life status.
     * @return boolean value of cell is alive or dead.
     */
    public boolean getLiveOrDieStatus(boolean isAlive) {
        return isAlive;
    }
}
