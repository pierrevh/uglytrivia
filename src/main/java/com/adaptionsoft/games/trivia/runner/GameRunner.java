
package com.adaptionsoft.games.trivia.runner;
import java.util.Arrays;
import java.util.List;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
        NumberGenerator rand = new RandomNumberGenerator();
		run(Arrays.asList("Chet", "Pat", "Sue"), rand);
	}

	public static void run(List<String> players, NumberGenerator random) {
		Game aGame = new Game();
		players.stream().forEach(p->aGame.add(p));

		do {
			aGame.turn(random.nextInt(5) + 1);
			if (random.nextInt(9) == 7) {
				aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
		} while (notAWinner);
	}
}
