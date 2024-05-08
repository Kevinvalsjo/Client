import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public class MulticastChatClient {
        public static void main(String args[]) throws Exception {
            int s;
            int portnumber = 1111;
            if (args.length >= 1) {
                portnumber = Integer.parseInt(args[0]);
            }


            MulticastSocket chatMulticastSocket = new MulticastSocket(portnumber);

            InetAddress group = InetAddress.getByName("225.4.5.6");
// Joins a multicast group
            String msg = "";
            chatMulticastSocket.joinGroup(group);
// Prompt a user to enter a message String msg = "";
            System.out.println("Vad vill du räkna ut?");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            msg = br.readLine();

            DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, portnumber);
            chatMulticastSocket.send(data);

            chatMulticastSocket.close();
        }
    }
}