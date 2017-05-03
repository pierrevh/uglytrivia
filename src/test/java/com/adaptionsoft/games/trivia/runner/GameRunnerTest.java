package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.junit.matchers.JUnitMatchers.hasItems;

public class GameRunnerTest {


    private PrintStream productionSystemOut;

    @Before
    public void setUp() throws Exception {
        productionSystemOut = System.out;
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(productionSystemOut);
    }

    @Test
    public void canRunFromMain() throws Exception {
        GameRunner.main(new String[] {});
        assertTrue(true);
    }

    private List<String> goldenMaster = Arrays.asList(""); //TODO fill this and use in test below

    @Test
    public void canRunWithFixedControls() throws Exception {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        GameRunner.run(Arrays.asList("Pierre", "Henkie"), new FixedNumberGenerator());
        List<String> lines = lines(canvas.toString("UTF-8"));
        // using Golden Master sort of
        assertThat(lines, hasItem("Pierre was added"));
        assertThat(lines, hasItem("They are player number 1"));
        assertThat(lines, hasItem("Henkie was added"));
        assertThat(lines, hasItem("They are player number 2"));
        assertThat(lines, hasItem("Pierre now has 6 Gold Coins."));
        assertThat(lines, not(hasItem("They are player number 3")));
    }

    private static List<String> lines(String text) {
        return Arrays.asList(text.split("\\n"));
    }

    private  static  class FixedNumberGenerator implements NumberGenerator {

        @Override
        public int nextInt(int bound) {
            return 3;
        }
    }
}