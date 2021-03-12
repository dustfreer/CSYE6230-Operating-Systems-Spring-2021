import java.util.PriorityQueue;
import java.util.Random;

public class Scheduler {
    public static void main(String[] args) throws InterruptedException {
        Thread[] producers = new Thread[5];
        Thread[] consumers = new Thread[10];
        Random rand = new Random();
        PriorityQueue<Integer> shop = new PriorityQueue();
        Object keyObj = new Object();

        for(int i = 0 ; i < producers.length; i ++){
            final int index = i;
            producers[i] = new Thread(){
                public void run(){
                        try {
                            producers[index].setName("Producer " + index);
                            while(true) {
                                int random = rand.nextInt(10);
                                synchronized (keyObj) {
                                    System.out.println(Thread.currentThread().getName() + "Produced " + random);
                                    shop.offer(random);
                                }
                                Thread.sleep(1000);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            };
            producers[i].start();
        }

        for(int i = 0 ; i < consumers.length; i ++){
            final int index = i;
            consumers[i] = new Thread(){
                public void run(){
                    try {
                        consumers[index].setName("Consumer " + index);
                        int value = 0;
                        while(true) {
                            synchronized (keyObj) {
                                if (!shop.isEmpty()) {
                                    value = shop.poll();
                                    System.out.println(Thread.currentThread().getName() + " consumed Value =  " + value);
                                    Thread.sleep(3000);
                                }
                            }

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            consumers[i].start();
        }
    }
}

