package concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

public class Student implements Runnable {

    private int grade;
    private long arrivalTime, defenseStartingPoint, defenseTime, studentDefenseTime;
    private boolean isFinished = false;
    private Professor professor;
    private Assistant assistant;
    private String name, examiner;

    public Student(Professor professor, Assistant assistant) {
        this.professor = professor;
        this.assistant = assistant;
        defenseTime = (new Random()).nextInt(501) + 500;
        studentDefenseTime = (new Random()).nextInt(1001);
    }

    private void professor() {

        try {
            professor.getSemaphore().acquire();
            professor.getCyclicBarrier().await();
            defenseStartingPoint = System.currentTimeMillis();

        } catch (BrokenBarrierException e) {
            professor.getSemaphore().release();
            assistant();
        } catch (InterruptedException e) {
            return;
        }

        try {
            Thread.sleep(defenseTime);
        } catch (InterruptedException e) {
            examiner = professor.getName();
            utils(examiner);
            return;
        }

        professor.getSemaphore().release();
        grade = new Random().nextInt(5) + 6;
        isFinished = true;
        examiner = professor.getName();
    }

    private void assistant() {

        if (!isFinished &&  assistant.getSemaphore().tryAcquire()  &&  Main.flag.get()) {

                defenseStartingPoint = System.currentTimeMillis();

                try {
                    Thread.sleep(defenseTime);
                } catch (InterruptedException e) {
                    examiner = assistant.getName();
                    utils(examiner);
                    return;
                }

                isFinished = true;
                examiner = assistant.getName();
                assistant.getSemaphore().release();
                grade = new Random().nextInt(5) + 6;

        }
    }

    private void utils (String s){
        arrivalTime -= Main.timeInitialised;
        defenseStartingPoint -= Main.timeInitialised;

        System.out.println("Thread: <" + name + ">    Arrival: <" + arrivalTime + "ms> " +
                "    Prof: <" + s + ">    TTC: <" + defenseTime + "ms>" +
                "    Defense starting point time: <" + defenseStartingPoint + "ms> " +
                "    Score: <" + getGrade() + "> "
        );
    }

    @Override
    public void run() {

        arrivalTime = System.currentTimeMillis();

        if (arrivalTime + defenseTime - Main.timeInitialised >= 5000) return;

        while (Main.flag.get() && !isFinished) {
            if (new Random().nextBoolean())
                professor();
            else assistant();

            if (isFinished) {
                Main.sum.addAndGet(grade);
                Main.counter.incrementAndGet();
                utils(examiner);
            }
        }
    }

        public void setName (String name){
            this.name = name;
        }

        public int getGrade () {
            return grade;
        }

        public long getStudentDefenseTime () {
            return studentDefenseTime;
        }
    }

