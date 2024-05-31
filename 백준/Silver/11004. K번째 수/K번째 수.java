import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int start_index, end_index;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        arr = new int[N];
        str = new StringTokenizer(br.readLine());
        br.close();

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        //퀵정렬
        quickSort(arr, 0 , N-1, K-1);
        bw.write(String.valueOf(arr[K-1]));
        bw.flush();
        bw.close();
    }

    //퀵정렬
    public static void quickSort(int[] A, int S, int E, int K){
        if(S < E) {
            int pivot = partition(A, S, E);
            if(pivot == K){     //K 번째 수가 pivot이면 더이상 정렬할 필요 없음
                return;
            } else if(K < pivot){       //K가 pivot보다 작으면 왼쪽 그룹만 정렬 수행
                quickSort(A, S, pivot - 1, K);
            } else {        //K가 pivot보다 크면 오른쪽 그룹만 정렬 수행
                quickSort(A, pivot+1, E, K);
            }
        }
    }

    //피벗구하기
    public static int partition(int[] A, int S, int E){
        //데이터가 2개인 경우 비교하여 정렬
        if(S + 1 == E){
            if(A[S] > A[E])
                swap(A, S, E);
            return E;
        }

        //가운데를 pivot으로 잡고 이동을 편하게 하기 위해 맨 앞 값과 swap
        int M = (S+E)/2;
        swap(A, S, M);
        int pivot = A[S];        //가장 맨 앞이 pivot이 되고
        int i = S + 1, j = E;       //pivot 바로 다음 값과 맨 끝값을 결정하여 정렬
        while(i <= j){      //두 index가 만날때까지 반복
            while(j >= S + 1 && pivot < A[j]){      //피벗보다 작은 수가 나올 때까지
                j--;
            }
            while(i <= E && pivot > A[i]){      //피벗보다 큰 수가 나올 때까지
                i++;
            }
            if(i <= j){
                swap(A, i++, j--);
            }
        }

        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}