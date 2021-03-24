package neu.kaitian;

public class PBScheduler extends Thread{
    public void run(){
        while(true){
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running");

                int priority = 0;
                synchronized (Main.obj) {
                    if (Main.jobsQueue.isEmpty()) {
                        Thread.sleep(3000);
                        continue;
                    }
                    PBJob pbJob = Main.jobsQueue.remove();
                    priority = pbJob.priority;
                    System.out.println("The priority of current thread is " + priority);
                    Thread.sleep(pbJob.jobTime);
                }

            }
            catch (Exception e) {
                System.out.println("Exception is caught in SJF Scheduler");
            }
        }
    }
}
