import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Klient implements Runnable
{
    Socket socket;
    Scanner scanner;
    PrintWriter writer;

    Klient()
    {
        socket = new Socket();
    }

    @Override
    public void run()
    {

        try
            {
            socket.connect(new InetSocketAddress("localhost", 1997),2000);
            scanner = new Scanner(new BufferedInputStream(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            while (true)
                {
                System.out.println("Wyslanie do serwera napisu ");
                writer.println("Karolinka");

                Thread.sleep(3000);

                if (scanner.hasNextLine())

                    System.out.println("Odebrano od serwera : "+scanner.nextLine());

                }

            } catch (IOException | InterruptedException e)
            {
            } finally
            {
            writer.close();
            scanner.close();

            try
                {
                socket.close();
                } catch (IOException e)
                {
                e.printStackTrace();
                }
            }
    }


}
