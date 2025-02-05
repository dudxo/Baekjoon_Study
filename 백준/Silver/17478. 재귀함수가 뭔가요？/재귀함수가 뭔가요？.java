import java.io.*;

public class Main {

    static int N;
    static final String UNDER_BAR = "____";
    static String[] cmd = new String[] {
        "\"재귀함수가 뭔가요?\"\n",
        "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
        "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
        "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
        "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n",
        "라고 답변하였지.\n"
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int k = 0;

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        jagi(sb, 0);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    private static void jagi(StringBuilder sb, int n) {
    	String prefix = generatePrefix(n);
        if(n == N) {
            sb.append(prefix).append(cmd[0]).append(prefix).append(cmd[4]).append(prefix).append(cmd[5]);
            return;
        }

        sb.append(prefix).append(cmd[0]).append(prefix).append(cmd[1]).append(prefix).append(cmd[2]).append(prefix).append(cmd[3]);
        jagi(sb, n+1);
        sb.append(prefix).append(cmd[5]);
    }
    
    private static String generatePrefix(int count) {
    	if(count == 0 ) {
    		return "";
    	}
    	return UNDER_BAR.repeat(count);
    }
}