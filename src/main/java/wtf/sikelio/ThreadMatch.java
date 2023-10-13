package wtf.sikelio;

import java.util.Random;

public class ThreadMatch implements Runnable {
    public String teamOne;
    public String teamTwo;

    private int teamOnePoints;
    private int teamTwoPoints;

    private CommentGenerator commentGenerator = CommentGenerator.getInstance();

    public ThreadMatch(String teamOne, String teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;

        this.teamOnePoints = 0;
        this.teamTwoPoints = 0;
    }

    @Override
    public void run() {
        System.out.println("Start match ("+ this.teamOne + " - " + this.teamTwo +")");

        for (int i = 0; i < 3; i++) {
            synchronized (this) {
                String comment = commentGenerator.getRandomComment();

                switch (comment) {
                    case "But des locaux !!!":
                        this.teamOnePoints++;
                        break;
                    case "But des visiteurs !!!":
                        this.teamTwoPoints++;
                        break;
                }

                System.out.println(this.teamOne + " - " + this.teamTwo + " : " + comment);

                try {
                    wait(this.randomMilliSecondWaiting(1000, 10000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("End match ("+ this.teamOne + ": " + this.teamOnePoints + " - " + this.teamTwo + ": " + this.teamTwoPoints +")");
    }

    private int randomMilliSecondWaiting(Integer min, Integer max) {
        Random random = new Random();

        return random.nextInt(max - min + 1) + min;
    }
}
