package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1976 {
    static int[] par;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        par = new int[N+1];
        for(int i=0;i<N+1;i++){
            par[i] = i;
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    par[find(i)] = find(j);
                }
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        int first = Integer.parseInt(st.nextToken());
        for(int i=0;i<M-1;i++){
            int next = par[find((Integer.parseInt(st.nextToken())))];
            if(par[find(first)] != next){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
    static int find(int n){
        if(par[n] == n) return n;
        return par[n] = find(par[n]);
    }
}
