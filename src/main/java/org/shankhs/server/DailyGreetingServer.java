package org.shankhs.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyGreetingServer {

    private static final int PORT = 10000;

    private String[] greetings = new String[]{
            "Hi!", "Hello!", "Good Morning!", "How you doing?!",
            "Good Evening!", "Good Night!", "Sweet Dreams!"
    };

    public static void main(String[] args) {
        DailyGreetingServer dailyGreetingServer = new DailyGreetingServer();
        dailyGreetingServer.go();
    }

    private void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();

                System.out.println("Client connected...");

                PrintWriter printWriter
                        = new PrintWriter(clientSocket.getOutputStream());
                printWriter.println(getGreeting());
                printWriter.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getGreeting() {
        return greetings[(int) (Math.random() * greetings.length)];
    }

}
