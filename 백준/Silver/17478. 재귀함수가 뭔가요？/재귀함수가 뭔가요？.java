import java.io.*;

public class Main {

    static int N;
    static String[] cmd = new String[] {
        "\"재귀함수가 뭔가요?\"\n", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
        "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
        "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"
    };
    static String[] cmd2 = new String[] {"\"재귀함수가 뭔가요?\"\n", "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"};
    static String cmd3 = new String("라고 답변하였지.\n");

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int k = 0;

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        jagi(sb, N, k);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    private static void jagi(StringBuilder sb, int n, int k) {
        if(n == 0) {
            for(int j = 0; j < cmd2.length; j++) {
                for(int t = k; t > 0; t--) {
                    sb.append("_");
                }
                sb.append(cmd2[j]);
            }
            for(int t = k; t > 0; t--) {
                sb.append("_");
            }
            sb.append(cmd3);
            return;
        }

        for(int j = 0; j < cmd.length; j++) {
            for(int t = k; t > 0; t--) {
                sb.append("_");
            }
            sb.append(cmd[j]);
        }
        jagi(sb, n-1, k+4);

        for(int t = k; t > 0; t--) {
            sb.append("_");
        }
        sb.append(cmd3);
    }

}
