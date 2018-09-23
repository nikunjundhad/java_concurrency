package main.java.simple;

public class SimpleThreadExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("nik");

        Thread hi = new Thread(() -> {
        for(int i =0 ; i <= 10; i++){
                System.out.println("Hi : " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread hello = new Thread(() -> {
        for(int i =0 ; i <= 10; i++){
                System.out.println("Hello : " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        hi.start();
        hello.start();

        hi.join();
        hello.join();
        System.out.println("Success");
    }
}

class HiThread implements Runnable{

    @Override
    public void run() {
        for(int i =0 ; i <= 10; i++){
            System.out.println("Hi : " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HelloThread implements Runnable{
    @Override
    public void run() {
        for(int i =0 ; i <= 10; i++){
            System.out.println("Hello : " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
