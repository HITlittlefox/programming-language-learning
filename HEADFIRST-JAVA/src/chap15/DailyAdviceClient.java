package chap15;

import java.io.*;
import java.net.*;//Socket是在java.net下面
import java.util.stream.IntStream;

public class DailyAdviceClient {
    public void go() {
        try {//perhaps happend something
            //connect to port4242
            Socket s = new Socket("127.0.0.1", 4242);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            //connect to data stream
            BufferedReader reader = new BufferedReader(streamReader);
            //this resource of readline() is same of file
            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        for (int i = 0; i < 100; i++) {
            client.go();
        }
    }
}
