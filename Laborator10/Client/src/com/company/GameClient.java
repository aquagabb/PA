
package com.company;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GameClient
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Scanner scanner = new Scanner(System.in);

            InetAddress ip = InetAddress.getByName("localhost");
            Socket socket = new Socket(ip, 7777);

            DataInputStream dataInput = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.println(dataInput.readUTF());
                String tosend = scanner.nextLine();
                dataOutput.writeUTF(tosend);
                // Comanda Exit
                if (tosend.equals("Exit")) {
                    System.out.println("Se inchide conexiunea : " + socket);
                    socket.close();
                    System.out.println("Conexiune inchisa !");
                    break;
                }
                String received = dataInput.readUTF();
                System.out.println(received);
            }
            scanner.close();
            dataInput.close();
            dataOutput.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
} 