import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer str;
    static int checkArr[], myArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(str.nextToken());  //DNA 문자열 길이
        int P = Integer.parseInt(str.nextToken());  //부분 문자열 길이
        int Result = 0;     //가능한 총 개수
        char[] A = new char[S];     //DNA 문자열
        checkArr = new int[4];      //조건의 최소 개수 배열
        myArr = new int[4];         //부분 문자열
        checkSecret = 0;            //각 문자의 조건을 만족했는지 확인하는 변수

        A = br.readLine().toCharArray();
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){     //조건의 최소 개수를 배열에 넣는다
            checkArr[i] = Integer.parseInt(str.nextToken());
            if(checkArr[i] == 0){       //만약 조건이 0인 알파벳은 따로 검사하지 않아도 되는거니, checkSecret을 바로 카운트
                checkSecret++;
            }
        }
        for(int i = 0; i < P; i++){     //초기 P만큼의 부분 문자열
            Add(A[i]);
        }
        if(checkSecret == 4){       //초기 부분 문자열이 조건이 충족하면 카운트 증가
            Result++;
        }

        //슬라이딩 윈도우
        for(int i = P; i < S; i++){
            int j = i - P;      //P가 뒤로 한칸 이동함에 따라 맨 앞 부분을 지우기 위해 계산되는 변수
            Add(A[i]);      //P가 뒤로 한칸 이동하여 새로 입력되는 문자
            Remove(A[j]);       //P가 뒤로 한칸 이동하여 삭제되는 가장 맨 앞 문자
            if(checkSecret == 4){       //조건이 만족하면 카운트
                Result++;
            }
        }
        bw.write(String.valueOf(Result));
        bw.flush();
        bw.close();
    }

    //새로운 문자 추가 메서드
    private static void Add(char c){
        switch (c){
            case 'A':       //해당하는 문자로 가서
                myArr[0]++;     //해당 문자의 개수 카운트
                if(myArr[0] == checkArr[0]){        //해당 문자 개수가 조건 개수와 같을 때 checkSecret 카운트
                    checkSecret++;                  //해당 문자 개수가 조건 개수보다 큰건 의미가 없기 때문에 같을 때만 카운트함!
                }
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]){
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]){
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]){
                    checkSecret++;
                }
                break;
        }
    }

    //기존 맨 앞 문자 삭제 메서드
    private static void Remove(char c){
        switch (c){
            case 'A':
                if(myArr[0] == checkArr[0]){        //삭제 전 해당 문자 개수와 조건 개수가 일치했다면 checkSecret이 카운트 되었기 때문에
                    checkSecret--;                  //먼저 checkSecret을 감소시키고, 기존 문자 삭제
                }
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]){
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]){
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]){
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}