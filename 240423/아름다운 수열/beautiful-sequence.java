import java.util.*;
import java.io.*;

public class Main {
    // A의 연속 부분 수열 중 B의 수열과 패턴이 일치하는 연속 부분 수열 찾기
    // A의 연속 부분 수열을 고른 후 정렬한 뒤 B와 비교했을 때 인덱스가 동일하게 차이나야 아름다은 수열
    static List<Integer> A;
    static List<Integer> B;
    public static void main(String[] args) throws IOException{
        A = new ArrayList<>();
        B = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값 받기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            A.add(num);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            B.add(num);
        }

        // 부분 수열과 비교할 수 있도록 미리 B를 정렬
        Collections.sort(B);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i + M <= N; i++){
            List<Integer> part = new ArrayList<>();
            for(int j = 0; j < M; j++){
                part.add(A.get(i + j));
            }
            Collections.sort(part);

            if(isBeautiful(part)) {
                cnt++;
                sb.append(i + 1).append("\n");
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    public static boolean isBeautiful(List<Integer> part){
        int diff = part.get(0) - B.get(0);
        for(int i = 1; i < part.size(); i++){
            if(part.get(i) - B.get(i) != diff) {
                return false;
            }
        }
        return true;
    }
}