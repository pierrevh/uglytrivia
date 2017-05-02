
package com.adaptionsoft.games.trivia.runner;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
        Random rand = new Random();
		run(Arrays.asList("Chet", "Pat", "Sue"), rand);
	}

	private static void run(List<String> players, Random random) {
		Game aGame = new Game();
		players.stream().forEach(p->aGame.add(p));

		do {
			aGame.roll(random.nextInt(5) + 1);
			if (random.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}



		} while (notAWinner);
	}
}
