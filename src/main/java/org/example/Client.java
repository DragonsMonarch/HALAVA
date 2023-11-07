package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket mySocket;

    private MessageGet messageGet;
    private MessagePost messagePost;

    private static String Name;


    public void startClient(String IpAdr, int PORT, String Name) throws IOException {
        mySocket = new Socket(IpAdr, PORT);
        this.Name = Name;

        messagePost = new MessagePost(mySocket);
        messagePost.start();
        messageGet = new MessageGet(mySocket);
        messageGet.start();
    }

    private class MessageGet extends Thread {
        private BufferedReader reader;
        private Socket clientSocket;
        MessageGet(Socket clientSocket) throws IOException{

            this.clientSocket = clientSocket;
            this.reader = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        }
        @Override
        public void  run(){
                while (!clientSocket.isClosed()){
                    try {
                        System.out.println(reader.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

        }
    }
    private class MessagePost extends Thread{

        private BufferedWriter writer;

        private Socket clientSocket;
        Scanner scan = new Scanner(System.in);

        MessagePost(Socket clientSocket) throws IOException{
            this.clientSocket = clientSocket;
            writer = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
            writer.write("Вход пользователя: "+Name+"\n");
            writer.flush();
        }

        @Override
        public void run(){
            while (!clientSocket.isClosed()){
                try{
                    writer.write(Terminal.WHITE+Name + Terminal.YELLOW + "-->"+ Terminal.GREEN+ scan.nextLine() + "\n");
                    writer.flush();
                } catch (IOException e){

                }

            }
        }
    }

}
