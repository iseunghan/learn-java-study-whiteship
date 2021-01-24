package week10;

public class Test{
    static final Object lock_1 = new Object();
    static final Object lock_2 = new Object();

    private static class Sample1 extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "start.");
            synchronized (lock_1) {
                System.out.println("Thread 1 : Holding lock 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 1 : Wating for lock 2");
                synchronized (lock_2) {
                    System.out.println("Thread 1 : Holding lock 1 & 2");
                }
            }
        }
    }

    private static class Sample2 extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "start.");
            synchronized (lock_2) {
                System.out.println("Thread 2 : Holding lock 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2 : Wating for lock 1");
                synchronized (lock_1) {
                    System.out.println("Thread 2 : Holding lock 1 & 2");
                }
            }
        }
    }

    public static void main(String[] args) {
        Sample1 thread1 = new Sample1();
        Sample2 thread2 = new Sample2();
        thread1.start();
        thread2.start();
    }
}
