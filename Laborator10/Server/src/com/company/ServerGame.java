package com.company;

import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;
//am facut doar conexiunea dintre server si client cu thread
public class ServerGame
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Asteptam conexiunea unui client...");
        ServerSocket serverSocket = new ServerSocket(7777);
        while (true)
        {
            Socket socket = null;

            try
            {

                socket = serverSocket.accept();
                System.out.println("S-a conectat un client nou: " + socket);

                DataInputStream dataInput = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOuput = new DataOutputStream(socket.getOutputStream());
                //thread
                System.out.println("Clientul a fost preluat de un Thread");
                Thread thread = new ClientThread(socket, dataInput, dataOuput);
                thread.start();
            }
            catch (Exception e){
                socket.close();
                e.printStackTrace();
            }
        }
    }
}