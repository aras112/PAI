package com.company;

public class Licznik implements Runnable
{
    ObiektZDanymi obiektZDanymi;

    Licznik(ObiektZDanymi obiektZDanymi)
    {
        this.obiektZDanymi=obiektZDanymi;
    }

    @Override
    public void run()
    {
        while (Thread.interrupted())
            {

           /* try
                {
                Thread.sleep(20);
                } catch (InterruptedException e)
                {
                e.printStackTrace();
                }
            */
            System.out.println("Licznik---1");

            //obiektZDanymi.funkcja();
            }
    }
}
