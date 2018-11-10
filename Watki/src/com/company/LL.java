package com.company;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LL
{
    public static void main(String[] args) throws InterruptedException
    {
        Bank pko = new Bank();
        ExecutorService clients = Executors.newCachedThreadPool();

        Client kowalski = new Client("Kowalski", pko, null);
        Client kowalski2 = new Client("Piotrowicz", pko, null);

        Thread watek1=new Thread(kowalski);
        Thread watek2=new Thread(kowalski2);

        kowalski.setFriend(kowalski2);
        kowalski2.setFriend(kowalski);

        kowalski.setThiefNeighbor(true);
        kowalski2.setThiefNeighbor(true);



        pko.addAccount(kowalski);
        pko.addAccount(kowalski2);

        pko.sendMoney(kowalski, new BigDecimal("60"));


        watek1.start();
        watek2.start();

        Thread.sleep(4000);

        if(watek1.isAlive())
            watek1.interrupt();

        if(watek2.isAlive())
            watek2.interrupt();


        clients.shutdown();

    }
}
