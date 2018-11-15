package com.company;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DL
{
    public static void main(String[] args) throws InterruptedException
    {
        Bank pko = new Bank();
        ExecutorService clients = Executors.newCachedThreadPool();

        Client zus = new Client("ZUS", pko, null);
        Client kowalski = new Client("Kowalski", pko, zus);
        Client kowalski2 = new Client("Kowalski2", pko, zus);



        pko.addAccount(kowalski);
        pko.addAccount(kowalski2);
        pko.addAccount(zus);


        clients.submit(kowalski);
        clients.submit(kowalski2);


        Thread.sleep(10);
        pko.sendMoney(kowalski, new BigDecimal("1000"));
        pko.sendMoney(kowalski2, new BigDecimal("500"));
        clients.shutdown();

    }
}
