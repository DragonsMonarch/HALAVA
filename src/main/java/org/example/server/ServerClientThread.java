package org.example.server;
import org.example.Terminal;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class ServerClientThread extends Thread{
    private Socket clintThread;
    private BufferedReader reader;
    private BufferedWriter writer;

    ServerClientThread(Socket clintThread, ServerFactory factory) throws IOException {
        this.clintThread = clintThread;
        reader = new BufferedReader(new InputStreamReader(clintThread.getInputStream()));
        writer = new BufferedWriter((new OutputStreamWriter(clintThread.getOutputStream())));
    }
    @Override
    public void run(){
        while (!clintThread.isClosed()){
            try{
                String message = reader.readLine();
                System.out.println(message);
                ServerFactory.sendMessage(message, this);

            }catch (IOException e){

                System.out.println(Terminal.RED + "Проблема с отправкой сообщения");
                try {
                    clintThread.close();
                    reader.close();
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }


    public void writeMessage(String message){
        try {
            writer.write(message + "\n");
            writer.flush();
        }
        catch (IOException e){
            System.out.println(Terminal.RED + "Ошибка отправления сообщения пользователю...");
        }
    }


    //Getters and Setters
    public Socket getClintThread() {
        return clintThread;
    }

    public void setClintThread(Socket clintThread) {
        this.clintThread = clintThread;
    }
}
