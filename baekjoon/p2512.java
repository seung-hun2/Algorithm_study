package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[n];
        int left = 0, right = -1;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }
        int total = Integer.parseInt(br.readLine());

        while(left <= right){
            long pre=0;
            int mid = (left+right)/2;

            for(int i=0;i<n;i++){
                if( arr[i] >= mid ) pre += mid;
                else pre += arr[i];
            }

            if( pre <= total ){ // total 이 네 수의 합보다 작을 때
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(right);

    }
}
