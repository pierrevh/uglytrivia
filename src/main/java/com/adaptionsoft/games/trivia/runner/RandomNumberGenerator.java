package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private Random rand;

    public RandomNumberGenerator() {
        this.rand = new Random();
    }

    @Override
    public int nextInt(int bound) {
        return rand.nextInt(bound);
    }
}
