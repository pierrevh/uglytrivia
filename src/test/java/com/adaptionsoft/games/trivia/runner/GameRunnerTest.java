package com.adaptionsoft.games.trivia.runner;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void canRun() throws Exception {
        GameRunner.main(new String[] {});
        assertTrue(true);
    }
}