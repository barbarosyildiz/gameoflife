package com.barbarosy.gameoflife.models;

/**
 * Created by barbarosy on 09.02.2017.
 */
public class Kill extends LiveOrDie{

    public Kill() {
    }

    /**
     * This method gives life status of cell that have two neighbours.<br>
     * One of the game of life rule is: <br>
     *         <li>If you have less than two neighbours ,cell will be dead loneliness;</li>
     *          <li>If cell has more than three neighbours, cell will be dead over population.</li>
     *
     * @param isAlive:  boolean value of cell current life status.
     * @return boolean value of cell is alive or dead. Always return false.
     */
    public boolean getLiveOrDieStatus(boolean isAlive) {
        return false;
    }
}
