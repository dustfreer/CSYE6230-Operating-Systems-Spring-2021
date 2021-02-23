import java.util.Random;

public class Question1 {
    static int[] values = new int[500000000];
    static long[] portionSum = new long[10];
    static int portionSize = values.length / 10;

    static long getSum(){
        long sum = 0 ;
        for(int i = 0 ; i < values.length; i ++){
            sum += values[i];
        }
        return sum;
    }

    static void generateValues(){
        Random rand = new Random();
        for(int i = 0 ; i < values.length; i ++){
            values[i] = rand.nextInt(10);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Generating values");
        generateValues();
        long start = System.currentTimeMillis();
        long sum = getSum();
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("Sum = " + sum);
        System.out.println("Time Elapsed without thread= " + elapsedTime);

        //calculator by threads
        System.out.println("Starting to calculate sum in Threads");
        sum = 0;
        start = System.currentTimeMillis();

        Thread[] threads = new Thread[10];
        for(int i = 0 ; i < 10; i++){
            final int index = i;
            threads[i] = new Thread(){
                public void run(){
                    long sum = 0;
                    for(int j = index * portionSize ; j < (index+1) * portionSize; j++){
                        sum += values[j];
                    }
                    portionSum[index] = sum;
                }
            };
            threads[i].start();
        }

        for(int i = 0 ; i < 10; i ++){
            threads[i].join();
        }

        for(int i = 0; i < 10; i ++){
            sum += portionSum[i];
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println("Sum = " + sum);
        System.out.println("Time Elapsed with threads= " + elapsedTime);

    }
}
