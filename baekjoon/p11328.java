package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st  = new StringTokenizer(br.readLine());
            List<Character> list1 = new ArrayList<>();
            List<Character> list2 = new ArrayList<>();
            for(char c: st.nextToken().toCharArray()) list1.add(c);
            for(char c: st.nextToken().toCharArray()) list2.add(c);
            Collections.sort(list1);
            Collections.sort(list2);

            while(!list1.isEmpty() && !list2.isEmpty()){
                if(list1.remove(0) != list2.get(0)) break;
                list2.remove(0);
            }

            if(list2.isEmpty()) sb.append("Possible").append('\n');
            else sb.append("Impossible").append('\n');

        }
        System.out.println(sb);
    }
}
