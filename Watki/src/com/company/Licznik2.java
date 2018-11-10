package com.company;

public class Licznik2 implements Runnable
{
    ObiektZDanymi obiektZDanymi;

    Licznik2(ObiektZDanymi obiektZDanymi)
    {
        this.obiektZDanymi = obiektZDanymi;
    }

    @Override
    public void run()
    {
        while (/*!Thread.interrupted()*/true)
            {
            System.out.println("Licznik---2");
            //obiektZDanymi.funkcja();
            }
    }
}
