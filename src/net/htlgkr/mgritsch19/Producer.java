/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch19;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    private final String name;
    private final Storage storage;
    private final int sleepTime;

    private final List<Integer> sent;
    private final int numberOfItems;

    public Producer(String name, Storage storage, int sleepTime, int numberOfItems) {
        this.name = name;
        this.storage = storage;
        this.sleepTime = sleepTime;
        this.numberOfItems = numberOfItems;
        sent = new ArrayList<>();
    }

    // implement this
    public List<Integer> getSent() {
        return sent;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfItems; i++) {
            try {
                storage.put(i);
            } catch (InterruptedException ex) {
                try {
                    Thread.sleep(sleepTime);
                    storage.put(i);

                } catch (InterruptedException ex1) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }

        }
        storage.setProductionComplete(true);
    }

}
