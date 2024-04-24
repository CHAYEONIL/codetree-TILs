import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input_2 = br.readLine();
        int[] arr = new int[input_2.length()];
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < input_2.length(); i++){
            char c = input_2.charAt(i);
            if (c == '1') c = '0';
            else if(c == '0') c = '1';

            // 비트 반전시킨 이진수 문자열 binary 변수에 저장
            String binary = input_2.substring(0, i) + c + input_2.substring(i+1); 
            
            // 2진수 → 10진수로 변환하여 배열에 저장
            arr[i] = Integer.parseInt(binary, 2);
        }

    // 배열에 저장된 10진수 값 중 최대값 찾아 출력
        for(int i = 0; i < input_2.length(); i++)
        res = Math.max(res, arr[i]);
        System.out.print(res);
    }
}