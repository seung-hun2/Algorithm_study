package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr= new int[10];
        String str = br.readLine();
        int max=0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)-'0' == 6){
                arr[9]++;
            }else{
                arr[str.charAt(i)-'0']++;
            }
        }
        for(int i=0;i<9;i++){
            max = Math.max(max,arr[i]);
        }
        int nine = arr[9]/2;
        if(arr[9]%2 == 1) nine++;
        max = Math.max(max,nine);
        System.out.println(max);



    }
}
