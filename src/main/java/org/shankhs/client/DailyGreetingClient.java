package org.shankhs.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyGreetingClient {
    private static final int PORT = 10000;

    public static void main(String[] args) {
        DailyGreetingClient dailyGreetingClient = new DailyGreetingClient();
        dailyGreetingClient.go();
    }

    private void go() {
        try {
            Socket socket = new Socket("127.0.0.1", PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            System.out.println(reader.readLine());

            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
