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
        int s;
        int portnumber = 1111;
        if (args.length >= 1) {
            portnumber = Integer.parseInt(args[0]);
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        MulticastSocket chatMulticastSocket = new MulticastSocket(portnumber);

        InetAddress group = InetAddress.getByName("225.4.5.6");

        String msg,msg2,msg3,msg4,msg0="";

        chatMulticastSocket.joinGroup(group);


        System.out.println("Vill du 1.Addera 2.Multiplicera");

        msg0 = br.readLine();
        DatagramPacket data5 = new DatagramPacket(msg0.getBytes(), 0, msg0.length(), group, portnumber);
        chatMulticastSocket.send(data5);
        int case0 =Integer.parseInt(msg0);
                switch (case0) {
                    case 1 -> {
                        System.out.println("Skriv en siffra");
                        msg = br.readLine();
                        DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, portnumber);
                        chatMulticastSocket.send(data);

                        System.out.println("Skriv en siffra");
                        msg2 = br.readLine();
                        DatagramPacket data2 = new DatagramPacket(msg2.getBytes(), 0, msg2.length(), group, portnumber);
                        chatMulticastSocket.send(data2);
                    }
                    case 2 ->{
                        System.out.println("Skriv en siffra");
                        msg3 = br.readLine();

                        DatagramPacket data3 = new DatagramPacket(msg3.getBytes(), 0, msg3.length(), group, portnumber);
                        chatMulticastSocket.send(data3);

                        System.out.println("Skriv en siffra");
                        msg4 = br.readLine();
                        DatagramPacket data4 = new DatagramPacket(msg4.getBytes(), 0, msg4.length(), group, portnumber);
                        chatMulticastSocket.send(data4);

                    }

                }
                chatMulticastSocket.close();

    }
}
