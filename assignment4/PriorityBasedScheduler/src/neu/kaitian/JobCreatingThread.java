package neu.kaitian;

import java.util.Random;

public class JobCreatingThread extends Thread{

    public void run(){
        Random r = new Random();
        int count = 0;
        while(count < 2){

            try {
                int rand = r.nextInt(30-20) + 20;
                Thread.sleep(rand * 1000);
                int jobTime = r.nextInt(10-5) + 5;
                int priority = r.nextInt(5-1) + 1;
                System.out.println("Thread " + Thread.currentThread().getName() + " time is " + String.valueOf(jobTime) + ", Priority is " + priority);
                synchronized (Main.obj){
                    PBJob pBJob = new PBJob(jobTime, priority);
                    Main.jobsQueue.add(pBJob);
                }
                count++;
            }
            catch (Exception e) {
                System.out.println("Exception is caught");
            }
        }

    }
}
