package wtf.sikelio;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ThreadMatch threadMatchOne = new ThreadMatch("Lyon", "Paris");
        ThreadMatch threadMatchTwo = new ThreadMatch("Marseille", "Lilles");
        ThreadMatch threadMatchThree = new ThreadMatch("Montcuq", "Clermont-Ferrand");

        Thread threadOne = new Thread(threadMatchOne);
        Thread threadTwo = new Thread(threadMatchTwo);
        Thread threadThree = new Thread(threadMatchThree);

        try {
            threadOne.start();
            threadOne.join();

            threadTwo.start();
            threadTwo.join();

            threadThree.start();
            threadThree.join();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
