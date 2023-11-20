package org.example.Network.server;

import org.example.Interface.Terminal;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable{
    private static ServerFactory factory = new ServerFactory();
    private static ServerSocket server;


    public static void createServer(int port, int limit) throws  IOException{
        server = new ServerSocket(port, limit);
        System.out.println(Terminal.CYAN+"++++++++++++++++++++++++++++++\n Сервер создан на порту " + port + "\n++++++++++++++++++++++++++++++");
    }

    public static void createServer(int port) throws IOException {
        createServer(port, 25);
    }

    @Override
    public void run(){
        while(!server.isClosed()){
            try {
                System.out.println("Ждём приёма");
                factory.createThread(server.accept());
            } catch (IOException e){
                System.out.println(Terminal.RED + "Ошибка подключения пользователя");
            }

        }
    }
}
