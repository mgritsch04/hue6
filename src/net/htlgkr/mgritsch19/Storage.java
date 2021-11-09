/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch19;

import java.util.concurrent.ArrayBlockingQueue;

public class Storage {

    private final ArrayBlockingQueue<Integer> queue;

    private int fetchedCounter;
    private int storedCounter;
    private int underflowCounter;
    private int overflowCounter;
    private boolean productionComplete;

    public Storage() {
        this.queue = new ArrayBlockingQueue<>(10);
    }

    public Storage(int fetchedCounter, int storedCounter, int underflowCounter, int overflowCounter) {
        this.queue = new ArrayBlockingQueue<>(10);
        this.fetchedCounter = fetchedCounter;
        this.storedCounter = storedCounter;
        this.underflowCounter = underflowCounter;
        this.overflowCounter = overflowCounter;
        this.productionComplete = false;
    }

    public synchronized boolean put(Integer data) throws InterruptedException {
        if (queue.remainingCapacity() > 0) {
            queue.put(data);
            storedCounter++;
            return true;
        } else {
            overflowCounter++;
            return false;
        }

    }

    public synchronized Integer get() {
        if (queue.isEmpty()) {
            underflowCounter++;
            return null;
        } else {
            fetchedCounter++;
            return queue.poll();
        }
    }

    public boolean isProductionComplete() {
        return productionComplete;
    }

    public void setProductionComplete(boolean productionComplete) {
        this.productionComplete = productionComplete;
    }

    public int getFetchedCounter() {
        return fetchedCounter;
    }

    public int getStoredCounter() {
        return storedCounter;
    }

    public int getUnderflowCounter() {
        return underflowCounter;
    }

    public int getOverflowCounter() {
        return overflowCounter;
    }

}
