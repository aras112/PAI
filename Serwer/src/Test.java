import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Test
{

    //telnet google.com
    //telnet google.com 80
    //telnet time-A.timefreq.bldrdoc.gov 13

    public static void main(String[] args)
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
}
