package wtf.sikelio;

import java.util.Random;

public class ThreadMatch implements Runnable {
    public String teamOne;
    public String teamTwo;

    public ThreadMatch(String teamOne, String teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                System.out.println(this.teamOne + " - " + this.teamTwo + " : " + CommentGenerator.getRandomComment());

                try {
                    wait(this.randomMilliSecondWaiting(1000, 10000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private int randomMilliSecondWaiting(Integer min, Integer max) {
        Random random = new Random();

        return random.nextInt(max - min + 1) + min;
    }
}
