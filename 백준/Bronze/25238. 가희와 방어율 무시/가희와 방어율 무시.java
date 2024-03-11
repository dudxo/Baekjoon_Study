import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double m_defense = Integer.parseInt(st.nextToken());
        double u_defense = Integer.parseInt(st.nextToken());
        bw.write(calculate(m_defense, u_defense));
        bw.flush();
        bw.close();
    }

    static String calculate(double m_defense, double u_defense) {
        double real_defense = 0.0;
        real_defense = m_defense - (m_defense * u_defense / 100);

        if (real_defense >= 100) return "0";
        return "1";
    }
}
