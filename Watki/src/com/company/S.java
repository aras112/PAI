package com.company;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class S
{
    public static void main(String[] args) throws InterruptedException
    {
        Bank pko = new Bank();
        ExecutorService clients = Executors.newCachedThreadPool();
        Thread kontrola;
        Client zus = new Client("ZUS", pko, null);
        Client kowalski = new Client("Kowalski", pko, zus);
        Client kowalski2 = new Client("Piotrowicz", pko, zus);


        pko.addAccount(kowalski);
        pko.addAccount(kowalski2);
        pko.addAccount(zus);

        pko.sendMoney(kowalski, new BigDecimal("1000"));
        pko.sendMoney(kowalski2, new BigDecimal("500"));

        //Kontrola

        for (Integer i = 0; i < 10000; i++)
            {
            kontrola = new Thread(new ZusKontrola(kowalski));
            kontrola.setPriority(Thread.MAX_PRIORITY);
            kontrola.setDaemon(true);
            kontrola.start();
            }


        clients.submit(kowalski);
        clients.submit(kowalski2);


        clients.shutdown();

    }


}
