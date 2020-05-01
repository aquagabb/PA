package com.company;
// ClientHandler class
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

class ClientThread extends Thread
{
    final DataInputStream dataInput;
    final DataOutputStream dataOutput;
    final Socket socket;

    public ClientThread(Socket socket, DataInputStream dataInput, DataOutputStream dataOutput)
    {
        this.socket = socket;
        this.dataInput = dataInput;
        this.dataOutput = dataOutput;
    }
    @Override
    public void run()
    {
        String message;

        while (true)
        {
            try {
                dataOutput.writeUTF("Type Exit to terminate connection.");
                message = dataInput.readUTF();
                System.out.println("Clientul a trimis mesajul : "+message);
                if(message.equals("Exit"))
                {
                    this.socket.close();
                    System.out.println("Conexiunea s-a terminat");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }try
        {
            this.dataInput.close();
            this.dataOutput.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}