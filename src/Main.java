import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);
        int s;
        int portnumber = 1111;
        if (args.length >= 1) {
            portnumber = Integer.parseInt(args[0]);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MulticastSocket chatMulticastSocket = new MulticastSocket(portnumber);

        InetAddress group = InetAddress.getByName("225.4.5.6");
// Joins a multicast group
        String msg = "";
        String msg2 = "";
        chatMulticastSocket.joinGroup(group);
// Prompt a user to enter a message String msg = "";

        System.out.println("Vill du 1.Addera 2.Multiplicera");
        int svar =input.nextInt();
                switch (svar) {
                    case 1 -> {
                        System.out.println("Skriv en siffra");

                        msg = br.readLine();
                        System.out.println("Skriv en siffra");
                        msg2 = br.readLine();

                        DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, portnumber);
                        DatagramPacket data2 = new DatagramPacket(msg2.getBytes(), 0, msg2.length(), group, portnumber);
                        chatMulticastSocket.send(data);
                        chatMulticastSocket.send(data2);
                    }
                    case 2 ->{
                        System.out.println("Skriv en siffra");

                        msg = br.readLine();
                        System.out.println("Skriv en siffra");
                        msg2 = br.readLine();

                        DatagramPacket data3 = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, portnumber);
                        DatagramPacket data4 = new DatagramPacket(msg2.getBytes(), 0, msg2.length(), group, portnumber);
                        chatMulticastSocket.send(data3);
                        chatMulticastSocket.send(data4);

                    }

                }
                chatMulticastSocket.close();
    }
}
