package com.company;

public class Test
{

    public static void main(String[] arg)
    {

        ObiektZDanymi obiektZDanymi=new ObiektZDanymi();

        //ten sam obiekt do 2 wątków

        Licznik licznik=new Licznik(obiektZDanymi);
        Licznik2 licznik2=new Licznik2(obiektZDanymi);

        Thread watek = new Thread(licznik);

        watek.start();

        //watek.interrupt();
        Thread watek2 = new Thread(licznik2);

        watek2.start();



    }

}
