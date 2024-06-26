import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> list;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(new  ArrayList<>());
        }
        // 하나의 숫자를 받아서 자리수를 분리하여 리스트에 저장
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            while(num > 0){
                int a = num % 10;
                num /= 10;
                list.get(i).add(a);
            }
        }

        int[] sum = new int[9];
        answer = 0;
        backTracking(0, 0, sum);
        System.out.println(answer);
    }

    public static void backTracking(int cnt, int idx, int[] sum){
        // 현재 더한 숫자의 개수를 최대로 갱신
        if(cnt > answer) {
            answer = cnt;
        }

        for(int i = idx; i < list.size(); i++){
            List<Integer> l1 = list.get(i);
            if(isPossible(l1, sum)){
                int[] nSum = sum.clone();
                for(int j = 0; j < l1.size(); j++){
                    nSum[j] += l1.get(j);
                }
                backTracking(cnt + 1, i + 1, nSum);
            }
        }
    }

    // 각 자리수 계산
    public static boolean isPossible(List<Integer> l1, int[] sum){
        for(int i = 0; i < l1.size(); i++){
            if(sum[i] + l1.get(i) >= 10)
                return false;
        }

        return true;
    }
}