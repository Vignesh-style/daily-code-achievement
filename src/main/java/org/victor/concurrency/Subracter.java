package org.victor.concurrency;

public class Subracter implements Runnable{

    private Count count;

    public Subracter(Count count) {
        this.count = count;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            synchronized (count){
                this.count.count -= i;
            }
        }

    }
}
