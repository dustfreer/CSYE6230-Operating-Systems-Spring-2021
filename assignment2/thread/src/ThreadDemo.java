class ThreadDemo implements Runnable {
    Thread t;
    int count;
    boolean isRunning;
    ThreadDemo(String name, int count) {
        t = new Thread(this, name);
        this.count = count;
        t.start();
        this.isRunning = true;
    }
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                System.out.println(Thread.currentThread().getName()+" is running, loop count " + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println("The child thread is interrupted.");
        }
        System.out.println("Exiting the child " + Thread.currentThread().getName());
        this.isRunning = false;
    }
}
class Demo {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Starting the Main thread");
        ThreadDemo thread1 = new ThreadDemo("thread1", 5);
        ThreadDemo thread2 = new ThreadDemo("thread2", 6);
        ThreadDemo thread3 = new ThreadDemo("thread3", 7);
        ThreadDemo thread4 = new ThreadDemo("thread4", 8);
        while (thread1.isRunning || thread1.isRunning || thread1.isRunning || thread1.isRunning) {
            Thread.sleep(1000);
        }
        System.out.println("Exiting the Main thread");
    }
}