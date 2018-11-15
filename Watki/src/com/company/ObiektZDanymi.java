package com.company;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObiektZDanymi
{
    ArrayList<String> lista = new ArrayList<>();
    Lock lock = new ReentrantLock(false);

    ObiektZDanymi()
    {
        lista.add("Napis 1");
        lista.add("Napis 2");
    }

    public void funkcja()
    {
        lock.lock();
        String napis1=lista.get(1);

        lista.remove(1);

        try
            {
            Thread.sleep(1000);
            } catch (InterruptedException e)
            {
            System.out.println(Thread.currentThread().getName());
            e.printStackTrace();
            }

        lista.add(1,napis1);
       lock.unlock();
    }


}
