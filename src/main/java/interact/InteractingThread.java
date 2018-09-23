package main.java.interact;

public class InteractingThread {
    public static void main(String[] args) {
        System.out.println("Nik");
        Queue q = new Queue();

        new Producer(q);
        new Consumer(q);
    }
}

class Queue {
    private int num;
    private boolean valueSet = false;

    public synchronized void put(int i) {
        if(valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Put : " + i);
        this.num = i;
        valueSet = true;
        notify();
    }

    public synchronized void get() {
        if(!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get : " + num);
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable{

    private Queue q;

    public Producer(Queue q) {
        this.q = q;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        int i = 0;
        while (true){
            q.put(i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

class Consumer implements Runnable{

    private Queue q;

    public Consumer(Queue q) {
        this.q = q;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true){
            q.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
