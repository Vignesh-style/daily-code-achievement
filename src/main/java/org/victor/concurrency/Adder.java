package org.victor.concurrency;


public class Adder implements Runnable{
    //we can make it atomic also ... simple solution.
    private Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (count){
                count.count += i;
            }
        }
    }
}
