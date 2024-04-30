import java.io.*;
import java.util.*;

public class Main {
    public static int[] dr = {0, -1, 0, 1};
    public static int[] dc = {-1, 0, 1, 0};
    public static boolean[][] isMove;
    public static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        isMove = new boolean[5][5];
        int moveCnt = 23;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            isMove[r][c] = true;
            moveCnt--;
        }

        answer = 0;
        isMove[0][0] = true;
        isMove[4][4] = true;
        dfs(0, 0, 4, 4, moveCnt, true);
        System.out.println(answer);

        
    }

    public static void dfs(int ar, int ac, int br, int bc, int moveCnt, boolean flag){

        if(flag){
            for(int i = 0; i < 4; i++){
                int nr = ar + dr[i];
                int nc = ac + dc[i];

                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || isMove[nr][nc]) continue;
                isMove[nr][nc] = true;
                dfs(nr, nc, br, bc, moveCnt - 1, !flag);
                isMove[nr][nc] = false;
            }
        }
        else{
            for(int i = 0; i < 4; i++){
                int nr = br + dr[i];
                int nc = bc + dc[i];

                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                if(moveCnt == 0){
                    if(ar == nr && ac == nc){
                        answer++;
                        return;
                    }
                    else continue;
                }
                if(isMove[nr][nc]) continue;
                isMove[nr][nc] = true;
                dfs(ar, ac, nr, nc, moveCnt - 1, !flag);
                isMove[nr][nc] = false;
            }
        }
        
    }
}