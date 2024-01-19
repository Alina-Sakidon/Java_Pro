package HW11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Server {
    private static final List<Character> RU_SYMBOLS = Arrays.asList('ы', 'ъ', 'ё', 'э');

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket accept = serverSocket.accept();
        System.out.println("Connection accepted.");
        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = accept.getOutputStream();

        String line;
        boolean isTrakingAnswer = false;
        while (!(line = bufferedReader.readLine()).toLowerCase(Locale.ROOT).equals("exit")) {
            System.out.println(String.format("CLIENT: %s", line));
            if (isContainsRuSymbols(line)) {
                sendMessage("SERVER: Що таке паляниця?", outputStream);
                isTrakingAnswer = true;
                continue;
            }
            if (line.toLowerCase(Locale.ROOT).equals("хліб")) {
                sendMessage(String.format("SERVER: Сьогоднішня дата і час, %s.  Гудбай!", LocalDateTime.now()), outputStream);
                isTrakingAnswer = false;
            } else if (isTrakingAnswer) {
                break;
            }
            if (line.equals("hello")) {
                sendMessage("SERVER: Привіт!", outputStream);
            }
        }
        System.out.println("Server closed");
        serverSocket.close();
    }

    private static boolean isContainsRuSymbols(String message) {
        for (Character s :
                message.toCharArray()) {
            if (RU_SYMBOLS.contains(s)) return true;
        }
        return false;
    }

    private static void sendMessage(String message, OutputStream outputStream) throws InterruptedException {
        PrintWriter out = new PrintWriter(outputStream, true);
        out.println(message);
        out.flush();
        Thread.sleep(500);
        System.out.println(message);
    }
}
