package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[7];
        int count = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 1이면 1저장 0이면 10000저장
            if(s == 1){
                arr[y]++;
            }else{
                arr[y] += 10000;
            }
        }
        for(int i=1;i<7;i++){
            int wm = arr[i]/10000;
            int m  = arr[i]%10000;

            count += wm/k;
            count += m/k;
            if(wm%k!=0) count++;
            if(m%k!=0) count++;
        }
        System.out.println(count);

    }
}
