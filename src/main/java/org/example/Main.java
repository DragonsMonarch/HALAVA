package org.example;

import org.example.Interface.Terminal;
import org.example.Network.Client;
import org.example.Network.server.Server;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Terminal.chooseServerClient();

        int answer = scanner.nextInt();

        if(answer == 1){
            Server server = new Server();
            try{
                server.createServer(10202, 3);
                server.run();
            } catch (IOException e){

            }
        }
        else {

            Terminal.clientAuthorization();;
            String Nickname = Terminal.menuNickname();
            String IpAddr = Terminal.menuIpAddr();
            int PORT;
            while (true){
                PORT = Terminal.menuPORT();
                if(!(PORT > 49151 && PORT < 65535)) break;
                Terminal.error("Порт должен быть от 49152 до 65535");
            }
            Terminal.parsers();
            Terminal.instruction();
            Client client = new Client();
            try{
                client.startClient(IpAddr, PORT, Nickname) ;
            }catch (IOException e){
            }
        }

    }
}