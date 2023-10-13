package concurrent;

import java.sql.Time;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static int NUMBER_OF_STUDENTS = 0;
    public static long timeInitialised;

    public static AtomicBoolean flag = new AtomicBoolean(true);
    public static AtomicInteger sum = new AtomicInteger();
    public static AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter the number of students: ");
        Scanner sc = new Scanner(System.in);
        NUMBER_OF_STUDENTS = sc.nextInt();
        sc.close();

// Inicijalizujemo ispitivace, koristimo CountDownLatch da bismo bili sigurni da su oba
        // inicijalizovana pre nego sto program pocne
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Professor professor = new Professor(countDownLatch);
        Assistant assistant = new Assistant(countDownLatch);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(professor);
        executorService.execute(assistant);
        countDownLatch.await();

        System.out.println("Beginning: \n");
        timeInitialised = System.currentTimeMillis();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(NUMBER_OF_STUDENTS);
        for(int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            Student student = new Student(professor, assistant);
            student.setName("Student " + (i+1));
            scheduledExecutorService.schedule(student, student.getStudentDefenseTime(), TimeUnit.MILLISECONDS);
        }

        try {
            Thread.sleep(5000);
            scheduledExecutorService.shutdownNow();
            executorService.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag.set(false);
        System.out.println("\nThe number of examined students: " + counter.intValue() +
                           "\nTotal score: " + sum.intValue());
        System.out.format("Average score: %.2f\n", sum.doubleValue() / counter.doubleValue());


    }
}
