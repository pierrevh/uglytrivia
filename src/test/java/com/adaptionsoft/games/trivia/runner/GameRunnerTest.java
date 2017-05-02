package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void canRunFromMain() throws Exception {
        GameRunner.main(new String[] {});
        assertTrue(true);
    }

    @Test
    public void canRunWithFixedControls() throws Exception {
        GameRunner.run(Arrays.asList("Pierre", "Henkie"), new FixedNumberGenerator());
        assertTrue(true);
    }

    private  static  class FixedNumberGenerator implements NumberGenerator {

        @Override
        public int nextInt(int bound) {
            return 3;
        }
    }
}