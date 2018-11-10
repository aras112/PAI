package com.company;


import java.math.BigDecimal;

public class Client implements Runnable
{
    private String name = null;
    private Bank bank;
    private Client friend;
    private Integer moneyTransfer = 15;
    private Boolean thiefNeighbor = false;

    Client(String name, Bank bank, Client friend)
    {
        this.name = name;
        this.bank = bank;
        this.friend = friend;
    }

    public void setFriend(Client friend)
    {
        this.friend = friend;
    }

    public void setThiefNeighbor(Boolean thiefNeighbor)
    {
        this.thiefNeighbor = thiefNeighbor;
    }

    @Override
    public void run()
    {
        while (friend == null)
            {
            try
                {
                Thread.sleep(100);
                } catch (InterruptedException e)
                {
                e.printStackTrace();
                }
            }

        while (moneyTransfer > 0&&!Thread.interrupted())
            {
            try
                {
                if (thiefNeighbor == false || (bank.getNumberOfMoney(this).compareTo((bank.getNumberOfMoney(friend))) > 0))
                    {
                    System.out.println("Pan " + this + " przed przelaniem ma " + bank.getNumberOfMoney(this) + "zł");
                    bank.transfer(this, friend, new BigDecimal("10"));
                    moneyTransfer--;
                    }
                else
                    {
                    Thread.sleep(1000);
                    System.out.println(friend + " to sąsiad złodziej!!!!");
                    }
                } catch (InterruptedException e)
                {

                System.out.println("Przerwano Urzytkownikowi " + this);
                Thread.currentThread().interrupt();

                }
            }
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj.getClass().equals(this.getClass()) && obj != null)
            {
            return this.name == ((Client) obj).name;
            }
        return false;
    }

    public Bank getBank()
    {
        return bank;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
