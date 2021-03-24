package neu.kaitian;

import java.util.PriorityQueue;

public class Main {

    public static PriorityQueue<PBJob> jobsQueue = new PriorityQueue<>();
    public static Object obj = new Object();
    public static void main(String[] args) {

        JobCreatingThread jobsArray[] = new  JobCreatingThread[10];
        for (int i = 0; i < jobsArray.length; i++) {
            jobsArray[i] = new JobCreatingThread();
            jobsArray[i].setName("Job" + String.valueOf(i));
            jobsArray[i].start();
        }

        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PBScheduler pbScheduler = new PBScheduler();
        pbScheduler.setName("PB Scheduler");
        pbScheduler.start();

        System.out.println("Start test");
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
