import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SerwerWatek implements Runnable
{
    Scanner scanner;
    PrintWriter writer;
    Socket socket;

    SerwerWatek(Socket socket)
    {
        this.socket = socket;
    }


    @Override
    public void run()
    {
        try
            {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream= socket.getOutputStream();
            scanner = new Scanner(inputStream);
            writer = new PrintWriter(outputStream, true);
            } catch (IOException e)
            {
            e.getCause();
            }

        writer.println("Start serwera");

        while (scanner.hasNextLine())
            {
            String napis = scanner.nextLine();
            writer.println(napis);
            }
        scanner.close();
        writer.close();
    }
}
