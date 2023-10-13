package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Professor implements Runnable{

    private CountDownLatch countDownLatch;
    // ogranicavamo broj niti koji pristupaju resursu na 2
    private Semaphore semaphore;
    private CyclicBarrier cyclicBarrier;
    private String name = "Professor";

    public Professor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        semaphore = new Semaphore(2, true);
        cyclicBarrier = new CyclicBarrier(2);
    }

    @Override
    public void run() {
        System.out.println("Professor prepared.");
        Thread.currentThread().setName(name);
        countDownLatch.countDown();
    }

    public String getName() {
        return name;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }
}
