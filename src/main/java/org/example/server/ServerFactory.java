package org.example.server;


import org.example.Terminal;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

public class ServerFactory{

    private static LinkedList<ServerClientThread> threads = new LinkedList<ServerClientThread>();

    public void createThread(Socket threadSocket) throws IOException{
        ServerClientThread thread =  new ServerClientThread(threadSocket, this);
        thread.start();
        System.out.println(Terminal.CYAN + "Пользователь подключён");
        threads.add(thread);

    }
    public void postMessage(String message, ServerClientThread who){
        for (ServerClientThread clientThread: threads){
            if(clientThread == who) continue;
            clientThread.writeMessage(message);
            System.out.println("Сообщения отправлено");
        }
    }

    public static void sendMessage(String message, ServerClientThread client){
        for(ServerClientThread thread: threads){
            if(client == thread){
                continue;
            }
            thread.writeMessage(message);
        }
    }

}
