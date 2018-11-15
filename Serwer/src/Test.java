import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Test
{

    //telnet google.com
    //telnet google.com 80
    //telnet time-A.timefreq.bldrdoc.gov 13

    public static void main(String[] args) throws InterruptedException, IOException
    {
        //test();
        //test2();
       // new Thread(new Klient()).start();
        //test3();
        //test4();


    }


    static void test()
    {
        try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13))
            {

            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner(inStream);


            while (in.hasNextLine())
                {
                String line = in.nextLine();
                System.out.println(line);
                }
            } catch (IOException e)
            {
            e.printStackTrace();
            }
    }

    static void test2()
    {
        try (ServerSocket serwer = new ServerSocket(1997))
            {

            try (Socket socket = serwer.accept())
                {

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println("Karolinka !!!!!!");
                writer.close();

                }


            } catch (IOException e)
            {
            e.printStackTrace();
            }

    }

    static void test3()
    {
        try (ServerSocket serwer = new ServerSocket(1997))
            {


            while (true)
                {

                Socket socket = serwer.accept();
                {
                SerwerWatek serwerWatek = new SerwerWatek(socket);
                new Thread(serwerWatek, "Serwer").start();
                }

                }
            } catch (IOException e)
            {
            e.printStackTrace();
            }


    }

    static void test4() throws IOException
    {
    }
}

