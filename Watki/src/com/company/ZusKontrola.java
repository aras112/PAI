package com.company;

public class ZusKontrola implements Runnable
{
    Client kontrolowany;
    Bank bank;

    ZusKontrola(Client kontrolowany)
    {
        this.kontrolowany = kontrolowany;
        bank = kontrolowany.getBank();
    }


    @Override
    public void run()
    {
        while (!Thread.interrupted())
            {
            bank.getNumberOfMoney(kontrolowany);
            }
    }
}
