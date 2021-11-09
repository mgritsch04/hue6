/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch19;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {

    private final String name;
    private final Storage storage;
    private final int sleepTime;

    private final List<Integer> received;
    private boolean running;

    public Consumer(String name, Storage storage, int sleepTime) {
        this.name = name;
        this.storage = storage;
        this.sleepTime = sleepTime;
        received = new ArrayList<>();
    }

    // implement this
    public List<Integer> getReceived() {
        return received;
    }

    @Override
    public void run() {
        while (storage.isProductionComplete() == false && storage.getStoredCounter() != 0) {

        }
    }
}
