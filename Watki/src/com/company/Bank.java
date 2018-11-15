package com.company;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank

{
    private HashMap<Client, BigDecimal> account = new HashMap<>();
    private BigDecimal EXTRAMONEYFORSTART = new BigDecimal("100");
    Lock lock = new ReentrantLock(false);
    private Condition condition = lock.newCondition();

    public void transfer(Client from, Client to, BigDecimal amount) throws InterruptedException
    {
        lock.lock();
        try
            {
            while (account.get(from).compareTo(amount) < 0)
                {
                condition.await(4000, TimeUnit.MILLISECONDS);
                }

            account.put(from, account.get(from).subtract(amount));
            account.put(to, account.get(to).add(amount));
            condition.signalAll();
            } finally
            {
            lock.unlock();
            }
    }

    public void addAccount(Client newClient)
    {
        account.put(newClient, EXTRAMONEYFORSTART);
    }

    public BigDecimal getNumberOfMoney(Client client)
    {
        lock.lock();
        try
            {
            return account.get(client);
            } finally
            {
            lock.unlock();
            }
    }

    public void sendMoney(Client client, BigDecimal amount)
    {

        account.put(client, account.get(client).add(amount));

    }

}