import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 블록을 쌓을 배열
        int[] arr = new int[n + 2]; // n + 2 (b == n인 경우를 방지하기 위함)
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // arr[a]는 증가, arr[b + 1]은 감소
            arr[a]++;
            arr[b + 1]--;
        }
        br.close();

        // 누적합을 완성된 블록 배열 만들기
        for (int i = 1; i <= n + 1; i++) {
            arr[i] += arr[i-1];
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 배열의 여분을 제외한 중간 인덱스의 값
        bw.write(String.valueOf(arr[arr.length / 2 + 1]));
        bw.flush();
        bw.close();
    }
}