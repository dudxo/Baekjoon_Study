import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LocalDate now = LocalDate.now();

        bw.write(String.valueOf(now));
        bw.flush();
        bw.close();
    }
}