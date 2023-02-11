package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        String str = br.readLine();
        String str2 = br.readLine();
        int count=0;

        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-'a']++;
        }
        for(int i=0;i<str2.length();i++){
            arr[str2.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                if(arr[i]<0){
                    count += -arr[i];
                }else{
                    count += arr[i];
                }
            }
        }

        System.out.println(count);

    }
}
