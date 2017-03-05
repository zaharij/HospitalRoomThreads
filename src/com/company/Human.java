package com.company;

/**
 * Created by Zakhar on 05.03.2017.
 */
abstract class Human implements Runnable {
    private int timeIn;
    private Thread thread;

    public Human (int timeIn){
        thread = new Thread(this);
        this.timeIn = timeIn;
        thread.start();
    }

    public Human(){
        this.timeIn = 1000;
    }

    @Override
    public void run() {
        try {
            enter();
            thread.sleep(timeIn);
            exit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    abstract void enter();
    abstract void exit();
}
