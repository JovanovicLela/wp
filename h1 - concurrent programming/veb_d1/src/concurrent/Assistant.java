package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Assistant implements Runnable{

    private CountDownLatch countDownLatch;
    private Semaphore semaphore;
    private String name = "Assistant";

    public Assistant(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        semaphore = new Semaphore(1);
    }

    @Override
    public void run() {
        System.out.println("Assistant prepared.");
        Thread.currentThread().setName(name);
        countDownLatch.countDown();
    }

    public String getName() {
        return name;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

}
