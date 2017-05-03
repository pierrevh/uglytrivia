package com.adaptionsoft.games.trivia.runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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

    private static final String goldenMasterAlwaysRoll4AndNoPenaltyBox =
        "Pierre was added\n" +
        "They are player number 1\n" +
        "Henkie was added\n" +
        "They are player number 2\n" +
        "Pierre is the current player\n" +
        "They have rolled a 4\n" +
        "Pierre's new location is 4\n" +
        "The category is Pop\n" +
        "Pop Question 0\n" +
        "Answer was correct!!!!\n" +
        "Pierre now has 1 Gold Coins.\n" +
        "Henkie is the current player\n" +
        "They have rolled a 4\n" +
        "Henkie's new location is 4\n" +
        "The category is Pop\n" +
        "Pop Question 1\n" +
        "Answer was correct!!!!\n" +
        "Henkie now has 1 Gold Coins.\n" +
        "Pierre is the current player\n" +
        "They have rolled a 4\n" +
        "Pierre's new location is 8\n" +
        "The category is Pop\n" +
        "Pop Question 2\n" +
        "Answer was correct!!!!\n" +
        "Pierre now has 2 Gold Coins.\n" +
        "Henkie is the current player\n" +
        "They have rolled a 4\n" +
        "Henkie's new location is 8\n" +
        "The category is Pop\n" +
        "Pop Question 3\n" +
        "Answer was correct!!!!\n" +
        "Henkie now has 2 Gold Coins.\n" +
        "Pierre is the current player\n" +
        "They have rolled a 4\n" +
        "Pierre's new location is 0\n" +
        "The category is Pop\n" +
        "Pop Question 4\n" +
        "Answer was correct!!!!\n" +
        "Pierre now has 3 Gold Coins.\n" +
        "Henkie is the current player\n" +
        "They have rolled a 4\n" +
        "Henkie's new location is 0\n" +
        "The category is Pop\n" +
        "Pop Question 5\n" +
        "Answer was correct!!!!\n" +
        "Henkie now has 3 Gold Coins.\n" +
        "Pierre is the current player\n" +
        "They have rolled a 4\n" +
        "Pierre's new location is 4\n" +
        "The category is Pop\n" +
        "Pop Question 6\n" +
        "Answer was correct!!!!\n" +
        "Pierre now has 4 Gold Coins.\n" +
        "Henkie is the current player\n" +
        "They have rolled a 4\n" +
        "Henkie's new location is 4\n" +
        "The category is Pop\n" +
        "Pop Question 7\n" +
        "Answer was correct!!!!\n" +
        "Henkie now has 4 Gold Coins.\n" +
        "Pierre is the current player\n" +
        "They have rolled a 4\n" +
        "Pierre's new location is 8\n" +
        "The category is Pop\n" +
        "Pop Question 8\n" +
        "Answer was correct!!!!\n" +
        "Pierre now has 5 Gold Coins.\n" +
        "Henkie is the current player\n" +
        "They have rolled a 4\n" +
        "Henkie's new location is 8\n" +
        "The category is Pop\n" +
        "Pop Question 9\n" +
        "Answer was correct!!!!\n" +
        "Henkie now has 5 Gold Coins.\n" +
        "Pierre is the current player\n" +
        "They have rolled a 4\n" +
        "Pierre's new location is 0\n" +
        "The category is Pop\n" +
        "Pop Question 10\n" +
        "Answer was correct!!!!\n" +
        "Pierre now has 6 Gold Coins.\n";

    private List<String> goldenMasterAsList = Arrays.asList(goldenMasterAlwaysRoll4AndNoPenaltyBox);

    @Test
    public void showsGoldenMasterOutputWhenUsingFixedControlsForGoldenMaster() throws Exception {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        GameRunner.run(Arrays.asList("Pierre", "Henkie"), new FixedNumberGenerator());
        List<String> lines = lines(canvas.toString("UTF-8"));

        assertEquals(lines(goldenMasterAlwaysRoll4AndNoPenaltyBox), lines);
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