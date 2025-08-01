package org.victor.concurrency;

public class Count {

    public volatile  int count;

    public Count(int count) {
        this.count = count;
    }

}
